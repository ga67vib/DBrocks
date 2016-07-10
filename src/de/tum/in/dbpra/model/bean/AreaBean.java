package de.tum.in.dbpra.model.bean;

public class AreaBean {
	private int areaID;
	private int size;
	private String name;
	private String description;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	

	
	
}
