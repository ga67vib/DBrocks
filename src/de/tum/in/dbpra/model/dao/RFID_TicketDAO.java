package de.tum.in.dbpra.model.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.PersonBean;
import de.tum.in.dbpra.model.bean.RFID_TicketBean;
import de.tum.in.dbpra.model.bean.RFID_TicketListBean;

public class RFID_TicketDAO extends DAO {

	public void getTickets(RFID_TicketListBean ticketListBean) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM RFID_Ticket;";
		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			RFID_TicketBean RFIDbean = new RFID_TicketBean();
			RFIDbean.setTicketID(rs.getInt("ticket_id"));
			RFIDbean.setAcctBal(rs.getBigDecimal("acct_bal"));
			RFIDbean.setCamper(rs.getBoolean("is_Camper"));
			RFIDbean.setVIP(rs.getBoolean("is_VIP"));
			RFIDbean.setPurchaseDate(rs.getDate("purchase_Date"));
			RFIDbean.setValidFrom(rs.getDate("valid_From"));
			RFIDbean.setValidUntil(rs.getDate("valid_Until"));
			RFIDbean.setPrice(rs.getInt("price"));
			PersonBean ownedBy = new PersonBean();
			PersonDAO personData = new PersonDAO();
			personData.getPersonbyID(ownedBy, rs.getInt("owned_by"));
			RFIDbean.setOwnedBy(ownedBy);
			ticketListBean.setChild(RFIDbean);
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}

	public void getTicketbyID(RFID_TicketBean RFIDbean, Integer id) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM RFID_Ticket Where ticket_id= ?;";

		Connection con;
		con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			RFIDbean.setTicketID(rs.getInt("ticket_id"));
			RFIDbean.setAcctBal(rs.getBigDecimal("acct_bal"));
			RFIDbean.setCamper(rs.getBoolean("is_Camper"));
			RFIDbean.setVIP(rs.getBoolean("is_VIP"));
			RFIDbean.setPurchaseDate(rs.getDate("purchase_Date"));
			RFIDbean.setValidFrom(rs.getDate("valid_From"));
			RFIDbean.setValidUntil(rs.getDate("valid_Until"));
			RFIDbean.setPrice(rs.getInt("price"));
			PersonBean ownedBy = new PersonBean();
			PersonDAO tempa = new PersonDAO();
			tempa.getPersonbyID(ownedBy, rs.getInt("owned_by"));
			RFIDbean.setOwnedBy(ownedBy);
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}

	/**
	 * inserts the data given in the parameters into the RFID_Ticket table. Uses
	 * the connection con for that, and does not commit. So it is one
	 * transaction together with everything else done with con.
	 */
	public void insertTicket(Connection con, int personID, boolean camper, boolean vip, BigDecimal price,
			Date validFrom, Date validUntil) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = con.prepareStatement(
				"INSERT INTO RFID_TICKET(ticket_id,owned_by, is_Camper, is_VIP, price, valid_From, valid_Until, purchase_Date) VALUES ((SELECT MAX(ticket_id)+1 FROM RFID_ticket),?,?,?,?,?,?,(SELECT CURRENT_DATE))");
		pstmt.setInt(1, personID);
		pstmt.setBoolean(2, camper);
		pstmt.setBoolean(3, vip);
		pstmt.setBigDecimal(4, price);
		pstmt.setDate(5, validFrom);
		pstmt.setDate(6, validUntil);

		// insert the ticket related data
		pstmt.executeUpdate();
		pstmt.close();

		// no commit, since that is done by the calling method

	}

}
