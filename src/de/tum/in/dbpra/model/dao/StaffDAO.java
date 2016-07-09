package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.StaffBean;
import de.tum.in.dbpra.model.bean.StaffListBean;

public class StaffDAO extends DAO
{
	public void getStaff(StaffListBean stafflist)
	{
		String query = "Select * From Staff;";
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
			staff.setProfession(rs.getString("profession"));
			staff.setSalary(rs.getDouble("salary"));
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
