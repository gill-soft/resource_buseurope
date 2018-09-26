package com.gillsoft.client;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.gillsoft.model.ServiceItem;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderIdModelObject implements Serializable {

	private static final long serialVersionUID = 8773013876601701702L;

	//private Customer customer;

	private ServiceItem service;

	private Long ticketId;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private BigDecimal buybackAmount;

	public OrderIdModelObject() {

	}
	
	public OrderIdModelObject(ServiceItem service) {
		this.service = service;
	}

	/*public OrderIdModelObject(Customer customer) {
		this.customer = customer;
	}

	public OrderIdModelObject(Customer customer, ServiceItem service) {
		this(customer);
		this.service = service;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/

	public ServiceItem getService() {
		return service;
	}

	public void setService(ServiceItem service) {
		this.service = service;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public BigDecimal getBuybackAmount() {
		return buybackAmount;
	}

	public void setBuybackAmount(BigDecimal buybackAmount) {
		this.buybackAmount = buybackAmount;
	}

}
