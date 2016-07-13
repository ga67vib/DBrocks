package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.AdvertisingBean;
import de.tum.in.dbpra.model.bean.AdvertisingListBean;
import de.tum.in.dbpra.model.bean.AreaBean;
import de.tum.in.dbpra.model.bean.SponsorBean;

public class AdvertisingDAO extends DAO {

	//get ALL Advertising (with Attributes) with Sponsor Attributes (JOIN with Sponsor) 
	//and Area Attributes
	public void getAdvertisings(AdvertisingListBean listObject) throws SQLException, ClassNotFoundException {

		String query = "SELECT ar.*,ad.type,s.*,s.name AS sname FROM Area ar JOIN advertising ad ON ar.area_id=ad.area_id JOIN sponsor s ON ad.sponsor_id=s.sponsor_id;";
		Connection con = getConnection();
		con.setAutoCommit(false);
		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			//we want for each entry a full AdvertisingBean
			AdvertisingBean adbean = new AdvertisingBean();
			AreaBean areabean = new AreaBean();
			SponsorBean sponsorbean = new SponsorBean();
			
			adbean.setType(rs.getString("type"));
			
			areabean.setAreaID(rs.getInt("area_id"));
			areabean.setSize(rs.getInt("size"));
			areabean.setName(rs.getString("name"));
			areabean.setDescription(rs.getString("description"));
			adbean.setArea(areabean);
			
			sponsorbean.setSponsorID(rs.getInt("sponsor_id"));
			sponsorbean.setName(rs.getString("sname"));
			sponsorbean.setAddress(rs.getString("address"));
			sponsorbean.setPayment(rs.getInt("payment"));
			sponsorbean.setNumReqBooths(rs.getInt("num_req_booths"));
			sponsorbean.setNumAssBooths(rs.getInt("num_ass_booths"));
			adbean.setSponsor(sponsorbean);
			
			
			listObject.setChild(adbean);
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}
	
	//Same method as in getAdvertising just with a Selection on SponsorID
	//SponsorID as Parameter
	public void getAdvertisingsBySponsorId(AdvertisingListBean listObject, int id) throws SQLException, ClassNotFoundException {

		String query = "SELECT ar.*,ad.type,s.*,s.name AS sname FROM Area ar JOIN advertising ad ON ar.area_id=ad.area_id JOIN sponsor s ON ad.sponsor_id=s.sponsor_id where ad.sponsor_id = ?;";
		Connection con = getConnection();
		con.setAutoCommit(false);
		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1,id);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			//we want for each entry a full AdvertisingBean
			AdvertisingBean adbean = new AdvertisingBean();
			AreaBean areabean = new AreaBean();
			SponsorBean sponsorbean = new SponsorBean();
			
			adbean.setType(rs.getString("type"));
			
			areabean.setAreaID(rs.getInt("area_id"));
			areabean.setSize(rs.getInt("size"));
			areabean.setName(rs.getString("name"));
			areabean.setDescription(rs.getString("description"));
			adbean.setArea(areabean);
			
			sponsorbean.setSponsorID(rs.getInt("sponsor_id"));
			sponsorbean.setName(rs.getString("sname"));
			sponsorbean.setAddress(rs.getString("address"));
			sponsorbean.setPayment(rs.getInt("payment"));
			sponsorbean.setNumReqBooths(rs.getInt("num_req_booths"));
			sponsorbean.setNumAssBooths(rs.getInt("num_ass_booths"));
			adbean.setSponsor(sponsorbean);
			
			
			listObject.setChild(adbean);
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}
}
