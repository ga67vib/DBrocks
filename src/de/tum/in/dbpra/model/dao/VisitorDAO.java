package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.VisitorBean;
import de.tum.in.dbpra.model.bean.VisitorListBean;

public class VisitorDAO extends DAO {

	/**
	 * Gets all visitors and fills the visitorListBean.
	 */
	public void getVisitors(VisitorListBean visitorlist) throws SQLException, ClassNotFoundException {

		String query = "SELECT * FROM Visitor;";

		Connection con;
		con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			VisitorBean visitor = new VisitorBean();
			visitor.setPersonID(rs.getInt("person_id"));
			visitor.setPreferredGenre(rs.getString("preferred_genre"));
			visitorlist.setChild(visitor);
		}

		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}

	/**
	 * inserts the data given in the parameters into the visitor table. Uses the
	 * connection con for that, and does not commit. So it is one transaction
	 * together with everything else done with con.
	 */
	public void insertVisitor(Connection con, int personID, String prefGenre)
			throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO VISITOR(person_id, preferred_genre) VALUES (?,?)");
		pstmt.setInt(1, personID);
		pstmt.setString(2, prefGenre);

		// insert the visitor related data
		pstmt.executeUpdate();
		pstmt.close();

		// no commit, since that is done by the calling method

	}

}
