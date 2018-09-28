package com.gillsoft.client;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.net.ssl.TrustManager;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

import org.apache.axis2.java.security.TrustAllTrustManager;
import org.apache.commons.lang.time.DateUtils;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.logging.log4j.core.util.datetime.FastDateFormat;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.gillsoft.cache.CacheHandler;
import com.gillsoft.cache.IOCacheException;
import com.gillsoft.cache.RedisMemoryCache;
import com.gillsoft.logging.RequestResponseLoggingInterceptor;
import com.gillsoft.model.BuseuropeLoggingInInterceptor;
import com.gillsoft.model.BuseuropeLoggingOutInterceptor;
import com.gillsoft.model.BuybackInfoXMLType;
import com.gillsoft.model.Channel;
import com.gillsoft.model.Channel.Group.Threads.Thread.Schedules.Schedule;
import com.gillsoft.model.Channel.Group.Threads.Thread.Stoppoints.Stoppoint;
import com.gillsoft.model.Currency;
import com.gillsoft.model.FromToDates;
import com.gillsoft.model.IdentificationDocumentType;
import com.gillsoft.model.Lang;
import com.gillsoft.model.Locality;
import com.gillsoft.model.OrderXMLType;
import com.gillsoft.model.Organisation;
import com.gillsoft.model.Price;
import com.gillsoft.model.RaceInfoXMLTypeArray;
import com.gillsoft.model.RaceSeatXMLTypeArray;
import com.gillsoft.model.Regularity;
import com.gillsoft.model.RestError;
import com.gillsoft.model.RoutePoint;
import com.gillsoft.model.ScheduleRoute;
import com.gillsoft.model.SearchStatXMLType;
import com.gillsoft.model.Seat;
import com.gillsoft.model.SeatStatus;
import com.gillsoft.model.SeatType;
import com.gillsoft.model.ServiceAppException_Exception;
import com.gillsoft.model.StopXMLType;
import com.gillsoft.model.StopXMLTypeArray;
import com.gillsoft.model.SubAgentWebService;
import com.gillsoft.model.SubAgentWebService_Service;
import com.gillsoft.model.TicketXMLType;
import com.gillsoft.model.response.ScheduleResponse;
import com.gillsoft.util.RestTemplateUtil;
import com.gillsoft.util.StringUtil;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RestClient {

	public static final String STATIONS_CACHE_KEY = "buseurope.stations.";
	public static final String TRIPS_CACHE_KEY = "buseurope.trips.";
	public static final String SCHEDULE_CACHE_KEY = "buseurope.schedule.";

	public static final String DATE_FORMAT_BIRTHDAY = "dd/MM/yyyy";
	public static final FastDateFormat dateFormatBirthday = FastDateFormat.getInstance(DATE_FORMAT_BIRTHDAY);
	public static final BigDecimal MULTIPLICAND = new BigDecimal("0.01");

	private static String localIpAddress;
	private static final String PAY_STATE = "P";

	@Autowired
	@Qualifier("RedisMemoryCache")
	private CacheHandler cache;
	
	private RestTemplate template;

	private static SubAgentWebService port = null;
	
	static {
		if (RestClient.port == null) {
			try {
				RestClient.port = new SubAgentWebService_Service().getSubAgentWebServicePort();
				// создаем сервис для работы в сессии
				((BindingProvider) RestClient.port).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
				// включаем логирование
				Client client = ClientProxy.getClient(RestClient.port);
				client.getOutInterceptors().add(new BuseuropeLoggingOutInterceptor(new CopyOnWriteArraySet<>()));
				client.getInInterceptors().add(new BuseuropeLoggingInInterceptor(new CopyOnWriteArraySet<>()));
				// устанавливаем дополнительные параметры
				client.getRequestContext().put("use.async.http.conduit", Boolean.TRUE);
				client.getRequestContext().put("org.apache.cxf.transport.http.async.SO_TIMEOUT", 3000);
				client.getRequestContext().put("org.apache.cxf.transport.http.async.MAX_CONNECTIONS", 300);
				client.getRequestContext().put("org.apache.cxf.transport.http.async.MAX_PER_HOST_CONNECTIONS", 300);
				client.getRequestContext().put("org.apache.cxf.transport.http.async.usePolicy", "ASYNC_ONLY");
				// отключаем проверку
				HTTPConduit http = (HTTPConduit) client.getConduit();
				TLSClientParameters param = new TLSClientParameters();
				param.setDisableCNCheck(true);
				http.setTlsClientParameters(param);
				http.getTlsClientParameters().setTrustManagers(new TrustManager[] { new TrustAllTrustManager() });
				HTTPClientPolicy policy = http.getClient();
				policy.setConnectionTimeout(3000);
				policy.setReceiveTimeout(3000);
				// логинимся и создаем объекты доступа к данным
				if (RestClient.port.login(Config.getLogin(), Config.getPassword())) {
					policy.setReceiveTimeout(Config.getRequestTimeout());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				RestClient.localIpAddress = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
				RestClient.localIpAddress = Config.getLocalIpAddress();
			}
		}
	}

	public RestClient() {
		template = createNewPoolingTemplate(Config.getRequestTimeout());
	}
	
	public RestTemplate createNewPoolingTemplate(int requestTimeout) {
		RestTemplate template = new RestTemplate(new BufferingClientHttpRequestFactory(
				RestTemplateUtil.createPoolingFactory(Config.getUrlSchedule(), 300, requestTimeout)));
		template.setMessageConverters(RestTemplateUtil.getMarshallingMessageConverters(Channel.class));
		template.setInterceptors(Collections.singletonList(
				new RequestResponseLoggingInterceptor(Charset.forName("utf-8")) {

					@Override
					public ClientHttpResponse execute(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
							throws IOException {
						ClientHttpResponse clientHttpResponse = execution.execute(request, body);
						HttpHeaders headers = clientHttpResponse.getHeaders();
						List<String> headersContentType = headers.get("Content-Type");
						if (headersContentType.contains("text/xml")) {
							headersContentType.remove("text/xml");
							headersContentType.add("application/xml");
						}
						return clientHttpResponse;
					}

				}));
		return template;
	}

	/****************** STATIONS ********************/
	@SuppressWarnings("unchecked")
	public List<Entry<Locality, List<String>>> getCachedStations() throws IOCacheException {
		Map<String, Object> params = new HashMap<>();
		params.put(RedisMemoryCache.OBJECT_NAME, RestClient.STATIONS_CACHE_KEY);
		params.put(RedisMemoryCache.IGNORE_AGE, true);
		params.put(RedisMemoryCache.UPDATE_DELAY, Config.getCacheStationsUpdateDelay());
		params.put(RedisMemoryCache.UPDATE_TASK, new UpdateTaskStations());
		// load schedule
		getCachedSchedule();
		return (List<Entry<Locality, List<String>>>) cache.read(params);
	}

	public List<Entry<Locality, List<String>>> getAllStations() throws ResponseError {
		List<Entry<Locality, List<String>>> localities = new ArrayList<>();
		Map<String, Locality> parentLocalities = new HashMap<>();
	      try {
	    	  StopXMLTypeArray stops = port.getStops(-1);
	    	  for (StopXMLType stop : stops.getItem()) {
	    		  Locality newLocality = new Locality(String.valueOf(stop.getStopID()));
	    		  Locality parentLocality = null;
	    		  newLocality.setName(Lang.EN, stop.getStopName());
	    		  localities.add(new AbstractMap.SimpleEntry<Locality, List<String>>(newLocality, null));
	    		  parentLocality = parentLocalities.get(stop.getCountryCode());
	    		  if (parentLocality == null) {
	    			  parentLocality = new Locality(String.valueOf(stop.getCountryCode()));
	    			  parentLocality.setName(Lang.EN, stop.getCountryCode());
	    			  localities.add(new AbstractMap.SimpleEntry<Locality, List<String>>(parentLocality, null));
	    			  newLocality.setParent(new Locality(String.valueOf(stop.getCountryCode())));
		    		  parentLocalities.put(stop.getCountryCode(), newLocality.getParent());
	    		  } else {
	    			  newLocality.setParent(parentLocality);
	    		  }
	    	  }
	      } catch (ServiceAppException_Exception e) {
	    	  e.printStackTrace();
	      }
	      try {
	    	  createSchedule(getCachedSchedule(), localities);
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	      return localities;
	}

	private ConcurrentMap<String, FromToDates> createSchedule(Channel channel, List<Entry<Locality, List<String>>> localities) {
		ConcurrentMap<String, FromToDates> schedule = new ConcurrentHashMap<>();
		Map<String, Set<String>> mapFromTo = new HashMap<>();
		for (Channel.Group.Threads.Thread thread : channel.getGroup().getThreads().getThread()) {
			FromToDates newFromToDates = createFromToDates(thread.getSchedules().getSchedule());
			for (int i = 0; i < thread.getStoppoints().getStoppoint().size(); i++) {
				Stoppoint first = thread.getStoppoints().getStoppoint().get(i);
				for (int j = 0; j < thread.getStoppoints().getStoppoint().size(); j++) {
					Stoppoint second = thread.getStoppoints().getStoppoint().get(j);
					if (first.getArrivalShift() < second.getArrivalShift()) {
						FromToDates fromToDates = schedule
								.get(first.getStationCode() + ";" + second.getStationCode());
						if (fromToDates == null) {
							schedule.put(first.getStationCode() + ";" + second.getStationCode(), newFromToDates);
						} else {
							fromToDates.union(newFromToDates);
						}
						Set<String> listTo = mapFromTo.get(String.valueOf(first.getStationCode()));
						if (listTo == null) {
							listTo = new HashSet<>();
							mapFromTo.put(String.valueOf(first.getStationCode()), listTo);
						}
						listTo.add(String.valueOf(second.getStationCode()));
					}
				}
			}
		}
		localities.stream().filter(f -> mapFromTo.containsKey(f.getKey().getId()))
				.forEach(e -> e.setValue(Arrays.asList(mapFromTo.get(e.getKey().getId()).toArray(new String[0]))));
		return schedule;
	}

	private FromToDates createFromToDates(Schedule schedule) {
		FromToDates fromToDates = new FromToDates();
		fromToDates.setDays(schedule.getDays());
		fromToDates.setFrom(getDate(schedule.getPeriodStartDate()));
		fromToDates.setTo(getDate(schedule.getPeriodEndDate()));
		return fromToDates;
	}

	private Calendar getDate(String date) {
		Calendar time = Calendar.getInstance();
		try {
			time.setTime(StringUtil.dateFormat.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return DateUtils.truncate(time, Calendar.DATE);
	}
	
	/****************** SCHEDULE *****************/
	public Channel getCachedSchedule() throws IOCacheException {
		Map<String, Object> params = new HashMap<>();
		params.put(RedisMemoryCache.OBJECT_NAME, RestClient.SCHEDULE_CACHE_KEY);
		params.put(RedisMemoryCache.IGNORE_AGE, true);
		params.put(RedisMemoryCache.UPDATE_DELAY, Config.getCacheScheduleUpdateDelay());
		params.put(RedisMemoryCache.UPDATE_TASK, new UpdateTaskSchedule());
		return (Channel) cache.read(params);
	}
	
	public Channel loadSchedule() {
		try {
			return template.getForObject(Config.getUrlSchedule(), Channel.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String addScheduleCarrier(Channel.Group.Threads.Thread thread, ScheduleResponse scheduleResponse) {
		if (scheduleResponse.getOrganisations() == null) {
			scheduleResponse.setOrganisations(new HashMap<>());
		}
		String key = StringUtil.md5(thread.getCarrierTitle());
		if (!scheduleResponse.getOrganisations().containsKey(key)) {
			Organisation carrier = new Organisation(key);
			carrier.setName(Lang.valueOf(thread.getLanguage()), thread.getCarrierTitle());
			scheduleResponse.getOrganisations().put(key, carrier);
		}
		return key;
	}

	public void addScheduleRoute(List<Channel.Group.Threads.Thread> threads, ScheduleResponse scheduleResponse) {
		threads.stream().forEach(thread -> {
			FastDateFormat timeFormat = FastDateFormat.getInstance("HH:mm");
			ScheduleRoute route = new ScheduleRoute();
			Calendar time = Calendar.getInstance();
			route.setName(Lang.valueOf(thread.getLanguage()), thread.getTitle());
			route.setCarrier(new Organisation(addScheduleCarrier(thread, scheduleResponse)));
			route.setStartedAt(getScheduleDateTime(thread.getSchedules().getSchedule().getPeriodStartDate(),
					thread.getSchedules().getSchedule().getPeriodStartTime()));
			route.setEndedAt(getScheduleDateTime(thread.getSchedules().getSchedule().getPeriodEndDate(),
					thread.getSchedules().getSchedule().getPeriodEndTime()));
			getScheduleRegularity(thread, route);
			List<RoutePoint> path = new ArrayList<>();
			Date[] departureTime = new Date[] { null };
			try {
				departureTime[0] = timeFormat.parse(thread.getSchedules().getSchedule().getTimes());
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			thread.getStoppoints().getStoppoint().stream().forEach(c -> {
				RoutePoint point = new RoutePoint(String.valueOf(c.getStationCode()));
				point.setLocality(new Locality(String.valueOf(c.getStationCode())));
				if (c.getDepartureShift() != null) {
					time.setTime(departureTime[0]);
					time.add(Calendar.SECOND, c.getDepartureShift());
					point.setDepartureTime(c.getDepartureShift() == 0 ? thread.getSchedules().getSchedule().getTimes()
							: timeFormat.format(time.getTime()));
				}
				if (c.getArrivalShift() != null && (c.getDepartureShift() == null
						|| (c.getDepartureShift() != null && c.getDepartureShift() != 0))) {
					time.setTime(departureTime[0]);
					time.add(Calendar.SECOND, c.getArrivalShift());
					point.setArrivalTime(c.getArrivalShift() == 0 ? thread.getSchedules().getSchedule().getTimes()
							: timeFormat.format(time.getTime()));
				}
				point.setArrivalDay(
						Days.daysBetween(LocalDate.fromDateFields(departureTime[0]), LocalDate.fromDateFields(time.getTime()))
						.getDays());
				path.add(point);
			});
			route.setPath(path);
			if (scheduleResponse.getRoutes() == null) {
				scheduleResponse.setRoutes(new ArrayList<>());
			}
			scheduleResponse.getRoutes().add(route);
		});
	}

	private void getScheduleRegularity(Channel.Group.Threads.Thread thread, ScheduleRoute route) {
		String days = thread.getSchedules().getSchedule().getDays();
		switch (days) {
		case "1234567":
			route.setRegularity(Regularity.EVERY_DAY);
			break;
		case "через день":
			route.setRegularity(Regularity.DAY_BY_DAY);
			break;
		default:
			if (days.replaceAll("\\d", "").isEmpty()) {
				route.setRegularity(Regularity.DAYS_OF_THE_WEEK);
				if (route.getRegularityDays() == null) {
					route.setRegularityDays(new ArrayList<>());
				}
				if (days.length() == 1) {
					route.setRegularityDays(Arrays.asList(Integer.parseInt(days)));
				} else {
					for (int i = 0; i < days.length(); i++) {
						route.getRegularityDays().add(Character.getNumericValue(days.charAt(i)));
					}
				}
			} else {
				if (route.getAdditionals() == null) {
					route.setAdditionals(new HashMap<>());
				}
				route.getAdditionals().put("REGULARITY",  days);
			}
		}
	}

	private Date getScheduleDateTime(String date, String time) {
		try {
			return StringUtil.fullDateFormat.parse(date + ' ' + time);
		} catch (Exception e) {
			return null;
		}
	}

	/****************** SEATS ********************/
	public List<Seat> getSeats(Long raceId) throws ResponseError {
		List<Seat> seats = new ArrayList<>();
		try {
			RaceSeatXMLTypeArray raceSeat = port.getRaceFreeSeats(raceId);
			if (raceSeat != null && raceSeat.getItem() != null && !raceSeat.getItem().isEmpty()) {
				raceSeat.getItem().stream().filter(f -> f.isSeat()).forEach(c -> seats.add(createSeat(c.getSeatNumber(), c.getSeatName())));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seats;
	}
	
	private Seat createSeat(String seatId, String seatName) {
		Seat newSeat = new Seat();
		newSeat.setId(seatId);
		newSeat.setNumber(seatName);
		newSeat.setStatus(SeatStatus.FREE);
		newSeat.setType(SeatType.SEAT);
		return newSeat;
	}

	/****************** TRIPS ********************/
	public TripPackage getCachedTrips(String from, String to, Date dispatch) throws ResponseError {
		TripsTaskKey key = new TripsTaskKey(from, to, dispatch);
		Map<String, Object> params = new HashMap<>();
		params.put(RedisMemoryCache.OBJECT_NAME, key.toString());
		params.put(RedisMemoryCache.UPDATE_TASK, new UpdateTaskTrips(key));
		try {
			return (TripPackage) cache.read(params);
		} catch (IOCacheException e) {
			e.printStackTrace();
			// ставим пометку, что кэш еще формируется
			TripPackage tripPackage = new TripPackage();
			tripPackage.setContinueSearch(true);
			return tripPackage;
		} catch (Exception e) {
			throw new ResponseError(e.getMessage());
		}
	}

	public TripPackage findRace(TripsTaskKey key) throws ResponseError {
		try {
			XMLGregorianCalendar xmlDate = null;
			try {
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(key.getDate());
				xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
			SearchStatXMLType searchStat = port.searchRacesWithSearchStat(key.getCityStartInt(), key.getCityEndInt(), xmlDate);
			int count = 10;
			do {
				Thread.sleep(1000);
			} while (!port.isSearchComplete(searchStat) && count-- != 0);
			RaceInfoXMLTypeArray raceInfo = port.getFoundRaces(searchStat.getSearchId());
			return new TripPackage(raceInfo == null ? null : raceInfo.getItem());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseError(e.getMessage(), e);
		}
	}

	/****************** RESERVATION/PAY/CANCEL ********************/
	public void reserve(Map<String, List<OrderIdModelObject>> serviceMap, OrderIdModel orderIdModel)
			throws ResponseError {
		for (Entry<String, List<OrderIdModelObject>> mapEntry : serviceMap.entrySet()) {
			try {
				TripIdModel tripModel = new TripIdModel().create(mapEntry.getKey());
				GregorianCalendar startDate = new GregorianCalendar();
				startDate.setTime(tripModel.getDateStart());
				XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(startDate);
				OrderXMLType order = port.startSale(tripModel.getFromStopId(),
						tripModel.getToStopId(), tripModel.getRaceId(),
						xmlDate, mapEntry.getValue().size(), RestClient.localIpAddress,
						Locale.ENGLISH.getLanguage());
				if (order != null && !order.getDirectTickets().isEmpty()) {
					String mail = null;
					String phone = null;
					for (int i = 0; i < mapEntry.getValue().size(); i++) {
						TicketXMLType ticket = order.getDirectTickets().get(i);
						OrderIdModelObject orderIdModelObject = mapEntry.getValue().get(i);
						ticket.setSeatNumber(orderIdModelObject.getService().getSeat() != null
								&& orderIdModelObject.getService().getSeat().getId() != null
										? orderIdModelObject.getService().getSeat().getId() : null);
						ticket.setPassengerName(orderIdModelObject.getService().getCustomer().getName());
						ticket.setPassengerSurname(orderIdModelObject.getService().getCustomer().getSurname());
						ticket.setPassengerMiddlename(orderIdModelObject.getService().getCustomer().getPatronymic());
						ticket.setPassengerGender(orderIdModelObject.getService().getCustomer().getGender() != null
								? orderIdModelObject.getService().getCustomer().getGender().toString() : null);
						if (orderIdModelObject.getService().getCustomer().getCitizenship() != null) {
							ticket.setPassengerCitizenship(orderIdModelObject.getService().getCustomer().getCitizenship().getNumCode());
							ticket.setPassengerBirthplace(orderIdModelObject.getService().getCustomer().getCitizenship().getNumCode());
						}
						if (orderIdModelObject.getService().getCustomer().getDocumentType() != null && orderIdModelObject
								.getService().getCustomer().getDocumentType().equals(IdentificationDocumentType.FOREIGN_PASSPORT)) {
							ticket.setPassengerDocNum(orderIdModelObject.getService().getCustomer().getDocumentNumber());
							ticket.setPassengerDocSeries(orderIdModelObject.getService().getCustomer().getDocumentSeries());
						}
						if (orderIdModelObject.getService().getCustomer().getBirthday() != null) {
							ticket.setPassengerBirthday(
									dateFormatBirthday.format(orderIdModelObject.getService().getCustomer().getBirthday()));
						}
						ticket.setDiscountId("");
						if (mail == null && orderIdModelObject.getService().getCustomer().getEmail() != null
								&& !orderIdModelObject.getService().getCustomer().getEmail().trim().isEmpty()) {
							mail = orderIdModelObject.getService().getCustomer().getEmail().trim();
						}
						if (phone == null && orderIdModelObject.getService().getCustomer().getPhone() != null
								&& !orderIdModelObject.getService().getCustomer().getPhone().trim().isEmpty()) {
							phone = orderIdModelObject.getService().getCustomer().getPhone().trim();
						}
						orderIdModelObject.setTicketId(ticket.getTicketId());
					}
					order = port.reserve(order, mail != null ? mail : Config.getTicketEmail(),
							phone != null ? phone : "");
					List<OrderIdModelObject> list = orderIdModel.getServices().get(order.getDirectTickets().get(0).getSaleId());
					if (list == null) {
						list = new ArrayList<>();
						orderIdModel.getServices().put(order.getDirectTickets().get(0).getSaleId(), list);
					}
					mapEntry.getValue().stream().forEach(c -> c.getService().setConfirmed(true));
					list.addAll(mapEntry.getValue());
				}
			} catch (Exception e) {
				e.printStackTrace();
				mapEntry.getValue().stream().forEach(c -> {
					c.getService().setConfirmed(false);
					c.getService().setError(new RestError(e.getMessage()));
				});
			}
		}
	}

	public void registerTickets(OrderIdModel orderIdModel) {
		for (Long saleId : orderIdModel.getServices().keySet()) {
			try {
				OrderXMLType orderXML = port.registerTickets(saleId);
				if (orderXML == null || !orderXML.getPayState().equals(PAY_STATE)) {
					throw new Exception("Некорретный статус заказа в ресурсе - " + orderXML != null ? orderXML.getPayState() : "null");
				}
				orderIdModel.getServices().get(saleId).stream().forEach(c -> c.getService().setConfirmed(true));
			} catch (Exception e) {
				try {
					if (!(e instanceof ServiceAppException_Exception)) {
						// если возникла ошибка не от ресурса, а передачи/получения данных и т.д., то проверяем дополнительно статус заказа
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e1) {
						}
						try {
							OrderXMLType orderXML = port.findOrderById(saleId);
							if (orderXML == null || !orderXML.getPayState().equals(PAY_STATE)) {
								throw new Exception("Заказ в ресурсе не в статусе 'оплачен' - " + orderXML != null ? orderXML.getPayState() : "null");
							}
						} catch (ServiceAppException_Exception e1) {
							throw new Exception(
									"Не удалось получить статус заказа от ресурса при подтверждении заказа.", e);
						}
					} else {
						throw new Exception("Не удалось выкупить заказ в ресурсе.", e);
					}
				} catch (Exception e2) {
					orderIdModel.getServices().get(saleId).stream().forEach(c -> {
						c.getService().setConfirmed(false);
						c.getService().setError(new RestError(e2.getMessage()));
					});
				}
			}
		}
	}
	
	public void calculateBuyback(OrderIdModel orderIdModel) {
		orderIdModel.getServices().entrySet().stream().forEach(orderEntry -> {
			for (OrderIdModelObject orderIdModelObject : orderEntry.getValue()) {
				try {
					BuybackInfoXMLType buybackInfo = port.calculateBuyback(orderIdModelObject.getTicketId());
					if (buybackInfo != null) {
						if (buybackInfo.isIsAllOwnerOrder()) {
							OrderXMLType orderXML = port.findOrderById(orderEntry.getKey());
							if (orderEntry.getValue().size() != orderXML.getDirectTickets().size()) {
								orderEntry.getValue().stream().forEach(c -> {
									orderIdModelObject.getService().setConfirmed(false);
									orderIdModelObject.getService().setError(new RestError(
											"У ресурса нет возможности возвращать выбранные позиции заказа. Заказ можно вернуть только целиком."));
								});
							} else {
								BigDecimal amount = new BigDecimal(buybackInfo.getAmount() / orderEntry.getValue().size());
								BigDecimal mod = new BigDecimal(buybackInfo.getAmount() % orderEntry.getValue().size());
								for (Iterator<OrderIdModelObject> iterator = orderEntry.getValue().iterator(); iterator.hasNext();) {
									OrderIdModelObject ticket = iterator.next();
									if (!iterator.hasNext()) {
										amount = amount.add(mod);
									}
									ticket.setBuybackAmount(amount.multiply(MULTIPLICAND));
									ticket.getService().setConfirmed(true);
									ticket.getService().setPrice(getPrice(ticket));
								}
							}
							break;
						} else {
							orderIdModelObject.setBuybackAmount(new BigDecimal(buybackInfo.getAmount()).multiply(MULTIPLICAND));
							orderIdModelObject.getService().setConfirmed(true);
						}
					} else {
						throw new Exception("Ошибка получения ответа от ресурса");
					}
				} catch (Exception e) {
					orderIdModelObject.getService().setConfirmed(false);
					orderIdModelObject.getService().setError(new RestError(e.getMessage()));
				}
			}
		});
	}
	
	private Price getPrice(OrderIdModelObject ticket) {
		Price price = new Price();
		price.setCurrency(Currency.EUR);
		price.setAmount(ticket.getBuybackAmount());
		return price;
	}

	public void buyback(OrderIdModel orderIdModel) {
		orderIdModel.getServices().entrySet().stream().forEach(orderEntry -> {
			for (OrderIdModelObject orderIdModelObject : orderEntry.getValue()) {
				try {
					BuybackInfoXMLType buyBack = port.buyback(orderIdModelObject.getTicketId());
					if (buyBack != null) {
						if (buyBack.isIsAllOwnerOrder()) {
							orderEntry.getValue().stream()
									.forEach(c -> orderIdModelObject.getService().setConfirmed(true));
							break;
						} else {
							orderIdModelObject.getService().setConfirmed(true);
						}
					} else {
						throw new Exception("Ошибка получения ответа от ресурса");
					}
				} catch (Exception e) {
					orderIdModelObject.getService().setConfirmed(false);
					orderIdModelObject.getService().setError(new RestError(e.getMessage()));
				}
			}
		});
	}

	public CacheHandler getCache() {
		return cache;
	}

	public static RestClientException createUnavailableMethod() {
		return new RestClientException("Method is unavailable");
	}

}
