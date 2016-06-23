package de.tum.in.dbpra.model.bean;

public class PartBean {
	private int partkey;
	private String name;
	private String type;
	private int size;
	private int container;
	private double retailprice;
	
	public PartBean() {}

	/**
	 * @return the partkey
	 */
	public int getPartkey() {
		return partkey;
	}

	/**
	 * @param partkey the partkey to set
	 */
	public void setPartkey(int partkey) {
		this.partkey = partkey;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the container
	 */
	public int getContainer() {
		return container;
	}

	/**
	 * @param container the container to set
	 */
	public void setContainer(int container) {
		this.container = container;
	}

	/**
	 * @return the retailprice
	 */
	public double getRetailprice() {
		return retailprice;
	}

	/**
	 * @param retailprice the retailprice to set
	 */
	public void setRetailprice(double retailprice) {
		this.retailprice = retailprice;
	}
	
	
}
