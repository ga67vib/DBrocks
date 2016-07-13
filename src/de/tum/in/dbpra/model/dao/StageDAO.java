package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import de.tum.in.dbpra.model.bean.StageBean;
import de.tum.in.dbpra.model.bean.StageListBean;
import de.tum.in.dbpra.model.bean.AreaBean;

public class StageDAO extends DAO {

	//get all Stages
	public void getStages(StageListBean stageListBean) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM Stage;";

		Connection con;
		con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			StageBean stageBean = new StageBean();
			stageBean.setStageID(rs.getInt("Stage_id"));
			AreaBean ab = new AreaBean();
			AreaDAO ad = new AreaDAO();
			ad.getAreabyID(ab, rs.getInt("is_in"));
			stageBean.setIsin(ab);
			stageBean.setStageID(rs.getInt("stage_id"));
			stageBean.setStageName(rs.getString("stage_name"));
			stageBean.setStageSize(rs.getInt("stage_size"));
			stageBean.setDescription(rs.getString("description"));
			stageListBean.setChild(stageBean);
		}

		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}

	//get Stage by StageID
	public void getStagebyID(StageBean stage, int stageID) throws ClassNotFoundException, SQLException {
		String query = "Select * From Stage Where stage_id=" + stageID;

		Connection con;
		con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			stage.setAuditSize(rs.getInt("audit_size"));
			AreaBean ab = new AreaBean();
			AreaDAO ad = new AreaDAO();
			ad.getAreabyID(ab, rs.getInt("is_in"));
			stage.setIsin(ab);
			stage.setStageID(rs.getInt("stage_id"));
			stage.setStageName(rs.getString("stage_name"));
			stage.setStageSize(rs.getInt("stage_size"));
			stage.setDescription(rs.getString("description"));
		}

		con.commit();
		//close all Resources
		rs.close();
		pstmt.close();
		con.close();

	}

}