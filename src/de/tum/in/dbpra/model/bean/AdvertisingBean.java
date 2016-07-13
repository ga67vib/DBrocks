package de.tum.in.dbpra.model.bean;

public class AdvertisingBean {
	SponsorBean sponsor;
	AreaBean area;
	String type;
	
	public SponsorBean getSponsor() {
		return sponsor;
	}
	public void setSponsor(SponsorBean sponsor) {
		this.sponsor = sponsor;
	}
	public AreaBean getArea() {
		return area;
	}
	public void setArea(AreaBean area) {
		this.area = area;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
