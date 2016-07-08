package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.AreaBean;
import de.tum.in.dbpra.model.bean.NoteListBean;
import de.tum.in.dbpra.model.bean.PersonBean;
import de.tum.in.dbpra.model.bean.PersonListBean;

public class PersonDAO extends DAO{
	
	public void getPersons(PersonListBean personsBean) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM Area;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next())
		{
			PersonBean personBean = new PersonBean();
			personBean.setAddress(rs.getString("Address"));
			personBean.setBirthdate(rs.getDate("Birthdate"));
			personBean.setDoNotify(rs.getBoolean("DoNotify"));
			personBean.setFirstName(rs.getString("FirstName"));
			personBean.setGender(rs.getString("Gender"));
			personBean.setLastName(rs.getString("LastName"));
			personBean.setMail(rs.getString("Mail"));
			personBean.setPersonID(rs.getInt("PersonID"));
			personBean.setPhonenumber(rs.getString("Phonenumber"));
			personBean.setNotes(new NoteListBean());
			//areabean.setSponsorBean(new SponsorBean(),rs.getInt(columnLabel))
			personsBean.setChild(personBean);
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	
	public void getPersonbyID(PersonBean personBean, int PersonID) throws SQLException, ClassNotFoundException {
		
		
		
		String query = "SELECT * FROM Person Where area_id=?";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, PersonID);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next()){
			personBean.setAddress(rs.getString("Address"));
			personBean.setBirthdate(rs.getDate("Birthdate"));
			personBean.setDoNotify(rs.getBoolean("DoNotify"));
			personBean.setFirstName(rs.getString("FirstName"));
			personBean.setGender(rs.getString("Gender"));
			personBean.setLastName(rs.getString("LastName"));
			personBean.setMail(rs.getString("Mail"));
			personBean.setPersonID(rs.getInt("PersonID"));
			personBean.setPhonenumber(rs.getString("Phonenumber"));
			personBean.setNotes(new NoteListBean());
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
}
