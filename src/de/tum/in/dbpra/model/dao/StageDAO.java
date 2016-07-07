package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.StageBean;
import de.tum.in.dbpra.model.bean.StageListBean;
import de.tum.in.dbpra.model.bean.AreaBean;
import de.tum.in.dbpra.model.dao.AreaDAO.AreaNotFoundException;

public class StageDAO extends DAO{
	
	public void getStages(StageListBean listobjekt){
		
		String query = "SELECT * FROM Stage;";
		
		Connection con;
		try {
			con = getConnection();
		
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
				{
			StageBean object = new StageBean();
			object.setStageID(rs.getInt("Stage_id"));
			AreaBean ab = new AreaBean();
			AreaDAO ad = new AreaDAO();
			ad.getAreabyID(ab, rs.getInt("is_in"));
			object.setIsin(ab);
			object.setStageID(rs.getInt("stage_id"));
			object.setStageName(rs.getString("stage_name"));
			object.setStageSize(rs.getInt("stage_size"));
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
	public void getStagebyID(StageBean stage, int stageID)
	{
		String query = "Select * From Stage Where StageID=" + stageID;

		Connection con;
		try {
			con = getConnection();
		
		
			con.setAutoCommit(false);
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
		
			while(rs.next())
			{
				stage.setAuditSize(rs.getInt("audit_size"));
				AreaBean ab = new AreaBean();
				AreaDAO ad = new AreaDAO();
				ad.getAreabyID(ab, rs.getInt("is_in"));
				stage.setIsin(ab);
				stage.setStageID(rs.getInt("stage_id"));
				stage.setStageName(rs.getString("stage_name"));
				stage.setStageSize(rs.getInt("stage_size"));
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

	
	public static class StageToNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		StageToNotFoundException(String message){
			super(message);
		}
	}
}