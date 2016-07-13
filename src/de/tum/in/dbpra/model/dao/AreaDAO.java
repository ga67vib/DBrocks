package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.AreaBean;
import de.tum.in.dbpra.model.bean.AreaListBean;

public class AreaDAO extends DAO {
	
	//get All Areas 
	public void getAreas(AreaListBean listObject) throws SQLException, ClassNotFoundException {

		String query = "SELECT * FROM Area;";

		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			//set All areabean Attributes
			AreaBean areabean = new AreaBean();
			areabean.setAreaID(rs.getInt("area_id"));
			areabean.setSize(rs.getInt("size"));
			areabean.setName(rs.getString("name"));
			areabean.setDescription(rs.getString("description"));
			listObject.setChild(areabean);
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}
	
	//get Area by AreaID (as Parameter)
	public void getAreabyID(AreaBean areabean, int AreaID)
			throws SQLException, ClassNotFoundException {

		String query = "SELECT * FROM Area Where area_id=?";

		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, AreaID);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			//set all areabean Attributes
			areabean.setAreaID(rs.getInt("area_id"));
			areabean.setSize(rs.getInt("size"));
			areabean.setName(rs.getString("name"));
			areabean.setDescription(rs.getString("description"));
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}

}