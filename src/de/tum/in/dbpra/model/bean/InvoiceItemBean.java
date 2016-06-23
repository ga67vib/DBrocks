package de.tum.in.dbpra.model.bean;

public class InvoiceItemBean {
	private String partName;
	private int linenumber;
	private int quantity;
	private double price;

	/**
	 * @return the partName
	 */
	public String getPartName() {
		return partName;
	}
	/**
	 * @param partName the partName to set
	 */
	public void setPartName(String partName) {
		this.partName = partName;
	}
	/**
	 * @return the linenumber
	 */
	public int getLinenumber() {
		return linenumber;
	}
	/**
	 * @param linenumber the linenumber to set
	 */
	public void setLinenumber(int linenumber) {
		this.linenumber = linenumber;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
}