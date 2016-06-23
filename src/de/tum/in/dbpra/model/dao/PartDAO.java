package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.tum.in.dbpra.model.bean.PartListBean;
import de.tum.in.dbpra.model.bean.PartBean;

public class PartDAO extends DAO{
	public void getPartsInAscOrder(PartListBean part, String sortedBy) throws PartNotFoundException, SQLException, ClassNotFoundException {
		
		if(part.getList() == null){
			throw new PartNotFoundException("Partlist is empty!");
		}

		String query = "SELECT * FROM part order by " + sortedBy + " asc";
		Connection con = getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		
		
		ResultSet rs = pstmt.executeQuery();
		
		int i = 0;
		while(rs.next()){
			PartBean p = new PartBean();
			p.setPartkey(rs.getInt("partkey"));
			p.setName(rs.getString("name"));
			p.setType(rs.getString("type"));
			p.setSize(rs.getInt("size"));
			p.setContainer(rs.getInt("container"));
			p.setRetailprice(rs.getDouble("retailprice"));
			part.setChild(p,i);
			i++;
		} 
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
public void getPartsBySearch(PartListBean part, String search, String column, String like, String bsl) throws PartNotFoundException, SQLException, ClassNotFoundException {
		
		if(part.getList()==null) {
			throw new PartNotFoundException("Partlist is empty!");
		}
		String query;
		if(bsl!=null&&bsl.equals("y")){
			if(column.equals("partkey") || column.equals("size") || column.equals("container") || column.equals("retailprice")){
				if(like!=null){
					query = "SELECT * FROM part WHERE "+column+"::varchar LIKE ?;";
				}else{
					query = "SELECT * FROM part WHERE "+column+"::varchar = ?;";
				}
			}else{
				if(like!=null){
					query = "SELECT * FROM part WHERE "+column+" LIKE ?;";
				}else{
					query = "SELECT * FROM part WHERE "+column+" = ?;";
				}
			}
		}else{
			if(column.equals("partkey") || column.equals("size") || column.equals("container") || column.equals("retailprice")){
				if(like!=null){
					query = "SELECT * FROM part WHERE LOWER("+column+"::varchar) LIKE LOWER(?::varchar);";
				}else{
					query = "SELECT * FROM part WHERE LOWER("+column+"::varchar) = LOWER(?::varchar);";
				}
			}else{
				if(like!=null){
					query = "SELECT * FROM part WHERE LOWER("+column+") LIKE LOWER(?);";
				}else{
					query = "SELECT * FROM part WHERE LOWER("+column+") = LOWER(?);";
				}
			}
			
		}
		
		
		Connection con = getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		if(like!=null){
			pstmt.setString(1, "%"+search+"%");
		}else{
			pstmt.setString(1, search);
		}
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			PartBean p = new PartBean();
			p.setPartkey(rs.getInt("partkey"));
			p.setName(rs.getString("name"));
			p.setType(rs.getString("type"));
			p.setSize(rs.getInt("size"));
			p.setContainer(rs.getInt("container"));
			p.setRetailprice(rs.getDouble("retailprice"));
			part.setChild(p,i);
			i++;
		} 
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	public static class PartNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		PartNotFoundException(String message){
			super(message);
		}
	}
	
}
