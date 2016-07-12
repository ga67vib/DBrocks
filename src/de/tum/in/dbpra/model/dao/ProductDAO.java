package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.ProductBean;
import de.tum.in.dbpra.model.bean.ProductListBean;

public class ProductDAO extends DAO {
	public void getProducts(ProductListBean productlist) throws ClassNotFoundException, SQLException {
		String query = "Select * From Product;";
		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			ProductBean product = new ProductBean();
			product.setAddInfo(rs.getString("add_info"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getBigDecimal("price"));
			product.setProductID(rs.getInt("product_id"));
			productlist.setChild(product);
		}

		con.commit();

		rs.close();
		pstmt.close();
		con.close();
	}

	public void getProductbyID(ProductBean productbean, Integer id) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM Product Where product_id= ?;";

		Connection con;
		con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			productbean.setPrice(rs.getBigDecimal("price"));
			productbean.setProductID(rs.getInt("product_id"));
			productbean.setName(rs.getString("name"));
			productbean.setAddInfo(rs.getString("add_Info") == null ? "" : rs.getString("add_Info"));
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}
	public void getProductbySponsorID(ProductListBean productlist, int id) throws ClassNotFoundException, SQLException {
		String query = "SELECT p.product_id, p.name, p.price, p.add_info FROM Product p, Booth b, Sells s Where b.owned_by = " + id + " and s.booth_id = b.booth_id and s.product_id = p.product_id;";

		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			ProductBean product = new ProductBean();
			product.setAddInfo(rs.getString("add_info"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getBigDecimal("price"));
			product.setProductID(rs.getInt("product_id"));
			productlist.setChild(product);
		}

		con.commit();

		rs.close();
		pstmt.close();
		con.close();
	}
	
}
