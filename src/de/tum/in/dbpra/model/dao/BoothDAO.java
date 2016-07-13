package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.AreaBean;
import de.tum.in.dbpra.model.bean.BoothBean;
import de.tum.in.dbpra.model.bean.BoothListBean;
import de.tum.in.dbpra.model.bean.SponsorBean;

public class BoothDAO extends DAO {
	
	//get all Booths 
	public void getBooths(BoothListBean listobjekt) throws SQLException, ClassNotFoundException {

		String query = "SELECT * FROM booth;";

		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			BoothBean boothBean = new BoothBean();
			boothBean.setBoothID(rs.getInt("booth_id"));

			//SponsorBean for ownership of the Booth
			SponsorBean sponsorBean = new SponsorBean();
			SponsorDAO sponsorDAO = new SponsorDAO();
			sponsorDAO.getSponsorbyID(sponsorBean, rs.getInt("owned_by"));

			boothBean.setOwnedBy(sponsorBean);
			
			//AreaBean for location of BoothDAO
			AreaBean areaBean = new AreaBean();
			AreaDAO areaDAO = new AreaDAO();
			areaDAO.getAreabyID(areaBean, rs.getInt("is_in"));
			boothBean.setIsin(areaBean);

			boothBean.setSize(rs.getInt("size"));
			boothBean.setName(rs.getString("name"));
			boothBean.setSpecReq(rs.getString("spec_req") == null ? "" : rs.getString("spec_req"));
			boothBean.setType(rs.getString("type"));
			listobjekt.setChild(boothBean);
		}

		con.commit();
		//close Resources
		rs.close();
		pstmt.close();
		con.close();

	}
	
	//same Method as getBooths just with a Parameter for SponsorID
	public void getBoothsBySponsorID(BoothListBean listobjekt, int id) throws SQLException, ClassNotFoundException {

		String query = "SELECT * FROM booth b where b.owned_by = ?;";

		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			BoothBean object = new BoothBean();
			object.setBoothID(rs.getInt("booth_id"));

			SponsorBean temp = new SponsorBean();
			SponsorDAO tempdao = new SponsorDAO();
			tempdao.getSponsorbyID(temp, rs.getInt("owned_by"));

			object.setOwnedBy(temp);

			AreaBean tempa = new AreaBean();
			AreaDAO tempadao = new AreaDAO();
			tempadao.getAreabyID(tempa, rs.getInt("is_in"));
			object.setIsin(tempa);

			object.setSize(rs.getInt("size"));
			object.setName(rs.getString("name"));
			object.setSpecReq(rs.getString("spec_req") == null ? "" : rs.getString("spec_req"));
			object.setType(rs.getString("type"));
			listobjekt.setChild(object);
		}

		con.commit();
		//close Resources
		rs.close();
		pstmt.close();
		con.close();

	}


}