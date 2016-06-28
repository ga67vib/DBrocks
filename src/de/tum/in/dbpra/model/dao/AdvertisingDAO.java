package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import de.tum.in.dbpra.model.bean.AdvertisingBean;
import de.tum.in.dbpra.model.bean.AdvertisingListBean;

public class AdvertisingDAO extends DAO{
	public void getAdvertising(AdvertisingListBean listObject) throws AdvertisingNotFoundException, SQLException, ClassNotFoundException {
		
		if(listObject.getList().isEmpty()) {
			throw new AdvertisingNotFoundException("There are no Advertises found!");
		}
		
		String query = "SELECT * FROM advertising;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		for(int i = 0;rs.next();i++){
			AdvertisingBean object = new AdvertisingBean();
			object.setAreaID(rs.getInt("area_id"));
			object.setSponsorID(rs.getInt("sponsor_id"));
			object.setType(rs.getString("type"));
			listObject.setChild(object, i);
			i++;
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	
	public static class AdvertisingNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		AdvertisingNotFoundException(String message){
			super(message);
		}
	}
}