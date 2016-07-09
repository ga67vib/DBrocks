package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import de.tum.in.dbpra.model.bean.BandBean;
import de.tum.in.dbpra.model.bean.BandListBean;
import de.tum.in.dbpra.model.bean.PerformanceBean;
import de.tum.in.dbpra.model.bean.StageBean;
import de.tum.in.dbpra.model.bean.PerformanceListBean;

public class PerformanceDAO extends DAO {
	
	public void getPerformances(PerformanceListBean listObject)
	{
			
		try {
			
			
			String query = "SELECT * FROM Performance;";
			
			Connection con = getConnection();
			
			con.setAutoCommit(false);
			
			
			PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = pstmt.executeQuery();
		
			
			while(rs.next())
			{
				PerformanceBean performance = new PerformanceBean();
				performance.setPerformanceID(rs.getInt("performance_id"));
				performance.setEndRemoval(rs.getDate("end_removal"));
				performance.setEndTime(rs.getDate("end_time"));
				performance.setStartTime(rs.getDate("start_time"));
				performance.setStartBuildUp(rs.getDate("start_build_up"));
				BandListBean bandstemp = new BandListBean();
				//getBandsbyPerformanceID(bandstemp,rs.getInt("performance_id"));
				performance.setGerockt(bandstemp);
				StageBean temp = new StageBean();
				StageDAO tempa = new StageDAO();
				tempa.getStagebyID(temp, rs.getInt("is_at"));
				
				performance.setIsAt(temp);
				
				//areabean.setSponsorBean(new SponsorBean(),rs.getInt(columnLabel))
				listObject.setChild(performance);
			} 
			con.commit();
			
			rs.close();
			pstmt.close();
			con.close();
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	
	public void getBandsbyPerformanceID(BandListBean bandlist, int PerformanceID)
	{
		String query = "Select * From Performance Where PerformanceID=?";

		Connection con;
		try {
			con = getConnection();
		
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, PerformanceID);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
				{
			BandBean band = new BandBean();
			band.setBandID(rs.getInt("band_id"));
			band.setRegistersAt(rs.getInt("registers_at"));
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
