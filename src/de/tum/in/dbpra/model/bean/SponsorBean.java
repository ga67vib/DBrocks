package de.tum.in.dbpra.model.bean;

public class SponsorBean {
	private int sponsorID;
	private String address;
	private double payment;
	private int numReqBooths;
	private int numAssBooths;
	
	public SponsorBean() {}

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
	 * @return the payment
	 */
	public double getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(double payment) {
		this.payment = payment;
	}

	/**
	 * @return the numReqBooth
	 */
	public int getNumReqBooths() {
		return numReqBooths;
	}

	/**
	 * @param numReqBooth the numReqBooth to set
	 */
	public void setNumReqBooths(int numReqBooth) {
		this.numReqBooths = numReqBooth;
	}

	/**
	 * @return the numAssBooth
	 */
	public int getNumAssBooths() {
		return numAssBooths;
	}

	/**
	 * @param numAssBooth the numAssBooth to set
	 */
	public void setNumAssBooths(int numAssBooth) {
		this.numAssBooths = numAssBooth;
	}
	
}
