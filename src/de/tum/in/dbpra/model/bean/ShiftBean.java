package de.tum.in.dbpra.model.bean;

import java.sql.Timestamp;
import java.util.Date;

public class ShiftBean {
	private int shiftID;
	private Timestamp startTime;
	private Timestamp endTime;
	private int workers;
	
	
	public int getWorkers() {
		return workers;
	}


	public void setWorkers(int workers) {
		this.workers = workers;
	}


	public ShiftBean() {}


	/**
	 * @return the shiftID
	 */
	public int getShiftID() {
		return shiftID;
	}


	/**
	 * @param shiftID the shiftID to set
	 */
	public void setShiftID(int shiftID) {
		this.shiftID = shiftID;
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

}
