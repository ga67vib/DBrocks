package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import de.tum.in.dbpra.model.bean.SponsorBean;
import de.tum.in.dbpra.model.bean.SponsorListBean;
import de.tum.in.dbpra.model.dao.AreaDAO.AreaNotFoundException;

public class SponsorDAO extends DAO{

	public void getSponsorbyID(SponsorBean sponsorbean, int SponsorID) throws AreaNotFoundException, SQLException, ClassNotFoundException {
		
		
		
		String query = "SELECT * FROM Sponsor Where sponsor_id=?";
		
		Connection con = getConnection();
	
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, SponsorID);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(DAO.getRowCount(rs)==0) {
			throw new AreaNotFoundException("There are no Sponsor found!");
		}
		
		while(rs.next()){
			sponsorbean.setSponsorID(rs.getInt("sponsor_id"));
			sponsorbean.setAddress(rs.getString("address"));
			sponsorbean.setPayment(rs.getInt("payment"));
			sponsorbean.setNumReqBooths(rs.getInt("num_req_booths"));
			sponsorbean.setNumAssBooths(rs.getInt("num_ass_booths"));
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
public void getSponsors(SponsorListBean sponsorlistbean) throws AreaNotFoundException, SQLException, ClassNotFoundException {
		
		
		
		String query = "SELECT * FROM Sponsor";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		
		ResultSet rs = pstmt.executeQuery();
		
		if(DAO.getRowCount(rs)==0) {
			throw new AreaNotFoundException("There are no Sponsors found!");
		}
		
		while(rs.next()){
			SponsorBean sponsorbean = new SponsorBean();
			sponsorbean.setSponsorID(rs.getInt("sponsor_id"));
			sponsorbean.setName(rs.getString("name"));
			sponsorbean.setAddress(rs.getString("address"));
			sponsorbean.setPayment(rs.getInt("payment"));
			sponsorbean.setNumReqBooths(rs.getInt("num_req_booths"));
			sponsorbean.setNumAssBooths(rs.getInt("num_ass_booths"));
			sponsorlistbean.setChild(sponsorbean);
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	

}