package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import de.tum.in.dbpra.model.bean.NoteListBean;
import de.tum.in.dbpra.model.bean.PersonBean;
import de.tum.in.dbpra.model.bean.PersonListBean;

public class PersonDAO extends DAO{
	
	public void getPersons(PersonListBean personsBean) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM Person;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next())
		{
			PersonBean personBean = new PersonBean();
			personBean.setAddress(rs.getString("Address"));
			personBean.setBirthdate(rs.getDate("Birthdate"));
			personBean.setDoNotify(rs.getBoolean("Do_Notify"));
			personBean.setFirstName(rs.getString("First_Name"));
			personBean.setGender(rs.getString("Gender"));
			personBean.setLastName(rs.getString("Last_Name"));
			personBean.setMail(rs.getString("Mail"));
			personBean.setPersonID(rs.getInt("Person_ID"));
			personBean.setPhonenumber(rs.getString("Phone_number"));
			//personBean.setNotes(new NoteListBean());
			personsBean.setChild(personBean);
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	
	public void getPersonbyID(PersonBean personBean, int PersonID) throws SQLException, ClassNotFoundException {
		
		
		
		String query = "SELECT * FROM Person Where person_id=?";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, PersonID);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next()){
			personBean.setAddress(rs.getString("Address"));
			personBean.setBirthdate(rs.getDate("Birthdate"));
			personBean.setDoNotify(rs.getBoolean("Do_Notify"));
			personBean.setFirstName(rs.getString("First_Name"));
			personBean.setGender(rs.getString("Gender"));
			personBean.setLastName(rs.getString("Last_Name"));
			personBean.setMail(rs.getString("Mail"));
			personBean.setPersonID(rs.getInt("Person_ID"));
			personBean.setPhonenumber(rs.getString("Phone_number"));
			personBean.setNotes(new NoteListBean());
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	
	/**
	 * Fills a personBean according to a mail address.
	 * Since mail is unique, this works fine.
	 * Used for login, to get password and person_id with one query, and then check everything.
	 * @param personBean The bean to be filled
	 * @param mail The mail address to get the person for
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void getPersonbyMail(PersonBean personBean, String mail) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM Person Where mail=?";
		Connection con = getConnection();
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1, mail);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next()){
			personBean.setAddress(rs.getString("Address"));
			personBean.setBirthdate(rs.getDate("Birthdate"));
			personBean.setDoNotify(rs.getBoolean("Do_Notify"));
			personBean.setFirstName(rs.getString("First_Name"));
			personBean.setGender(rs.getString("Gender"));
			personBean.setLastName(rs.getString("Last_Name"));
			personBean.setMail(rs.getString("Mail"));
			personBean.setPersonID(rs.getInt("Person_ID"));
			personBean.setPhonenumber(rs.getString("Phone_number"));
			personBean.setPassword(rs.getString("password"));
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	/**
	 * Finds out, whether a certain personID belongs to a visitor.
	 * Could also be located in VisitorDAO. For performance reasons on login, it is located here.
	 * @param personID The personID to be checked
	 * @return True iff the personID belongs to a visitor
	 */
	public boolean isVisitor(int personID) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM Visitor Where person_ID=?";
		Connection con = getConnection();
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, personID);
		
		ResultSet rs = pstmt.executeQuery();
		
		boolean result = getRowCount(rs)==1; //if exactly one row is returned, then there is one visitor with the personID 
		
		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		return result;
	}
	
	/**
	 * Finds out, whether a certain personID belongs to a staff member.
	 * Could also be located in StaffDAO. For performance reasons on login, it is located here.
	 * @param personID The personID to be checked
	 * @return True iff the personID belongs to a staff member
	 */
	public boolean isStaffMember(int personID) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM Staff Where personID=?";
		Connection con = getConnection();
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, personID);
		
		ResultSet rs = pstmt.executeQuery();
		
		boolean result = getRowCount(rs)==1; //if exactly one row is returned, then there is one staff member with the personID 
		
		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		return result;
	}
	
	
}
