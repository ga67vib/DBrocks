package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.PersonBean;
import de.tum.in.dbpra.model.bean.RFID_TicketBean;
import de.tum.in.dbpra.model.bean.RFID_TicketListBean;
import de.tum.in.dbpra.model.dao.AreaDAO.AreaNotFoundException;

public class RFID_TicketDAO extends DAO
{
	
public void getTickets(RFID_TicketListBean listObject)
{
		
		String query = "SELECT * FROM RFID_Ticket;";
		try {
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next())
		{
			RFID_TicketBean RFIDbean = new RFID_TicketBean();
			RFIDbean.setTicketID(rs.getInt("ticket_id"));
			RFIDbean.setAcctBal(rs.getInt("acct_bal"));
			RFIDbean.setCamper(rs.getBoolean("is_Camper"));
			RFIDbean.setVIP(rs.getBoolean("is_VIP"));
			RFIDbean.setPurchaseDate(rs.getDate("purchaseDate"));
			RFIDbean.setValidFrom(rs.getDate("valid_From"));
			RFIDbean.setValidUntil(rs.getDate("valid_Until"));
			RFIDbean.setPrice(rs.getInt("price"));
			PersonBean ownedBy = new PersonBean();
			PersonDAO tempa = new PersonDAO();
			tempa.getPersonbyID(ownedBy, rs.getInt("owned_by"));
			RFIDbean.setOwnedBy(ownedBy);
			listObject.setChild(RFIDbean);
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
		}
		
	}

public void getTicketbyID(RFID_TicketBean RFIDbean, Integer id)
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
		RFIDbean.setTicketID(rs.getInt("ticket_id"));
		RFIDbean.setAcctBal(rs.getInt("acct_bal"));
		RFIDbean.setCamper(rs.getBoolean("is_Camper"));
		RFIDbean.setVIP(rs.getBoolean("is_VIP"));
		RFIDbean.setPurchaseDate(rs.getDate("purchaseDate"));
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
