package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import de.tum.in.dbpra.model.bean.AreaBean;
import de.tum.in.dbpra.model.bean.AreaListBean;

public class AreaDAO extends DAO{
	public void getAreas(AreaListBean areas) throws AreaNotFoundException, SQLException, ClassNotFoundException {
		
		if(areas.getList().isEmpty()) {
			throw new AreaNotFoundException("There are no areas found!");
		}
		
		String query = "SELECT * FROM area;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		for(int i = 0;rs.next();i++){
			AreaBean area = new AreaBean();
			area.setAreaID(rs.getInt("area_id"));
			area.setSize(rs.getInt("size"));
			area.setLocation(rs.getInt("location"));
			areas.setChild(area, i);
			i++;
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
public void getAreasWhereColumnIsEqualTo(AreaListBean areas, String column, String search, boolean isLike) throws AreaNotFoundException, SQLException, ClassNotFoundException {
		
		if(areas.getList().isEmpty()) {
			throw new AreaNotFoundException("There are no areas found!");
		}
		
		String query;
		
		if(isLike){
			query = "SELECT * FROM area WHERE "+column+"::varchar LIKE ?;";
		}else{
			query = "SELECT * FROM area WHERE "+column+"::varchar = ?;";
		}
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		if(isLike){
			pstmt.setString(1, "%"+search+"%");
		}else{
			pstmt.setString(1, search);
		}
		
		ResultSet rs = pstmt.executeQuery();
		
		for(int i = 0;rs.next();i++){
			AreaBean area = new AreaBean();
			area.setAreaID(rs.getInt("area_id"));
			area.setSize(rs.getInt("size"));
			area.setLocation(rs.getInt("location"));
			areas.setChild(area, i);
			i++;
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	public static class AreaNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		AreaNotFoundException(String message){
			super(message);
		}
	}
}