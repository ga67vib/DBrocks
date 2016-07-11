package de.tum.in.dbpra.model.bean;

import java.sql.Timestamp;
import java.util.Date;

public class PerformanceBean {
	private int performanceID;
	private StageBean isAt;
	private Timestamp startBuildUp;
	private Timestamp startTime;
	private Timestamp endTime;
	private Timestamp endRemoval;
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
	public Timestamp getStartBuildUp() {
		return startBuildUp;
	}

	/**
	 * @param startBuildUp the startBuildUp to set
	 */
	public void setStartBuildUp(Timestamp startBuildUp) {
		this.startBuildUp = startBuildUp;
	}

	/**
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the endRemoval
	 */
	public Timestamp getEndRemoval() {
		return endRemoval;
	}

	/**
	 * @param endRemoval the endRemoval to set
	 */
	public void setEndRemoval(Timestamp endRemoval) {
		this.endRemoval = endRemoval;
	}

	public PerformanceBean() {}

}
