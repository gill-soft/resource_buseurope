package com.gillsoft.client;

import java.io.Serializable;
import java.util.Date;

import com.gillsoft.util.StringUtil;

public class TripsTaskKey implements Serializable {

	private static final long serialVersionUID = 4331649659729513500L;

	private String cityStart;

	private int cityStartInt;

	private String cityEnd;

	private int cityEndInt;

	private Date date;

	public TripsTaskKey() {

	}

	public TripsTaskKey(String cityStart, String cityEnd, Date date) {
		this.cityStart = cityStart;
		this.cityStartInt = Integer.parseInt(cityStart);
		this.cityEnd = cityEnd;
		this.cityEndInt = Integer.parseInt(cityEnd);
		this.date = date;
	}

	public String getCityStart() {
		return cityStart;
	}

	public void setCityStart(String cityStart) {
		this.cityStart = cityStart;
	}

	public String getCityEnd() {
		return cityEnd;
	}

	public void setCityEnd(String cityEnd) {
		this.cityEnd = cityEnd;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString() {
		return String.join("|", RestClient.TRIPS_CACHE_KEY, cityStart, cityEnd, StringUtil.dateFormat.format(date));
	}

	public int getCityStartInt() {
		return cityStartInt;
	}

	public void setCityStartInt(int cityStartInt) {
		this.cityStartInt = cityStartInt;
	}

	public int getCityEndInt() {
		return cityEndInt;
	}

	public void setCityEndInt(int cityEndInt) {
		this.cityEndInt = cityEndInt;
	}

}
