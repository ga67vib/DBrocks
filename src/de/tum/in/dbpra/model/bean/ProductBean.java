package de.tum.in.dbpra.model.bean;

public class ProductBean {
	private int productID;
	private double price;
	private String name;
	private String addInfo;
	
	
	public ProductBean() {}


	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}


	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
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
	 * @return the addInfo
	 */
	public String getAddInfo() {
		return addInfo;
	}


	/**
	 * @param addInfo the addInfo to set
	 */
	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}


}
