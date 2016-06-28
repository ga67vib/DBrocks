package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import de.tum.in.dbpra.model.bean.HasTimeBean;
import de.tum.in.dbpra.model.bean.HasTimeListBean;

public class HasTimeDAO extends DAO{
	public void getAreas(HasTimeListBean listobjekt) throws HasTimeNotFoundException, SQLException, ClassNotFoundException {
		
		if(listobjekt.getList().isEmpty()) {
			throw new HasTimeNotFoundException("There are no HasTime-Instances found!");
		}
		
		String query = "SELECT * FROM has_time;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		for(int i = 0;rs.next();i++){
			HasTimeBean object = new HasTimeBean();
			object.setBindID(rs.getInt("band_id"));
			object.setDateID(rs.getInt("date_id"));
			listobjekt.setChild(object, i);
			i++;
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	

	
	public static class HasTimeNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		HasTimeNotFoundException(String message){
			super(message);
		}
	}
}