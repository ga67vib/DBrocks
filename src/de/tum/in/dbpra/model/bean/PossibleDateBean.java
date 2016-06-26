package de.tum.in.dbpra.model.bean;

import java.util.Date;

public class PossibleDateBean {
	private int dateID;
	private Date startDate;
	private Date endDate;
	private String orgComment;
	private int priority;
	
	public PossibleDateBean() {}

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

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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


}
