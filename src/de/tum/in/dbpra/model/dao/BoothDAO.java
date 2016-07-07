package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import de.tum.in.dbpra.model.bean.AreaBean;
import de.tum.in.dbpra.model.bean.BoothBean;
import de.tum.in.dbpra.model.bean.BoothListBean;
import de.tum.in.dbpra.model.bean.SponsorBean;
import de.tum.in.dbpra.model.dao.AreaDAO.AreaNotFoundException;

public class BoothDAO extends DAO{
	public void getAreas(BoothListBean listobjekt) throws BoothBeanNotFoundException, SQLException, ClassNotFoundException {
		
		if(listobjekt.getList().isEmpty()) {
			throw new BoothBeanNotFoundException("There is no Booth found!");
		}
		
		String query = "SELECT * FROM booth;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		for(int i = 0;rs.next();i++){
			BoothBean object = new BoothBean();
			object.setBoothID(rs.getInt("booth_id"));
			
			SponsorBean temp = new SponsorBean();
			SponsorDAO tempdao = new SponsorDAO ();
			try {
				tempdao.getSponsorbyID(temp,rs.getInt("owned_by"));
			
			object.setOwnedBy(temp);
			
			AreaBean tempa = new AreaBean();
			AreaDAO tempadao = new AreaDAO();
			tempadao.getAreabyID(tempa, rs.getInt("is_in"));
			object.setIsin(tempa);
			
			} catch (AreaNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			object.setSize(rs.getInt("size"));
			object.setName(rs.getString("name"));
			object.setSpecReq(rs.getString("spec_req"));
			object.setType(rs.getString("type"));
			listobjekt.setChild(object, i);
			i++;
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	

	
	public static class BoothBeanNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		BoothBeanNotFoundException(String message){
			super(message);
		}
	}
}