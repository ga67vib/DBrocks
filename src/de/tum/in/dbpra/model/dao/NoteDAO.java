package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import de.tum.in.dbpra.model.bean.NoteBean;
import de.tum.in.dbpra.model.bean.NoteListBean;

public class NoteDAO extends DAO{
	public void getAreas(NoteListBean listObject) throws AreaNotFoundException, SQLException, ClassNotFoundException {
		
		if(listObject.getList().isEmpty()) {
			throw new AreaNotFoundException("There are no Notes found!");
		}
		
		String query = "SELECT * FROM Note;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		for(int i = 0;rs.next();i++){
			NoteBean object = new NoteBean();
			object.setNoteID(rs.getInt("note_id"));
			object.setCreationTime(rs.getDate("creation_time"));
			object.setDone(rs.getBoolean("done"));
			object.setContent(rs.getString("content"));
			listObject.setChild(object, i);
			i++;
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