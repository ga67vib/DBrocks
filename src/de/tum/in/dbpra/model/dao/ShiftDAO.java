package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.ShiftBean;
import de.tum.in.dbpra.model.bean.ShiftListBean;
import de.tum.in.dbpra.model.bean.TransactionBean;
import de.tum.in.dbpra.model.dao.AreaDAO.AreaNotFoundException;

public class ShiftDAO extends DAO 
{
public void getShifts(ShiftListBean shiftlist){
		
		String query = "SELECT * FROM Shift;";
		
		Connection con;
		try {
			con = getConnection();
		
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			ShiftBean shift = new ShiftBean();
			shift.setEndTime(rs.getDate("end_time"));
			shift.setStartTime(rs.getDate("start_time"));
			shift.setShiftID(rs.getInt("shift_id"));
			shiftlist.setChild(shift);
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
	
	public void getShiftbyID(ShiftBean shiftbean, Integer id)
	{
		String query = "SELECT * FROM Shift Where shift_id = ?;";
			
			Connection con;
			try {
				con = getConnection();
			
			con.setAutoCommit(false);
		
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(DAO.getRowCount(rs)==0)
				throw new AreaNotFoundException("There are no Shifts found!");
			while(rs.next())
			{
				shiftbean.setEndTime(rs.getDate("end_time"));
				shiftbean.setStartTime(rs.getDate("start_time"));
				shiftbean.setShiftID(rs.getInt("shift_id"));
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
			} catch (AreaNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
