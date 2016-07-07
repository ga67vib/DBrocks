package de.tum.in.dbpra.model.bean;

import java.util.Date;

public class PerformanceBean {
	private int performanceID;
	private StageBean isAt;
	private Date startBuildUp;
	private Date startTime;
	private Date endTime;
	private Date endRemoval;
	private BandListBean gerockt;
	private VisitorListBean visitors;
	
	public VisitorListBean getVisitors() {
		return visitors;
	}

	public void setVisitors(VisitorListBean visitors) {
		this.visitors = visitors;
	}

	public BandListBean getGerockt() {
		return gerockt;
	}

	public void setGerockt(BandListBean gerockt) {
		this.gerockt = gerockt;
	}

	/**
	 * @return the performanceID
	 */
	public int getPerformanceID() {
		return performanceID;
	}

	/**
	 * @param performanceID the performanceID to set
	 */
	public void setPerformanceID(int performanceID) {
		this.performanceID = performanceID;
	}

	/**
	 * @return the isAt
	 */
	public StageBean getIsAt() {
		return isAt;
	}

	/**
	 * @param isAt the isAt to set
	 */
	public void setIsAt(StageBean isAt) {
		this.isAt = isAt;
	}

	/**
	 * @return the startBuildUp
	 */
	public Date getStartBuildUp() {
		return startBuildUp;
	}

	/**
	 * @param startBuildUp the startBuildUp to set
	 */
	public void setStartBuildUp(Date startBuildUp) {
		this.startBuildUp = startBuildUp;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the endRemoval
	 */
	public Date getEndRemoval() {
		return endRemoval;
	}

	/**
	 * @param endRemoval the endRemoval to set
	 */
	public void setEndRemoval(Date endRemoval) {
		this.endRemoval = endRemoval;
	}

	public PerformanceBean() {}

}