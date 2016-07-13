package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.tum.in.dbpra.model.bean.BandBean;
import de.tum.in.dbpra.model.bean.BandListBean;
import de.tum.in.dbpra.model.bean.PerformanceBean;
import de.tum.in.dbpra.model.bean.PerformanceListBean;
import de.tum.in.dbpra.model.bean.StageBean;

public class PerformanceDAO extends DAO {

	/**
	 * Gets all performances and fills the given PerformanceListBean.
	 */
	public void getPerformances(PerformanceListBean listObject) throws SQLException, ClassNotFoundException {
		String query = "SELECT array_to_string(array_agg(band_name), ', ') AS performers, "
				+ "p.performance_id, stage_name, start_time, end_time " + "FROM Performance p, Stage, rocks r, band b "
				+ "WHERE is_at = stage_id AND p.Performance_ID= r.performance_ID " + "AND r.Band_id = b.Band_id "
				+ "GROUP BY p.performance_id, stage_name, start_time, end_time " + "ORDER BY start_time ASC";

		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		fillPerformance(listObject, rs);
		con.commit();

		rs.close();
		pstmt.close();
		con.close();
	}

	
	public void getBandsbyPerformanceID(BandListBean bandlist, int PerformanceID)
			throws SQLException, ClassNotFoundException {
		String query = "Select b.* From Band b, Performance p, rocks r WHERE p.Performance_ID=? AND p.Performance_ID= r.performance_ID AND r.Band_id = b.Band_id";

		Connection con;
		con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, PerformanceID);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			BandBean band = new BandBean();
			band.setBandID(rs.getInt("band_id"));
			band.setBandName(rs.getString("band_name"));
			band.setInstruction(rs.getString("instruction"));
			band.setSonglist(rs.getString("songlist"));
			band.setSalary(rs.getDouble("salary"));
			bandlist.setChild(band);
		}

		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}

	/**
	 * Gets all performances for a given day, possibly using the visitor_id.
	 * If visitor_id is 0, gets all, if visitor_id is something else, gets the performances for a certain visitor on a certain day.
	 */
	public void getPerformancesByDay(PerformanceListBean listObject, int beginDay, int visitor_id)throws SQLException, ClassNotFoundException  {
			String query = "SELECT array_to_string(array_agg(band_name), ', ') AS performers, "
					+ "p.performance_id, stage_name, start_time, end_time "
					+ "FROM Performance p, Stage, rocks r, band b ";
			if (visitor_id != 0) {
				query += ", timetable t ";
			}
			query += "WHERE is_at = stage_id and start_time::text LIKE ? " + "AND p.Performance_ID= r.performance_ID "
					+ "AND r.Band_id = b.Band_id ";
			if (visitor_id != 0) {
				query += "AND t.Performance_id = p.Performance_ID AND person_id = ? ";
			}
			query += "GROUP BY p.performance_id, stage_name, start_time, end_time "
					+ "ORDER BY stage_name ASC, start_time ASC";
			String searchPattern = "%08-" + beginDay + "%";

			Connection con = getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			pstmt.setString(1, searchPattern);
			if (visitor_id != 0) {
				pstmt.setInt(2, visitor_id);
			}
			ResultSet rs = pstmt.executeQuery();

			fillPerformance(listObject, rs);
			con.commit();

			rs.close();
			pstmt.close();
			con.close();

	}

	private void fillPerformance(PerformanceListBean listObject, ResultSet rs) throws SQLException {
		while (rs.next()) {
			PerformanceBean performanceBean = new PerformanceBean();
			performanceBean.setPerformanceID(rs.getInt("performance_id"));
			performanceBean.setEndTime(rs.getTimestamp("end_time"));
			performanceBean.setStartTime(rs.getTimestamp("start_time"));
			StageBean stageBean = new StageBean();
			stageBean.setStageName(rs.getString("stage_name"));
			performanceBean.setIsAt(stageBean);
			performanceBean.setAllPerformers(rs.getString("performers"));
			listObject.setChild(performanceBean);
		}
	}
	
	/**
	 * Inserts the performances from performanceList into the timetable of visitor with person_id.
	 */
	public void insertPerformancesIntoTimetable(ArrayList<Integer> performanceList, int person_id) throws SQLException, ClassNotFoundException{
		Connection con = getConnection();
		con.setAutoCommit(false);
				
		//insert into the timetable the combination person_id and performance_id for all performances
		PreparedStatement insertPerformanceIntoTimetable = con.prepareStatement("INSERT INTO TIMETABLE(person_id,performance_id) VALUES (?,?)");

		insertPerformanceIntoTimetable.setInt(1, person_id);
		for (int i=0;i<performanceList.size();i++){ 
			insertPerformanceIntoTimetable.setInt(2, performanceList.get(i));
			insertPerformanceIntoTimetable.executeUpdate(); //insert for each performance_id
		}
		//close Resources
		insertPerformanceIntoTimetable.close();
		con.commit();
		con.close();
	}

}
