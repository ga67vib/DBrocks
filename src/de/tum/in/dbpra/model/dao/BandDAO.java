package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import de.tum.in.dbpra.model.bean.BandBean;
import de.tum.in.dbpra.model.bean.BandListBean;

public class BandDAO extends DAO{
	public void getAreas(BandListBean listobjekt) throws BandToNotFoundException, SQLException, ClassNotFoundException {
		
		
		
		String query = "SELECT * FROM Band;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(DAO.getRowCount(rs)==0) {
			throw new BandToNotFoundException("There are no bands found!");
		}
		
		while(rs.next())
				{
			BandBean object = new BandBean();
			object.setBandID(rs.getInt("band_id"));
			object.setRegistersAt(rs.getInt("registers_at"));
			object.setBandName(rs.getString("band_name"));
			object.setInstruction(rs.getString("instruction"));
			object.setSonglist(rs.getString("songlist"));
			object.setSalary(rs.getDouble("salary"));
			listobjekt.setChild(object);
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
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