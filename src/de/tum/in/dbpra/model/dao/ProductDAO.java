package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.ProductBean;
import de.tum.in.dbpra.model.bean.ProductListBean;

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

}
