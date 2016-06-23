package de.tum.in.dbpra.model.bean;

public class OrderBean {
	private int orderkey;
	private int custkey;
	private String orderstatus;
	private double totalprice;
	private String orderdate;
	
	public OrderBean() {}
	
	public int getOrderkey() {
		return orderkey;
	}
	public void setOrderkey(int orderkey) {
		this.orderkey = orderkey;
	}
	public int getCustkey() {
		return custkey;
	}
	public void setCustkey(int custkey) {
		this.custkey = custkey;
	}
	/**
	 * @return the orderstatus
	 */
	public String getStatus() {
		return orderstatus;
	}
	/**
	 * @param orderstatus the orderstatus to set
	 */
	public void setOrderstatus(String status) {
		this.orderstatus = status;
	}
	/**
	 * @return the totalprice
	 */
	public double getTotalprice() {
		return totalprice;
	}
	/**
	 * @param totalprice the totalprice to set
	 */
	public void setTotalprice(double price) {
		this.totalprice = price;
	}
	/**
	 * @return the orderdate
	 */
	public String getOrderdate() {
		return orderdate;
	}
	/**
	 * @param orderdate the orderdate to set
	 */
	public void setOrderdate(String date) {
		this.orderdate = date;
	}
	
}
