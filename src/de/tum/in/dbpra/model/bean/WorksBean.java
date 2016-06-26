package de.tum.in.dbpra.model.bean;

public class WorksBean {
	private int personID;
	private int shiftID;
	
	public WorksBean() {}

	/**
	 * @return the personID
	 */
	public int getPersonID() {
		return personID;
	}

	/**
	 * @param personID the personID to set
	 */
	public void setPersonID(int personID) {
		this.personID = personID;
	}

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

}
