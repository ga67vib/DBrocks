package de.tum.in.dbpra.model.bean;

public class AdvertisingBean {
	private int sponsorID;
	private int areaID;
	private String type;
	
	public AdvertisingBean() {}

	/**
	 * @return the sponsorID
	 */
	public int getSponsorID() {
		return sponsorID;
	}

	/**
	 * @param sponsorID the sponsorID to set
	 */
	public void setSponsorID(int sponsorID) {
		this.sponsorID = sponsorID;
	}

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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}
