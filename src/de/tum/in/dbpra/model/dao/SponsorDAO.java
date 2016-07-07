package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.AreaBean;
import de.tum.in.dbpra.model.bean.AreaListBean;
import de.tum.in.dbpra.model.bean.SponsorBean;
import de.tum.in.dbpra.model.dao.AreaDAO.AreaNotFoundException;

public class SponsorDAO extends DAO{

	public void getSponsorbyID(SponsorBean sponsorbean, int SponsorID) throws AreaNotFoundException, SQLException, ClassNotFoundException {
		
		
		
		String query = "SELECT * FROM Sponsors Where sponsor_id=?";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, SponsorID);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(DAO.getRowCount(rs)==0) {
			throw new AreaNotFoundException("There are no Areas found!");
		}
		
		while(rs.next()){
			sponsorbean.setSponsorID(rs.getInt("sponsor_id"));
			sponsorbean.setAddress(rs.getString("adress"));
			sponsorbean.setPayment(rs.getInt("payment"));
			sponsorbean.setNumReqBooths(rs.getInt("num_req_booths"));
			sponsorbean.setNumAssBooths(rs.getInt("num_ass_booths"));
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}

}
