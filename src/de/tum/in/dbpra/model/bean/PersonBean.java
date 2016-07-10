package de.tum.in.dbpra.model.bean;

import java.util.Date;

public class PersonBean {
	private int personID;
	private Date birthdate;
	private String gender;
	private String mail;
	private String address;
	private String firstName;
	private String lastName;
	private String phonenumber;
	private String password;
	private boolean doNotify;
	private NoteListBean notes;
	
	public NoteListBean getNotes() {
		return notes;
	}


	public void setNotes(NoteListBean notes) {
		this.notes = notes;
	}


	public PersonBean() {}


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
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}


	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}


	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}


	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	/**
	 * @return the doNotify
	 */
	public boolean isDoNotify() {
		return doNotify;
	}


	/**
	 * @param doNotify the doNotify to set
	 */
	public void setDoNotify(boolean doNotify) {
		this.doNotify = doNotify;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}
