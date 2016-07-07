package de.tum.in.dbpra.model.bean;

import java.util.Date;

public class ShiftBean {
	private int shiftID;
	private Date startTime;
	private Date endTime;
	private StaffBean workers;
	
	
	public StaffBean getWorkers() {
		return workers;
	}


	public void setWorkers(StaffBean workers) {
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

}
