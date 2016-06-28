package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import de.tum.in.dbpra.model.bean.AssignedToBean;
import de.tum.in.dbpra.model.bean.AssignedToListBean;

public class AssignedToDAO extends DAO{
	public void getAreas(AssignedToListBean listobjekt) throws AssignedToNotFoundException, SQLException, ClassNotFoundException {
		
		if(listobjekt.getList().isEmpty()) {
			throw new AssignedToNotFoundException("There are no AssignedTo-Instances found!");
		}
		
		String query = "SELECT * FROM assigned_to;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		for(int i = 0;rs.next();i++){
			AssignedToBean object = new AssignedToBean();
			object.setPersonID(rs.getInt("person_id"));
			object.setNoteID(rs.getInt("note_id"));
			listobjekt.setChild(object, i);
			i++;
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	

	
	public static class AssignedToNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		AssignedToNotFoundException(String message){
			super(message);
		}
	}
}