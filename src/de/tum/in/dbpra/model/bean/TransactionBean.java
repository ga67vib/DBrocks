package de.tum.in.dbpra.model.bean;

import java.sql.Timestamp;
import java.util.Date;

public class TransactionBean {
	private int transactionID;
	private BoothBean booth;
	private RFID_TicketBean ticket;
	private ProductBean product;
	private Timestamp transactionTime;
	
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
	 * @return the booth
	 */
	public BoothBean getBooth() {
		return booth;
	}

	/**
	 * @param booth the booth to set
	 */
	public void setBooth(BoothBean booth) {
		this.booth = booth;
	}

	/**
	 * @return the ticket
	 */
	public RFID_TicketBean getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(RFID_TicketBean ticketID) {
		this.ticket = ticketID;
	}

	/**
	 * @return the product
	 */
	public ProductBean getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductBean product) {
		this.product = product;
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
	public void setTransactionTime(Timestamp transactionTime) {
		this.transactionTime = transactionTime;
	}


	
}
