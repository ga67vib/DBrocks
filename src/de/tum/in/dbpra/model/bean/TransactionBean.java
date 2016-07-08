package de.tum.in.dbpra.model.bean;

import java.util.Date;

public class TransactionBean {
	private int transactionID;
	private int boothID;
	private RFID_TicketBean ticketID;
	private ProductBean productID;
	private Date transactionTime;
	
	public TransactionBean() {}

	/**
	 * @return the transactionID
	 */
	public int getTransactionID() {
		return transactionID;
	}

	/**
	 * @param transactionID the transactionID to set
	 */
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	/**
	 * @return the boothID
	 */
	public int getBoothID() {
		return boothID;
	}

	/**
	 * @param boothID the boothID to set
	 */
	public void setBoothID(int boothID) {
		this.boothID = boothID;
	}

	/**
	 * @return the ticketID
	 */
	public RFID_TicketBean getTicketID() {
		return ticketID;
	}

	/**
	 * @param ticketID the ticketID to set
	 */
	public void setTicketID(RFID_TicketBean ticketID) {
		this.ticketID = ticketID;
	}

	/**
	 * @return the productID
	 */
	public ProductBean getProductID() {
		return productID;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(ProductBean productID) {
		this.productID = productID;
	}

	/**
	 * @return the transactionTime
	 */
	public Date getTransactionTime() {
		return transactionTime;
	}

	/**
	 * @param transactionTime the transactionTime to set
	 */
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}


	
}
