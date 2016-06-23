package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import de.tum.in.dbpra.model.bean.OrderBean;
import de.tum.in.dbpra.model.bean.OrderListBean;
import de.tum.in.dbpra.model.dao.CustomerDAO.CustomerNotFoundException;

public class OrderDAO extends DAO{
	public void getOrderstatus(OrderListBean order, String status) throws OrderNotFoundException, SQLException, ClassNotFoundException {
		
		if(!(status.equals("no")||status.equals("ok"))) {
			throw new OrderNotFoundException("There are no orders with status: " + status + "!");
		}
		
		String query = "SELECT * FROM orders WHERE orderstatus = ? order by orderkey asc;";
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, status);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		
		int i = 0;
		while(rs.next()){
			OrderBean o = new OrderBean();
			o.setOrderkey(rs.getInt("orderkey"));
			o.setCustkey(rs.getInt("custkey"));
			o.setOrderstatus(rs.getString("orderstatus"));
			o.setTotalprice(rs.getDouble("totalprice"));
			o.setOrderdate(rs.getString("orderdate"));
			order.setChild(o, i);
			i++;
		} 
		con.commit();
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	public static class OrderNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		OrderNotFoundException(String message){
			super(message);
		}
	}
}