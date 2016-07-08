package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.TransactionBean;
import de.tum.in.dbpra.model.dao.AreaDAO.AreaNotFoundException;

public class TransactionDAO extends DAO{
	
	public void getTransactionbyID(TransactionBean transactionbean, int id)
	{
	String query = "SELECT * FROM Transaction Where transaction_id = ?;";
		
		Connection con;
		try {
			con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(DAO.getRowCount(rs)==0)
			throw new AreaNotFoundException("There are no Sponsor found!");
		while(rs.next())
		{
			transactionbean.setTransactionTime(rs.getDate("transaction_time"));
			transactionbean.setTransactionID(rs.getInt("transaction_id"));
		}
		
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
