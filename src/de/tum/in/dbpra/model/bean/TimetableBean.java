package de.tum.in.dbpra.model.bean;

public class TimetableBean {
	private int personID;
	private int performanceID;
	
	
	public TimetableBean() {}


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

}
