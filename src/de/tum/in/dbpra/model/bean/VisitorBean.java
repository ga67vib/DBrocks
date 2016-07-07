package de.tum.in.dbpra.model.bean;

public class VisitorBean {
	private int personID;
	private String preferredGenre;
	private PerformanceListBean timetable;
	
	
	public PerformanceListBean getTimetable() {
		return timetable;
	}


	public void setTimetable(PerformanceListBean timetable) {
		this.timetable = timetable;
	}


	public VisitorBean() {}


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
	 * @return the preferredGenre
	 */
	public String getPreferredGenre() {
		return preferredGenre;
	}


	/**
	 * @param preferredGenre the preferredGenre to set
	 */
	public void setPreferredGenre(String preferredGenre) {
		this.preferredGenre = preferredGenre;
	}
	
}
