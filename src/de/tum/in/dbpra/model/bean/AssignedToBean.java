package de.tum.in.dbpra.model.bean;

public class AssignedToBean {
	private int noteID;
	private int personID;
	
	
	public AssignedToBean() {}


	/**
	 * @return the noteID
	 */
	public int getNoteID() {
		return noteID;
	}


	/**
	 * @param noteID the noteID to set
	 */
	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}


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


}
