package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.ShiftBean;
import de.tum.in.dbpra.model.bean.ShiftListBean;
import de.tum.in.dbpra.model.bean.StaffBean;
import de.tum.in.dbpra.model.bean.StaffListBean;

public class ShiftDAO extends DAO {
	
	//get all Shifts by StaffID
	//if StaffID <= 0, then get ALL Shift
	public void getShiftsbyStaffID(ShiftListBean shiftlist, int staffId) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM Shift";
		if (staffId > 0) {
			query = "select s.* from shift s, works w WHERE person_id = ? "
					+ "AND w.shift_id = s.shift_id;";
		}

		Connection con;
		con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		if (staffId > 0) {
			pstmt.setInt(1, staffId);
		}

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			ShiftBean shift = new ShiftBean();
			shift.setEndTime(rs.getTimestamp("end_time"));
			shift.setStartTime(rs.getTimestamp("start_time"));
			shift.setShiftID(rs.getInt("shift_id"));
			shift.setWorkers(countWorkersPerShift(rs.getInt("shift_id")));
			shiftlist.setChild(shift);
		}

		con.commit();
		//close Resources
		rs.close();
		pstmt.close();
		con.close();
	}
	//getShift by ShiftID
	public void getShiftbyID(ShiftBean shiftbean, Integer id) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM Shift Where shift_id = ?;";

		Connection con;
		con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			shiftbean.setEndTime(rs.getTimestamp("end_time"));
			shiftbean.setStartTime(rs.getTimestamp("start_time"));
			shiftbean.setShiftID(rs.getInt("shift_id"));
			shiftbean.setWorkers(countWorkersPerShift(id));
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}

	public int countWorkersPerShift(int shiftId) throws ClassNotFoundException, SQLException {
		String query = "Select count(*)  AS count from works w WHERE shift_ID = ?";
		Connection con;
		con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, shiftId);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int count = rs.getInt("count");
		rs.close();
		pstmt.close();
		con.commit();
		con.close();
		return count;
	}

	/*
	 * TO-DO? public void getShiftbyAreaID(StaffListBean shiftlist, Integer id)
	 * { String query =
	 * "SELECT s.person_id,s.profession,s.salary FROM Staff s, works w Where s.shift_id = ?;"
	 * ;
	 * 
	 * Connection con; try { con = getConnection();
	 * 
	 * con.setAutoCommit(false);
	 * 
	 * PreparedStatement pstmt = con.prepareStatement(query,
	 * ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	 * pstmt.setInt(1, id); ResultSet rs = pstmt.executeQuery();
	 * if(DAO.getRowCount(rs)==0) throw new AreaNotFoundException(
	 * "There are no Workers found!"); while(rs.next()) { StaffBean staff = new
	 * StaffBean(); staff.setPersonID(rs.getInt("person_id"));
	 * staff.setProfession(rs.getString("profession"));
	 * staff.setSalary(rs.getDouble("salary")); stafflist.setChild(staff); }
	 * con.commit();
	 * 
	 * rs.close(); pstmt.close(); con.close();
	 * 
	 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } catch (AreaNotFoundException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } }
	 */
}
