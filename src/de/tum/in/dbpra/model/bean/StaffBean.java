package de.tum.in.dbpra.model.bean;

import java.math.BigDecimal;

public class StaffBean {
	private int personID;
	private PersonBean personData;
	private String profession;
	private BigDecimal salary;
	private ShiftBean works;
	
	
	public ShiftBean getWorks() {
		return works;
	}


	public void setWorks(ShiftBean works) {
		this.works = works;
	}


	public StaffBean() {}


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
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}


	/**
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}


	/**
	 * @return the salary
	 */
	public BigDecimal getSalary() {
		return salary;
	}


	/**
	 * @param salary the salary to set
	 */
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	public PersonBean getPersonData() {
		return personData;
	}


	public void setPersonData(PersonBean personData) {
		this.personData = personData;
	}


}
