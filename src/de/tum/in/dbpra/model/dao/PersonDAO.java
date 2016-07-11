package de.tum.in.dbpra.model.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.NoteListBean;
import de.tum.in.dbpra.model.bean.PersonBean;
import de.tum.in.dbpra.model.bean.PersonListBean;

public class PersonDAO extends DAO {

	public void getPersons(PersonListBean personsBean) throws SQLException,
			ClassNotFoundException {
		String query = "SELECT * FROM Person;";

		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			PersonBean personBean = new PersonBean();
			personBean.setAddress(rs.getString("Address"));
			personBean.setBirthdate(rs.getDate("Birthdate"));
			personBean.setDoNotify(rs.getBoolean("Do_Notify"));
			personBean.setFirstName(rs.getString("First_Name"));
			personBean.setGender(rs.getString("Gender"));
			personBean.setLastName(rs.getString("Last_Name"));
			personBean.setMail(rs.getString("Mail"));
			personBean.setPersonID(rs.getInt("Person_ID"));
			personBean.setPhonenumber(rs.getString("Phone_number"));
			// personBean.setNotes(new NoteListBean());
			personsBean.setChild(personBean);
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}

	public void getPersonbyID(PersonBean personBean, int PersonID)
			throws SQLException, ClassNotFoundException {

		String query = "SELECT * FROM Person Where person_id=?";

		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, PersonID);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			personBean.setAddress(rs.getString("Address"));
			personBean.setBirthdate(rs.getDate("Birthdate"));
			personBean.setDoNotify(rs.getBoolean("Do_Notify"));
			personBean.setFirstName(rs.getString("First_Name"));
			personBean.setGender(rs.getString("Gender"));
			personBean.setLastName(rs.getString("Last_Name"));
			personBean.setMail(rs.getString("Mail"));
			personBean.setPersonID(rs.getInt("Person_ID"));
			personBean.setPhonenumber(rs.getString("Phone_number"));
			personBean.setNotes(new NoteListBean());
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}
	
	/**
	 * Gets all persons for one note_id and inserts them into a PersonListBean
	 */
	public PersonListBean getPersonsByNoteID(int noteID) throws SQLException, ClassNotFoundException{
		String query = "SELECT * FROM Person p JOIN assigned_to a ON a.person_id=p.person_id Where note_id=?";
		Connection con = getConnection();
		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, noteID);

		ResultSet rs = pstmt.executeQuery();
		PersonListBean result = new PersonListBean();

		while (rs.next()) {
			PersonBean personBean = new PersonBean();
			personBean.setAddress(rs.getString("Address"));
			personBean.setBirthdate(rs.getDate("Birthdate"));
			personBean.setDoNotify(rs.getBoolean("Do_Notify"));
			personBean.setFirstName(rs.getString("First_Name"));
			personBean.setGender(rs.getString("Gender"));
			personBean.setLastName(rs.getString("Last_Name"));
			personBean.setMail(rs.getString("Mail"));
			personBean.setPersonID(rs.getInt("Person_ID"));
			personBean.setPhonenumber(rs.getString("Phone_number"));
			personBean.setPassword(rs.getString("password"));
			result.setChild(personBean);
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();
		
		return result;
	}
	
	/**
	 * Fills a personBean according to a mail address. Since mail is unique,
	 * this works fine. Used for login, to get password and person_id with one
	 * query, and then check everything.
	 * 
	 * @param personBean
	 *            The bean to be filled
	 * @param mail
	 *            The mail address to get the person for
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void getPersonbyMail(PersonBean personBean, String mail)
			throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM Person Where mail=?";
		Connection con = getConnection();
		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1, mail);

		ResultSet rs = pstmt.executeQuery();

		if(rs.next()) {
			personBean.setAddress(rs.getString("Address"));
			personBean.setBirthdate(rs.getDate("Birthdate"));
			personBean.setDoNotify(rs.getBoolean("Do_Notify"));
			personBean.setFirstName(rs.getString("First_Name"));
			personBean.setGender(rs.getString("Gender"));
			personBean.setLastName(rs.getString("Last_Name"));
			personBean.setMail(rs.getString("Mail"));
			personBean.setPersonID(rs.getInt("Person_ID"));
			personBean.setPhonenumber(rs.getString("Phone_number"));
			personBean.setPassword(rs.getString("password"));
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}

	/**
	 * Finds out, whether a certain personID belongs to a visitor. Could also be
	 * located in VisitorDAO. For performance reasons on login, it is located
	 * here.
	 * 
	 * @param personID
	 *            The personID to be checked
	 * @return True iff the personID belongs to a visitor
	 */
	public boolean isVisitor(int personID) throws SQLException,
			ClassNotFoundException {
		String query = "SELECT * FROM Visitor Where person_ID=?";
		Connection con = getConnection();
		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, personID);

		ResultSet rs = pstmt.executeQuery();

		boolean result = getRowCount(rs) == 1; // if exactly one row is
												// returned, then there is one
												// visitor with the personID

		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		return result;
	}

	/**
	 * Finds out, whether a certain personID belongs to a staff member. Could
	 * also be located in StaffDAO. For performance reasons on login, it is
	 * located here.
	 * 
	 * @param personID
	 *            The personID to be checked
	 * @return True iff the personID belongs to a staff member
	 */
	public boolean isStaffMember(int personID) throws SQLException,
			ClassNotFoundException {
		String query = "SELECT * FROM Staff Where person_ID=?";
		Connection con = getConnection();
		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		pstmt.setInt(1, personID);

		ResultSet rs = pstmt.executeQuery();

		boolean result = getRowCount(rs) == 1; // if exactly one row is
												// returned, then there is one
												// staff member with the
												// personID

		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		return result;
	}

	/**
	 * Inserts a new person, then a new visitor, and then a new RFID_ticket with
	 * the data provided as parameters. Returns the personID of the newly
	 * created visitor. Everything as one transaction, so we only atomically
	 * insert one complete visitor with ticket and person entries
	 */
	public int insertVisitor(String firstname, String lastname, String email,
			String password, Date birthday, String gender, String address,
			String phonenumber, boolean camper, boolean vip, String prefGenre,
			Date validFrom, Date validUntil, BigDecimal price)
			throws SQLException, ClassNotFoundException {

		String query = "INSERT INTO person(person_id, first_name, last_name, mail, password, birthdate, gender, address, phone_number, do_notify) VALUES ((SELECT MAX(person_id)+1 FROM person),?,?,?,?,?,?,?,?,?)";
		Connection con = getConnection();
		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, firstname);
		pstmt.setString(2, lastname);
		pstmt.setString(3, email);
		pstmt.setString(4, password);
		pstmt.setDate(5, birthday);
		pstmt.setString(6, gender);
		pstmt.setString(7, address);
		pstmt.setString(8, phonenumber);
		pstmt.setBoolean(9, true);

		// insert the person related data
		pstmt.executeUpdate();
		pstmt.close();

		// get the personID of the inserted person (since mail is unique this
		// works)
		// this double checks everything worked
		// the getPersonByMail method is not used, so everything is still in one
		// transaction (that method would use an own connection and commit on its own)
		PreparedStatement finalStmt = con
				.prepareStatement("SELECT person_id FROM person WHERE mail=?");
		finalStmt.setString(1, email);
		ResultSet rs = finalStmt.executeQuery();
		rs.next();
		int personID = rs.getInt(1);
		rs.close();
		finalStmt.close();

		RFID_TicketDAO rd = new RFID_TicketDAO();
		VisitorDAO vd = new VisitorDAO();

		rd.insertTicket(con, personID, camper, vip, price, validFrom,
				validUntil);
		vd.insertVisitor(con, personID, prefGenre);

		con.commit();
		con.close();

		return personID;
	}

	
}
