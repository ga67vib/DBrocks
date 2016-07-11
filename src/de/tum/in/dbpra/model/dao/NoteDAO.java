package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.NoteBean;
import de.tum.in.dbpra.model.bean.NoteListBean;
import de.tum.in.dbpra.model.bean.PersonBean;

public class NoteDAO extends DAO {

	public void getNotes(NoteListBean listObject) throws SQLException, ClassNotFoundException {

		String query = "SELECT * FROM Note n;";

		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			NoteBean notebean = new NoteBean();
			notebean.setNoteID(rs.getInt("note_id"));
			notebean.setContent(rs.getString("content"));
			notebean.setCreationTime(rs.getDate("creation_time"));
			notebean.setDone(rs.getBoolean("done"));
			PersonDAO pd = new PersonDAO();
			notebean.setAttachedto(pd.getPersonsByNoteID(rs.getInt("note_id"))); //get Persons for this note
			listObject.setChild(notebean);
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();
	}

	/**
	 * Inserts a note with content as content, and assigns it to all persons in person_ids. Handles everything as one transaction.
	 * @param person_ids
	 * @param content
	 */
	public void insertNotes(int[] person_ids, String content) throws SQLException, ClassNotFoundException{
		Connection con = getConnection();
		con.setAutoCommit(false);
		//first get the next note_id for the insert, and for then knowing it to insert into assigned_to
		PreparedStatement getNoteID = con.prepareStatement("SELECT MAX(note_id)+1 FROM NOTE");
		ResultSet rs = getNoteID.executeQuery();
		rs.next(); //we can always do this, since a next note_id must exist, else the query fails
		int noteID = rs.getInt(1);
		rs.close();
		getNoteID.close();
		
		PreparedStatement insertNote = con.prepareStatement("INSERT INTO NOTE(note_id,content,creation_time,done) VALUES (?,?,(SELECT LOCALTIMESTAMP),FALSE)");
		insertNote.setInt(1, noteID);
		insertNote.setString(2, content);
		insertNote.executeUpdate(); //insert note
		insertNote.close();
		
		//now we want to insert into assigned_to the combination note_id and alle person_ids
		PreparedStatement insertAssignedTo = con.prepareStatement("INSERT INTO assigned_to(note_id,person_id) VALUES (?,?)");
		insertAssignedTo.setInt(1, noteID);
		for (int i=0;i<person_ids.length;i++){ 
			insertAssignedTo.setInt(2, person_ids[i]);
			insertAssignedTo.executeUpdate(); //insert for each person_id
		}
		insertAssignedTo.close();
		
		con.commit();
		con.close();
		
		
	}
	
}