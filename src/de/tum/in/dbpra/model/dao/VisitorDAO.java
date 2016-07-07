package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.VisitorBean;
import de.tum.in.dbpra.model.bean.VisitorListBean;

public class VisitorDAO extends DAO 
{
public void getVisitors(VisitorListBean visitorlist){
		
		String query = "SELECT * FROM Visitor;";
		
		Connection con;
		try {
			con = getConnection();
		
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
				{
			VisitorBean visitor = new VisitorBean();
			visitor.setPersonID(rs.getInt("person_id"));
			visitor.setPreferredGenre(rs.getString("preferred_genre"));
			visitorlist.setChild(visitor);
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
		}
		
	}
}
