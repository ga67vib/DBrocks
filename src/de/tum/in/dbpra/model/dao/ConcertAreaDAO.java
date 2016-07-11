package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.ConcertAreaBean;
import de.tum.in.dbpra.model.bean.ConcertAreaListBean;

public class ConcertAreaDAO extends DAO {
	public void getConcertAreas(ConcertAreaListBean listObject) throws SQLException, ClassNotFoundException {

		String query = "SELECT * FROM ConcertArea;";

		Connection con = getConnection();

		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = pstmt.executeQuery();

		for (int i = 0; rs.next(); i++) {
			ConcertAreaBean object = new ConcertAreaBean();
			object.setAreaID(rs.getInt("area_id"));
			object.setStyle(rs.getString("style"));
			listObject.setChild(object, i);
			i++;
		}
		con.commit();

		rs.close();
		pstmt.close();
		con.close();

	}

}