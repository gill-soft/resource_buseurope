package com.gillsoft;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.gillsoft.abstract_rest_service.SimpleAbstractTripSearchService;
import com.gillsoft.cache.CacheHandler;
import com.gillsoft.client.ResponseError;
import com.gillsoft.client.RestClient;
import com.gillsoft.client.TripIdModel;
import com.gillsoft.client.TripPackage;
import com.gillsoft.model.Currency;
import com.gillsoft.model.Document;
import com.gillsoft.model.Lang;
import com.gillsoft.model.Locality;
import com.gillsoft.model.Organisation;
import com.gillsoft.model.Price;
import com.gillsoft.model.RequiredField;
import com.gillsoft.model.RestError;
import com.gillsoft.model.ReturnCondition;
import com.gillsoft.model.Route;
import com.gillsoft.model.Seat;
import com.gillsoft.model.SeatsScheme;
import com.gillsoft.model.Segment;
import com.gillsoft.model.Tariff;
import com.gillsoft.model.Trip;
import com.gillsoft.model.TripContainer;
import com.gillsoft.model.Vehicle;
import com.gillsoft.model.request.TripSearchRequest;
import com.gillsoft.model.response.TripSearchResponse;
import com.gillsoft.util.StringUtil;

@RestController
public class SearchServiceController extends SimpleAbstractTripSearchService<TripPackage> {

	@Autowired
	private RestClient client;

	@Autowired
	@Qualifier("MemoryCacheHandler")
	private CacheHandler cache;

	@Override
	public List<ReturnCondition> getConditionsResponse(String arg0, String arg1) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public List<Document> getDocumentsResponse(String arg0) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public List<Tariff> getTariffsResponse(String arg0) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public List<RequiredField> getRequiredFieldsResponse(String arg0) {
		return Arrays.asList(new RequiredField[] { });
	}

	@Override
	public Route getRouteResponse(String arg0) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public SeatsScheme getSeatsSchemeResponse(String arg0) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public List<Seat> updateSeatsResponse(String arg0, List<Seat> arg1) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public List<Seat> getSeatsResponse(String tripId) {
		try {
			return client.getSeats(new TripIdModel().create(tripId).getRaceId());
		} catch (Exception e) {
			throw new RestClientException(e.getMessage());
		}
	}

	@Override
	public TripSearchResponse initSearchResponse(TripSearchRequest request) {
		return simpleInitSearchResponse(cache, request);
	}

	@Override
	public void addInitSearchCallables(List<Callable<TripPackage>> callables, TripSearchRequest request) {
		callables.add(() -> {
			try {
				validateSearchParams(request.getLocalityPairs().get(0), request.getDates().get(0));
				TripPackage tripPackage = client.getCachedTrips(request.getLocalityPairs().get(0)[0],
						request.getLocalityPairs().get(0)[1], request.getDates().get(0));
				if (tripPackage == null) {
					throw new ResponseError("Empty result");
				}
				tripPackage.setRequest(request);
				return tripPackage;
			} catch (ResponseError e) {
				TripPackage tripPackage = new TripPackage(request, e);
				return tripPackage;
			} catch (Exception e) {
				return null;
			}
		});
	}

	private static void validateSearchParams(String[] pair, Date date) throws ResponseError {
		if (date == null
				|| date.getTime() < DateUtils.truncate(new Date(), Calendar.DATE).getTime()) {
			throw new ResponseError("Invalid parameter \"date\"");
		}
		if (pair == null || pair.length < 2) {
			throw new ResponseError("Invalid parameter \"pair\"");
		}
	}

	@Override
	public TripSearchResponse getSearchResultResponse(String searchId) {
		return simpleGetSearchResponse(cache, searchId);
	}

	@Override
	public void addNextGetSearchCallablesAndResult(List<Callable<TripPackage>> callables, Map<String, Vehicle> vehicles,
			Map<String, Locality> localities, Map<String, Organisation> organisations, Map<String, Segment> segments,
			List<TripContainer> containers, TripPackage tripPackage) {
		if (!tripPackage.isContinueSearch()) {
			addResult(vehicles, localities, organisations, segments, containers, tripPackage);
		} else if (tripPackage.getRequest() != null) {
			addInitSearchCallables(callables, tripPackage.getRequest().getLocalityPairs().get(0),
					tripPackage.getRequest().getDates().get(0));
		}
	}

	private void addResult(Map<String, Vehicle> vehicles, Map<String, Locality> localities,
			Map<String, Organisation> organisations, Map<String, Segment> segments, List<TripContainer> containers, TripPackage tripPackage) {
		TripContainer container = new TripContainer();
		container.setRequest(tripPackage.getRequest());
		if (tripPackage != null && tripPackage.getRaceInfo() != null
				&& !tripPackage.getRaceInfo().isEmpty()) {
			List<Trip> trips = new ArrayList<>();
			Locality departure = LocalityServiceController.getLocalityById(String.valueOf(tripPackage.getRaceInfo().get(0).getFromStopId()));
			Locality arrival = LocalityServiceController.getLocalityById(String.valueOf(tripPackage.getRaceInfo().get(0).getToStopId()));
			if (departure != null && arrival != null) {
				localities.put(departure.getId(), departure);
				localities.put(arrival.getId(), arrival);
			}
			tripPackage.getRaceInfo().stream().filter(f -> f.isIsSale() && f.getFreeSeats() != 0).forEach(race -> {
				Date departureDate = race.getDeparture().toGregorianCalendar().getTime();
				Trip tmpTrip = new Trip();
				tmpTrip.setId(new TripIdModel(race.getId(), race.getRaceCode(), race.getFromStopId(), race.getToStopId(), departureDate, race.getPrice()).asString());
				trips.add(tmpTrip);
				String segmentId = tmpTrip.getId();
				Segment segment = segments.get(segmentId);
				if (segment == null) {
					segment = new Segment();
					segment.setId(tmpTrip.getId());
					segment.setNumber(race.getRaceCode());
					try {
						segment.setDepartureDate(departureDate);
						segment.setArrivalDate(race.getArrival().toGregorianCalendar().getTime());
					} catch (Exception e) { }
					segments.put(segmentId, segment);
				}
				if (departure != null && arrival != null) {
					segment.setDeparture(new Locality(departure.getId()));
					segment.setArrival(new Locality(arrival.getId()));
				}
				segment.setCarrier(getCarrier(race.getCarrier(), organisations));
				segment.setFreeSeatsCount(race.getFreeSeats().intValue());
				addPrice(segment, race.getPrice(), race.getCommAmount());
			});
			container.setTrips(trips);
		}
		if (tripPackage.getError() != null) {
			container.setError(new RestError(tripPackage.getError().getMessage()));
		}
		containers.add(container);
	}

	private void addPrice(Segment segment, Long price, Long commAmount) {
		Price tripPrice = new Price();
		tripPrice.setCurrency(Currency.EUR);
		tripPrice.setAmount(new BigDecimal(price).multiply(RestClient.MULTIPLICAND));
		Tariff tariff = new Tariff();
		tariff.setValue(tripPrice.getAmount().subtract(new BigDecimal(commAmount).multiply(RestClient.MULTIPLICAND)));
		tripPrice.setTariff(tariff);
		segment.setPrice(tripPrice);
	}

	private Organisation getCarrier(String carrierName, Map<String, Organisation> organisations) {
		String carrierId = StringUtil.md5(carrierName);
		Organisation carrier = organisations.get(carrierId);
		if (carrier == null) {
			carrier = new Organisation(carrierId);
			carrier.setName(Lang.EN, carrierName);
			organisations.put(carrier.getId(), carrier);
		}
		return new Organisation(carrierId);
	}

}
