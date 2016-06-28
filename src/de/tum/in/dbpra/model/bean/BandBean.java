package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;
import java.util.Arrays;

public class BandBean {
	private int bandID;
	private String bandName;
	private String instruction;
	private int registersAt;
	private double salary;
	private ArrayList<String> songlist;
	
	public BandBean() {}

	/**
	 * @return the bandID
	 */
	public int getBandID() {
		return bandID;
	}

	/**
	 * @param bandID the bandID to set
	 */
	public void setBandID(int bandID) {
		this.bandID = bandID;
	}

	/**
	 * @return the bandName
	 */
	public String getBandName() {
		return bandName;
	}

	/**
	 * @param bandName the bandName to set
	 */
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	/**
	 * @return the instruction
	 */
	public String getInstruction() {
		return instruction;
	}

	/**
	 * @param instruction the instruction to set
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	/**
	 * @return the registersAt
	 */
	public int getRegistersAt() {
		return registersAt;
	}

	/**
	 * @param registersAt the registersAt to set
	 */
	public void setRegistersAt(int registersAt) {
		this.registersAt = registersAt;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the songlist
	 */
	public ArrayList<String> getSonglist() {
		return songlist;
	}

	/**
	 * @param songlist the songlist to set
	 */
	public void setSonglist(String songlist) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(songlist.split(", ")));
		this.songlist = list;
	}

}
