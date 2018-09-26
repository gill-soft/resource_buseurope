package com.gillsoft.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gillsoft.model.AbstractJsonModel;

public class OrderIdModel extends AbstractJsonModel {
	
	private static final long serialVersionUID = 5661521517528841959L;
	
	private Map<Long, List<OrderIdModelObject>> services = new HashMap<>();

	public Map<Long, List<OrderIdModelObject>> getServices() {
		return services;
	}

	public void setServices(Map<Long, List<OrderIdModelObject>> services) {
		this.services = services;
	}

	@Override
	public OrderIdModel create(String json) {
		return (OrderIdModel) super.create(json);
	}
	
}
