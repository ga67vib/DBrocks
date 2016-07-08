package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.ProductBean;
import de.tum.in.dbpra.model.bean.ProductListBean;
import de.tum.in.dbpra.model.dao.AreaDAO.AreaNotFoundException;

public class ProductDAO extends DAO 
{
	public void getProducts(ProductListBean productlist)
	{
		String query = "Select * From Product;";

		Connection con;
		try {
			con = getConnection();
		
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
				{
			ProductBean product = new ProductBean();
			product.setAddInfo(rs.getString("add_info"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getDouble("price"));
			product.setProductID(rs.getInt("product_id"));
			
			productlist.setChild(product);
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
		}
	}
	
	public void getProductbyID(ProductBean productbean, Integer id)
	{
String query = "SELECT * FROM Product Where product_id= ?;";
		
		Connection con;
		try {
			con = getConnection();
		
		con.setAutoCommit(false);
	
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(DAO.getRowCount(rs)==0)
			throw new AreaNotFoundException("There are no Products found!");
		while(rs.next())
		{
			productbean.setPrice(rs.getDouble("price"));
			productbean.setProductID(rs.getInt("product_id"));
			productbean.setName(rs.getString("name"));
			productbean.setAddInfo(rs.getString("add_Info"));
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

}
