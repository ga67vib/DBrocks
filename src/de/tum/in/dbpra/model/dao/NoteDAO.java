package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import de.tum.in.dbpra.model.bean.NoteBean;
import de.tum.in.dbpra.model.bean.NoteListBean;
import de.tum.in.dbpra.model.dao.AreaDAO.AreaNotFoundException;

public class NoteDAO extends DAO{
	
	public void getNotes(NoteListBean listObject) throws AreaNotFoundException, SQLException, ClassNotFoundException {
		
		
		
		String query = "SELECT * FROM Note;";
		
Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(DAO.getRowCount(rs)==0) {
			throw new AreaNotFoundException("There are no Areas found!");
		}
		
		while(rs.next())
		{
			NoteBean notebean = new NoteBean();
			notebean.setNoteID(rs.getInt("note_id"));
			notebean.setContent(rs.getString("content"));
			notebean.setCreationTime(rs.getDate("creation_time"));
			notebean.setDone(rs.getBoolean("done"));
			
			listObject.setChild(notebean);
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
	}
}