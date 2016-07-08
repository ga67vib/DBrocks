package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.ProductBean;
import de.tum.in.dbpra.model.bean.RFID_TicketBean;
import de.tum.in.dbpra.model.bean.TransactionBean;
import de.tum.in.dbpra.model.bean.TransactionListBean;
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
	
	public void getTransactions(TransactionListBean transactionlist)
	{
		String query = "Select * From Transaction;";
		try {
			Connection con = getConnection();
			
			con.setAutoCommit(false);
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(DAO.getRowCount(rs)==0)
				throw new AreaNotFoundException("TransactionsNotfound");
			
			while(rs.next())
			{
				TransactionBean transactionbean = new TransactionBean();
				transactionbean.setTransactionTime(rs.getDate("transaction_time"));
				transactionbean.setTransactionID(rs.getInt("transaction_id"));
				transactionlist.setChild(transactionbean);
			}
			
			
			con.commit();
			
			rs.close();
			pstmt.close();
			con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AreaNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//fill the foreignkey constraints 
	public void fillTransactions(TransactionListBean transactionlist)
	{
		
		try {
		
		
			
				for(int i=0;i<transactionlist.getList().size();i++)
				{	
					TransactionBean transactionbean = transactionlist.getChild(i);
					String query = "Select * From Transaction Where transaction_id = ?;";
					Connection con = getConnection();
					
					con.setAutoCommit(false);
					
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setInt(1, transactionbean.getTransactionID());
					ResultSet rs = pstmt.executeQuery();
					
					if(DAO.getRowCount(rs)==0)
						throw new AreaNotFoundException("TransactionsNotfound");
					ProductBean productbean = new ProductBean();
					ProductDAO productdao = new ProductDAO();
					productdao.getProductbyID(productbean, rs.getInt("product_id"));
					
					RFID_TicketBean ticketbean = new RFID_TicketBean();
					RFID_TicketDAO ticketDAO = new RFID_TicketDAO();
					ticketDAO.getTicketbyID(ticketbean, rs.getInt("ticket_id"));
					
					con.commit();
					
					rs.close();
					pstmt.close();
					con.close();
				}
				

			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AreaNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	

}
