package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import de.tum.in.dbpra.model.bean.IsAvailableBean;
import de.tum.in.dbpra.model.bean.IsAvailableListBean;

public class IsAvailableDAO extends DAO{
	public void getAreas(IsAvailableListBean listobjekt) throws IsAvailableNotFoundException, SQLException, ClassNotFoundException {
		
		if(listobjekt.getList().isEmpty()) {
			throw new IsAvailableNotFoundException("There are no IsAvailable-Instances found!");
		}
		
		String query = "SELECT * FROM is_available;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		for(int i = 0;rs.next();i++){
			IsAvailableBean object = new IsAvailableBean();
			object.setLocationID(rs.getInt("location_id"));
			object.setDateID(rs.getInt("date_id"));
			listobjekt.setChild(object, i);
			i++;
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	

	
	public static class IsAvailableNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		IsAvailableNotFoundException(String message){
			super(message);
		}
	}
}