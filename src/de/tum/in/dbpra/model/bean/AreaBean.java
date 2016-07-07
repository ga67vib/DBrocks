package de.tum.in.dbpra.model.bean;

public class AreaBean {
	private int areaID;
	private int size;
	private int location;
	private SponsorListBean sponsor;
	private ShiftListBean shifts;
	
	public ShiftListBean getShiftsBean() {
		return shifts;
	}


	public void setShiftsBean(ShiftListBean shifts) {
		this.shifts = shifts;
	}


	public SponsorListBean getSponsorBean() {
		return sponsor;
	}


	public void setSponsorBean(SponsorListBean sponsor) {
		this.sponsor = sponsor;}


	public AreaBean() {}


	/**
	 * @return the areaID
	 */
	public int getAreaID() {
		return areaID;
	}


	/**
	 * @param areaID the areaID to set
	 */
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}


	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}


	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}


	/**
	 * @return the location
	 */
	public int getLocation() {
		return location;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(int location) {
		this.location = location;
	}
	
	
	
}
