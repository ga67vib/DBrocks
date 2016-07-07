package de.tum.in.dbpra.model.bean;

import java.util.Date;

public class RFID_TicketBean {
	private int ticketID;
	private PersonBean ownedBy;
	private double acctBal;
	private boolean isCamper;
	private boolean isVIP;
	private Date purchaseDate;
	private Date validFrom;
	private Date validUntil;
	private int price;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public RFID_TicketBean() {}

	/**
	 * @return the ticketID
	 */
	public int getTicketID() {
		return ticketID;
	}

	/**
	 * @param ticketID the ticketID to set
	 */
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	/**
	 * @return the ownedBy
	 */
	public PersonBean getOwnedBy() {
		return ownedBy;
	}

	/**
	 * @param ownedBy the ownedBy to set
	 */
	public void setOwnedBy(PersonBean ownedBy) {
		this.ownedBy = ownedBy;
	}

	/**
	 * @return the acctBal
	 */
	public double getAcctBal() {
		return acctBal;
	}

	/**
	 * @param acctBal the acctBal to set
	 */
	public void setAcctBal(double acctBal) {
		this.acctBal = acctBal;
	}

	/**
	 * @return the isCamper
	 */
	public boolean isCamper() {
		return isCamper;
	}

	/**
	 * @param isCamper the isCamper to set
	 */
	public void setCamper(boolean isCamper) {
		this.isCamper = isCamper;
	}

	/**
	 * @return the isVIP
	 */
	public boolean isVIP() {
		return isVIP;
	}

	/**
	 * @param isVIP the isVIP to set
	 */
	public void setVIP(boolean isVIP) {
		this.isVIP = isVIP;
	}

	/**
	 * @return the purchaseDate
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * @param purchaseDate the purchaseDate to set
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * @return the validFrom
	 */
	public Date getValidFrom() {
		return validFrom;
	}

	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * @return the validUntil
	 */
	public Date getValidUntil() {
		return validUntil;
	}

	/**
	 * @param validUntil the validUntil to set
	 */
	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

}
