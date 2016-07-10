package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.PersonBean;
import de.tum.in.dbpra.model.bean.StaffBean;
import de.tum.in.dbpra.model.bean.StaffListBean;

public class StaffDAO extends DAO
{
	public void getStaff(StaffListBean stafflist)
	{
		String query = "Select * From Staff s, Person p WHERE p.person_id = s.person_id;";
		Connection con;
		try {
			con = getConnection();
		
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
				{
			StaffBean staff = new StaffBean();
			staff.setPersonID(rs.getInt("person_id"));
			PersonBean personData = new PersonBean();
			personData.setAddress(rs.getString("Address"));
			personData.setBirthdate(rs.getDate("Birthdate"));
			personData.setDoNotify(rs.getBoolean("Do_Notify"));
			personData.setFirstName(rs.getString("First_Name"));
			personData.setGender(rs.getString("Gender"));
			personData.setLastName(rs.getString("Last_Name"));
			personData.setMail(rs.getString("Mail"));
			personData.setPersonID(rs.getInt("Person_ID"));
			personData.setPhonenumber(rs.getString("Phone_number"));
			staff.setPersonData(personData);
			staff.setProfession(rs.getString("profession"));
			staff.setSalary(rs.getBigDecimal("salary"));
			stafflist.setChild(staff);
		} 
		
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
