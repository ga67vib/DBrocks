package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import de.tum.in.dbpra.model.bean.AreaBean;
import de.tum.in.dbpra.model.bean.AreaListBean;

public class AreaDAO extends DAO{
	public void getAreas(AreaListBean listObject) throws AreaNotFoundException, SQLException, ClassNotFoundException {
		
		
		
		String query = "SELECT * FROM Area;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(DAO.getRowCount(rs)==0) {
			throw new AreaNotFoundException("There are no Areas found!");
		}
		
		while(rs.next())
		{
			AreaBean object = new AreaBean();
			object.setAreaID(rs.getInt("area_id"));
			object.setSize(rs.getInt("size"));
			object.setLocation(rs.getInt("location"));
			object.se
			listObject.setChild(object);
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	public static class AreaNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		AreaNotFoundException(String message){
			super(message);
		}
	}
}