package com.gillsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gillsoft.abstract_rest_service.AbstractOrderService;
import com.gillsoft.client.OrderIdModel;
import com.gillsoft.client.OrderIdModelObject;
import com.gillsoft.client.ResponseError;
import com.gillsoft.client.RestClient;
import com.gillsoft.model.Customer;
import com.gillsoft.model.ServiceItem;
import com.gillsoft.model.request.OrderRequest;
import com.gillsoft.model.response.OrderResponse;

@RestController
public class OrderServiceController extends AbstractOrderService {
	
	@Autowired
	private RestClient client;

	@Override
	public OrderResponse addServicesResponse(OrderRequest request) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse bookingResponse(String orderId) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse cancelResponse(String orderId) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse createResponse(OrderRequest request) {
		// формируем ответ
		OrderResponse response = new OrderResponse();
		// копия для определения пассажиров
		List<ServiceItem> items = new ArrayList<>();
		items.addAll(request.getServices());
		// список билетов
		OrderIdModel orderId = new OrderIdModel();
		Map<String, List<OrderIdModelObject>> serviceMap = new HashMap<>();
		for (ServiceItem service : request.getServices()) {
			List<OrderIdModelObject> customers = serviceMap.get(service.getSegment().getId());
			if (customers == null) {
				customers = new ArrayList<>();
				serviceMap.put(service.getSegment().getId(), customers);
			}
			Customer customer = request.getCustomers().get(service.getCustomer().getId());
			if (customer != null) {
				customer.setId(service.getCustomer().getId());
				service.setCustomer(customer);
				OrderIdModelObject orderIdModelObject = new OrderIdModelObject(service);
				customers.add(orderIdModelObject);
			}
		}
		response.setServices(request.getServices());
		try {
			client.reserve(serviceMap, orderId);
		} catch (ResponseError e) {
			e.printStackTrace();
			response.getServices().stream().forEach(c -> c.setConfirmed(false));
		}
		response.setOrderId(orderId.asString());
		return response;
	}

	@Override
	public OrderResponse getPdfDocumentsResponse(OrderRequest request) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse getResponse(String orderId) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse getServiceResponse(String serviceId) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse confirmResponse(String orderId) {
		// формируем ответ
		OrderResponse response = new OrderResponse();
		// преобразовываем ид заказа в объект
		OrderIdModel orderIdModel = new OrderIdModel().create(orderId);
		// выкупаем заказы и формируем ответ
		client.registerTickets(orderIdModel);
		response.setOrderId(orderIdModel.asString());
		addServiceItems(response, orderIdModel);
		return response;
	}

	private void addServiceItems(OrderResponse response, OrderIdModel orderIdModel) {
		if (orderIdModel.getServices() != null && !orderIdModel.getServices().isEmpty()) {
			if (response.getServices() == null) {
				response.setServices(new ArrayList<>());
			}
			if (response.getCustomers() == null) {
				response.setCustomers(new HashMap<>());
			}
			orderIdModel.getServices().values().stream().forEach(f -> {
				response.getServices()
					.addAll(f.stream().map(m -> m.getService()).collect(Collectors.toList()));
			});
		}
	}

	@Override
	public OrderResponse removeServicesResponse(OrderRequest request) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse returnServicesResponse(OrderRequest request) {
		OrderResponse response = new OrderResponse();
		OrderIdModel orderIdModel = new OrderIdModel().create(request.getOrderId());
		client.buyback(orderIdModel);
		response.setOrderId(orderIdModel.asString());
		addServiceItems(response, orderIdModel);
		return response;
	}

	@Override
	public OrderResponse updateCustomersResponse(OrderRequest request) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse prepareReturnServicesResponse(OrderRequest request) {
		OrderResponse response = new OrderResponse();
		OrderIdModel orderIdModel = new OrderIdModel().create(request.getOrderId());
		client.calculateBuyback(orderIdModel);
		response.setOrderId(orderIdModel.asString());
		addServiceItems(response, orderIdModel);
		return response;
	}

}
