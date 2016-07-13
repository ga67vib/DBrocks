package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.BoothBean;
import de.tum.in.dbpra.model.bean.ProductBean;
import de.tum.in.dbpra.model.bean.RFID_TicketBean;
import de.tum.in.dbpra.model.bean.TransactionBean;
import de.tum.in.dbpra.model.bean.TransactionListBean;

public class TransactionDAO extends DAO {

	//get Transaction by Transaction_ID
	public void getTransactionbyID(TransactionBean transactionbean, int id)
			throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM Transaction Where transaction_id = ?;";

		Connection con;
		con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			transactionbean.setTransactionTime(rs.getTimestamp("transaction_time"));
			transactionbean.setTransactionID(rs.getInt("transaction_id"));
			transactionbean.setQuantity(rs.getInt("quantity"));
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();
	}

	//get all Transactions
	public void getTransactions(TransactionListBean transactionlist) throws ClassNotFoundException, SQLException {
		String query = "Select t.transaction_ID,b.booth_id,t.transaction_time, p.name, t.Ticket_id, quantity, b.name AS booth_name "
				+ "From Transaction t,Booth b, Product p "
				+ "WHERE p.product_id = t.product_id AND b.booth_id = t.booth_id "
				+ "ORDER BY t.transaction_ID ASC";

		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			TransactionBean transactionbean = new TransactionBean();
			transactionbean.setTransactionTime(rs.getTimestamp("transaction_time"));
			transactionbean.setTransactionID(rs.getInt("transaction_id"));
			transactionbean.setQuantity(rs.getInt("quantity"));
			ProductBean productbean = new ProductBean();
			productbean.setName(rs.getString("name"));

			BoothBean boothbean = new BoothBean();
			boothbean.setBoothID(rs.getInt("booth_id"));
			boothbean.setName(rs.getString("booth_name"));
			RFID_TicketBean ticketbean = new RFID_TicketBean();
			
			/*possible other Solution by Arni, may be unperformant
			RFID_TicketDAO ticketDAO = new RFID_TicketDAO();
			//ticketDAO.getTicketbyID(ticketbean, rs.getInt("ticket_id"));*/
			
			ticketbean.setTicketID(rs.getInt("ticket_id"));
			transactionbean.setProduct(productbean);
			transactionbean.setTicket(ticketbean);
			transactionbean.setBooth(boothbean);
			transactionlist.setChild(transactionbean);
		}

		con.commit();

		rs.close();
		pstmt.close();
		con.close();
	}
	//get all Transactions from Booths owned by Sponsor(SponsorID)
	public void getTransactionsBySponsorID(TransactionListBean transactionlist, int id) throws ClassNotFoundException, SQLException {
		String query = "Select t.transaction_ID,b.booth_id,t.transaction_time, p.name, t.Ticket_id, quantity, b.name AS booth_name "
				+ "From Transaction t,Booth b, Product p "
				+ "WHERE p.product_id = t.product_id AND b.owned_by = ? AND b.booth_id = t.booth_id ORDER BY t.transaction_ID ASC";

		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			TransactionBean transactionbean = new TransactionBean();
			transactionbean.setTransactionTime(rs.getTimestamp("transaction_time"));
			transactionbean.setTransactionID(rs.getInt("transaction_id"));
			transactionbean.setQuantity(rs.getInt("quantity"));
			ProductBean productbean = new ProductBean();
			productbean.setName(rs.getString("name"));

			BoothBean boothbean = new BoothBean();
			boothbean.setBoothID(rs.getInt("booth_id"));
			boothbean.setName(rs.getString("booth_name"));
			RFID_TicketBean ticketbean = new RFID_TicketBean();
			ticketbean.setTicketID(rs.getInt("ticket_id"));
			transactionbean.setProduct(productbean);
			transactionbean.setTicket(ticketbean);
			transactionbean.setBooth(boothbean);
			transactionlist.setChild(transactionbean);
		}

		con.commit();
		//close all Resources
		rs.close();
		pstmt.close();
		con.close();
	}

	public void getTransactionsbyPersonID(TransactionListBean tlist, int person_id) throws ClassNotFoundException, SQLException
	{

		
		String query = "select t.transaction_id, p.name, p.price, t.quantity, b.name as booth_name, (p.price*t.quantity) as totalprice, t.transaction_time"
				+" from Transaction t, product p, rfid_ticket r, booth b"
				+" where t.product_id = p.product_id"
				+" and t.ticket_Id = r.ticket_id"
				+" and t.booth_id = b.booth_id"
				+" and r.owned_by = ?";
		
		//query = "select * from transaction";
		
		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, person_id);

		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			/**
			TransactionBean tbean = new TransactionBean();
			tbean.setTransactionID(rs.getInt("transaction_id"));
			getTransactionbyID(tbean, rs.getInt("transaction_id"));
			tlist.setChild(tbean);
			**/
			
			TransactionBean transactionbean = new TransactionBean();
			transactionbean.setTransactionTime(rs.getTimestamp("transaction_time"));
			transactionbean.setQuantity(rs.getInt("quantity"));
			
			ProductBean productbean = new ProductBean();
			productbean.setName(rs.getString("name"));
			productbean.setPrice(rs.getBigDecimal("price"));

			BoothBean boothbean = new BoothBean();
			boothbean.setName(rs.getString("booth_name"));
			
			//RFID_TicketBean ticketbean = new RFID_TicketBean();
			//ticketbean.setTicketID(rs.getInt("ticket_id"));

			transactionbean.setProduct(productbean);
			//transactionbean.setTicket(ticketbean);
			transactionbean.setBooth(boothbean);
			tlist.setChild(transactionbean);
		}
		con.commit();
		//close all Resources
		rs.close();
		pstmt.close();
		con.close();
		
		
		
	}
	
}
