package de.tum.in.dbpra.model.bean;

public class IsAvailableBean {
	private int locationID;
	private int dateID;
	
	
	public IsAvailableBean() {}


	/**
	 * @return the locationID
	 */
	public int getLocationID() {
		return locationID;
	}


	/**
	 * @param locationID the locationID to set
	 */
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}


	/**
	 * @return the dateID
	 */
	public int getDateID() {
		return dateID;
	}


	/**
	 * @param dateID the dateID to set
	 */
	public void setDateID(int dateID) {
		this.dateID = dateID;
	}


}
