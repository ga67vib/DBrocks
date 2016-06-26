package de.tum.in.dbpra.model.bean;

public class SponsorBean {
	private int sponsorID;
	private String address;
	private double payment;
	private int numReqBooth;
	private int numAssBooth;
	
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
	public int getNumReqBooth() {
		return numReqBooth;
	}

	/**
	 * @param numReqBooth the numReqBooth to set
	 */
	public void setNumReqBooth(int numReqBooth) {
		this.numReqBooth = numReqBooth;
	}

	/**
	 * @return the numAssBooth
	 */
	public int getNumAssBooth() {
		return numAssBooth;
	}

	/**
	 * @param numAssBooth the numAssBooth to set
	 */
	public void setNumAssBooth(int numAssBooth) {
		this.numAssBooth = numAssBooth;
	}
	
}
