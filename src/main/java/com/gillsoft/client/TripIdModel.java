package com.gillsoft.client;

import java.util.Date;

import com.gillsoft.model.AbstractJsonModel;

public class TripIdModel extends AbstractJsonModel {

	private static final long serialVersionUID = -4570318053620484041L;

	private Long raceId;

	private String raceCode;

	private Long fromStopId;

	private Long toStopId;
	
	private Date dateStart;

	private Long price;

	public TripIdModel() {

	}

	public TripIdModel(Long raceId, String raceCode, Long fromStopId, Long toStopId, Date dateStart, Long price) {
		this.raceId = raceId;
		this.raceCode = raceCode;
		this.fromStopId = fromStopId;
		this.toStopId = toStopId;
		this.dateStart = dateStart;
		this.price = price;
	}

	@Override
	public TripIdModel create(String json) {
		return (TripIdModel) super.create(json);
	}

	public Long getRaceId() {
		return raceId;
	}

	public void setRaceId(Long raceId) {
		this.raceId = raceId;
	}

	public String getRaceCode() {
		return raceCode;
	}

	public void setRaceCode(String raceCode) {
		this.raceCode = raceCode;
	}

	public Long getFromStopId() {
		return fromStopId;
	}

	public void setFromStopId(Long fromStopId) {
		this.fromStopId = fromStopId;
	}

	public Long getToStopId() {
		return toStopId;
	}

	public void setToStopId(Long toStopId) {
		this.toStopId = toStopId;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

}
