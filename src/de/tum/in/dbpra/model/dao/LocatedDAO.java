package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import de.tum.in.dbpra.model.bean.LocatedBean;
import de.tum.in.dbpra.model.bean.LocatedListBean;

public class LocatedDAO extends DAO{
	public void getLocateds(LocatedListBean listObject) throws LocatedNotFoundException, SQLException, ClassNotFoundException {
		
		if(listObject.getList().isEmpty()) {
			throw new LocatedNotFoundException("There are no Located-Instances found!");
		}
		
		String query = "SELECT * FROM located;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		for(int i = 0;rs.next();i++){
			LocatedBean object = new LocatedBean();
			object.setShiftID(rs.getInt("shift_id"));
			object.setAreaID(rs.getInt("area_id"));
			listObject.setChild(object, i);
			i++;
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	public static class LocatedNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		LocatedNotFoundException(String message){
			super(message);
		}
	}
}