package de.tum.in.dbpra.model.bean;

public class BoothBean {
	private int boothID;
	private AreaBean isin;
	private SponsorBean ownedBy;
	private String specReq;
	private int size;
	private String name;
	private String type;
	private ProductListBean products;
	
	public ProductListBean getProducts() {
		return products;
	}

	public void setProducts(ProductListBean products) {
		this.products = products;
	}

	public BoothBean() {}

	/**
	 * @return the boothID
	 */
	public int getBoothID() {
		return boothID;
	}

	/**
	 * @param boothID the boothID to set
	 */
	public void setBoothID(int boothID) {
		this.boothID = boothID;
	}

	/**
	 * @return the isin
	 */
	public AreaBean getIsin() {
		return isin;
	}

	/**
	 * @param isin the isin to set
	 */
	public void setIsin(AreaBean isin) {
		this.isin = isin;
	}

	/**
	 * @return the ownedBy
	 */
	public SponsorBean getOwnedBy() {
		return ownedBy;
	}

	/**
	 * @param ownedBy the ownedBy to set
	 */
	public void setOwnedBy(SponsorBean ownedBy) {
		this.ownedBy = ownedBy;
	}

	/**
	 * @return the specReq
	 */
	public String getSpecReq() {
		return specReq;
	}

	/**
	 * @param specReq the specReq to set
	 */
	public void setSpecReq(String specReq) {
		this.specReq = specReq;
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

	
}
