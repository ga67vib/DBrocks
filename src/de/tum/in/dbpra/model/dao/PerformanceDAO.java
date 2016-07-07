package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.AreaBean;
import de.tum.in.dbpra.model.bean.PerformanceBean;
import de.tum.in.dbpra.model.bean.StageBean;
import de.tum.in.dbpra.model.bean.PerformanceListBean;
import de.tum.in.dbpra.model.dao.AreaDAO.AreaNotFoundException;

public class PerformanceDAO extends DAO {
	
	public void getPerformances(PerformanceListBean listObject)
	{
			
		try {
			
			
			String query = "SELECT * FROM Performance;";
			
			Connection con = getConnection();
			
			con.setAutoCommit(false);
			
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
		
			
			while(rs.next())
			{
				PerformanceBean performancebean = new PerformanceBean();
				performancebean.setPerformanceID(rs.getInt("performance_id"));
				performancebean.setEndRemoval(rs.getDate("end_removal"));
				performancebean.setEndTime(rs.getDate("end_time"));
				performancebean.setStartTime(rs.getDate("start_time"));
				performancebean.setStartBuildUp(rs.getDate("start_build_up"));
			 
				StageBean temp = new StageBean();
				StageDAO tempa = new StageDAO();
				tempa.getStagebyID(temp, rs.getInt("is_at"));
				
				performancebean.setIsAt(temp);
				
				//areabean.setSponsorBean(new SponsorBean(),rs.getInt(columnLabel))
				listObject.setChild(performancebean);
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
			} catch (AreaNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
