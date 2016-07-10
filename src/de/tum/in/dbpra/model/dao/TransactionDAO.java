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
import de.tum.in.dbpra.model.dao.AreaDAO.AreaNotFoundException;

public class TransactionDAO extends DAO {

	public void getTransactionbyID(TransactionBean transactionbean, int id) {
		String query = "SELECT * FROM Transaction Where transaction_id = ?;";

		Connection con;
		try {
			con = getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (DAO.getRowCount(rs) == 0)
				throw new AreaNotFoundException("There are no Sponsor found!");
			while (rs.next()) {
				transactionbean.setTransactionTime(rs.getTimestamp("transaction_time"));
				transactionbean.setTransactionID(rs.getInt("transaction_id"));
				transactionbean.setQuantity(rs.getInt("quantity"));
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

	public void getTransactions(TransactionListBean transactionlist) {
		String query = "Select t.transaction_ID,b.booth_id,t.transaction_time, p.name, t.Ticket_id, b.name AS booth_name From Transaction t,Booth b, Product p WHERE p.product_id = t.product_id AND b.booth_id = t.booth_id ORDER BY t.transaction_ID ASC";
		try {
			Connection con = getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = pstmt.executeQuery();

			if (DAO.getRowCount(rs) == 0)
				throw new AreaNotFoundException("TransactionsNotfound");

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

}
