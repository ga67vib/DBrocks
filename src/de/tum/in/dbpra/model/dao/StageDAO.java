package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.AreaBean;
import de.tum.in.dbpra.model.bean.StageBean;
import de.tum.in.dbpra.model.bean.StageListBean;
import de.tum.in.dbpra.model.dao.AreaDAO.AreaNotFoundException;

public class StageDAO extends DAO{
	
	
public void getStages(StageListBean listObject)
{
		
	try {
		
		
		String query = "SELECT * FROM Stage;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
	
		
		while(rs.next())
		{
			StageBean stagebean = new StageBean();
			stagebean.setStageID(rs.getInt("stage_id"));
			stagebean.setStageSize(rs.getInt("size"));
			stagebean.setStageName(rs.getString("stage_name"));
			stagebean.setAuditSize(rs.getInt("audit_size"));
			
			AreaBean temp = new AreaBean();
			AreaDAO tempdao = new AreaDAO();
			tempdao.getAreabyID(temp, rs.getInt("is_in"));
			stagebean.setIsin(temp);
			
			//areabean.setSponsorBean(new SponsorBean(),rs.getInt(columnLabel))
			listObject.setChild(stagebean);
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
	
public void getStagebyID(StageBean stagebean, int StageID) throws AreaNotFoundException, SQLException, ClassNotFoundException {
	
	
	
	String query = "SELECT * FROM Stage Where stage_id=?";
	
	Connection con = getConnection();
	
	con.setAutoCommit(false);
	
	PreparedStatement pstmt = con.prepareStatement(query);
	pstmt.setInt(1, StageID);
	
	ResultSet rs = pstmt.executeQuery();
	
	if(DAO.getRowCount(rs)==0) {
		throw new AreaNotFoundException("There are no Areas found!");
	}
	
	while(rs.next()){
		stagebean.setStageID(rs.getInt("stage_id"));
		stagebean.setStageSize(rs.getInt("size"));
		stagebean.setStageName(rs.getString("stage_name"));
		stagebean.setAuditSize(rs.getInt("audit_size"));
		
		AreaBean temp = new AreaBean();
		AreaDAO tempdao = new AreaDAO();
		tempdao.getAreabyID(temp, rs.getInt("is_in"));
		stagebean.setIsin(temp);
	} 
	con.commit();
	
	rs.close();
	pstmt.close();
	con.close();
	
}

}
