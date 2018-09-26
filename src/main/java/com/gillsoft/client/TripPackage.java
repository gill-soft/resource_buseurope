package com.gillsoft.client;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.gillsoft.model.RaceInfoXMLType;
/*import com.gillsoft.model.ArrayOfStopPath;
import com.gillsoft.model.PathL;*/
import com.gillsoft.model.Trip;
import com.gillsoft.model.request.TripSearchRequest;

public class TripPackage implements Serializable {

	private static final long serialVersionUID = -1022724811422338355L;

	private TripSearchRequest request;

	private boolean inProgress = true;

	private List<ScheduleTrip> schedule;

	private CopyOnWriteArrayList<Trip> trips;

	private ResponseError error;

	private boolean continueSearch = false;
	
	private List<RaceInfoXMLType> raceInfo;

	public TripPackage() { }
	
	public TripPackage(TripSearchRequest request) {
		this.request = request;
	}
	
	public TripPackage(List<RaceInfoXMLType> raceInfo) {
		this.raceInfo = raceInfo;
	}
	
	public TripPackage(TripSearchRequest request, ResponseError error) {
		this.request = request;
		this.error = error;
	}

	public TripSearchRequest getRequest() {
		return request;
	}

	public void setRequest(TripSearchRequest request) {
		this.request = request;
	}

	public boolean isInProgress() {
		return inProgress;
	}

	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}

	public List<ScheduleTrip> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<ScheduleTrip> schedule) {
		this.schedule = schedule;
	}

	public CopyOnWriteArrayList<Trip> getTrips() {
		return trips;
	}

	public void setTrips(CopyOnWriteArrayList<Trip> trips) {
		this.trips = trips;
	}

	public ResponseError getError() {
		return error;
	}

	public void setError(ResponseError error) {
		this.error = error;
	}

	public boolean isContinueSearch() {
		return continueSearch;
	}

	public void setContinueSearch(boolean continueSearch) {
		this.continueSearch = continueSearch;
	}

	public List<RaceInfoXMLType> getRaceInfo() {
		return raceInfo;
	}

	public void setRaceInfo(List<RaceInfoXMLType> raceInfo) {
		this.raceInfo = raceInfo;
	}

}
