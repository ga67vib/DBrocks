package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.BandBean;
import de.tum.in.dbpra.model.bean.BandListBean;
import de.tum.in.dbpra.model.bean.PerformanceBean;
import de.tum.in.dbpra.model.bean.PerformanceListBean;
import de.tum.in.dbpra.model.bean.StageBean;

public class BandDAO extends DAO{
	
	public void getBands(BandListBean listobjekt){
		
		String query = "SELECT * FROM Band;";
		
		Connection con;
		try {
			con = getConnection();
		
		
			con.setAutoCommit(false);
			
			PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				BandBean object = new BandBean();
				object.setBandID(rs.getInt("band_id"));
				object.setBandName(rs.getString("band_name"));
				object.setInstruction(rs.getString("instruction"));
				object.setSonglist(rs.getString("songlist"));
				object.setSalary(rs.getDouble("salary"));
				//PerformanceListBean rocks = new PerformanceListBean();
				//getPerformancesbyBandID(rocks, rs.getInt("band_id"));
				//object.setRocks(rocks);
				listobjekt.setChild(object);
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
	public void getPerformancesbyBandID(PerformanceListBean performancelist, int BandID)
	{
		String query = "Select * From Performance JOIN rocks ON Performance.performance_id=rocks.performance_id Where Band_ID=?";

		Connection con;
		try {
			con = getConnection();
		
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, BandID);
		
		ResultSet rs = pstmt.executeQuery();
	
		while(rs.next())
		{
			PerformanceBean performancebean = new PerformanceBean();
			performancebean.setPerformanceID(rs.getInt("performance_id"));
			performancebean.setEndRemoval(rs.getTimestamp("end_removal"));
			performancebean.setEndTime(rs.getTimestamp("end_time"));
			performancebean.setStartTime(rs.getTimestamp("start_time"));
			performancebean.setStartBuildUp(rs.getTimestamp("start_build_up"));
			BandListBean bandstemp = new BandListBean();
			performancebean.setGerockt(bandstemp);
			StageBean temp = new StageBean();
			StageDAO tempa = new StageDAO();
			tempa.getStagebyID(temp, rs.getInt("is_at"));
			
			performancebean.setIsAt(temp);
		
			performancelist.setChild(performancebean);
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

	
	public static class BandToNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		BandToNotFoundException(String message){
			super(message);
		}
	}
}