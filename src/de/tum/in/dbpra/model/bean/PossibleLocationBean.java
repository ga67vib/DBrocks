package de.tum.in.dbpra.model.bean;


public class PossibleLocationBean {
	private int locationID;
	private String address;
	private int size ;
	private String orgComment;
	private int priority;
	private double price;
	
	public PossibleLocationBean() {}

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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the orgComment
	 */
	public String getOrgComment() {
		return orgComment;
	}

	/**
	 * @param orgComment the orgComment to set
	 */
	public void setOrgComment(String orgComment) {
		this.orgComment = orgComment;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
