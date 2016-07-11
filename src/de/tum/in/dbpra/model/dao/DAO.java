/**
 * 
 */
package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.Config;
import de.tum.in.dbpra.Config.Database;

/**
 * @author 
 * 
 */
public abstract class DAO {
	protected Connection getConnection() throws SQLException, ClassNotFoundException {
			Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
        		"jdbc:postgresql://" 
        + Config.Database.HOST 
        + ":" + Config.Database.PORT
        + "/" + Config.Database.DB, 
        Config.Database.USER,
        Config.Database.PASS);
    }
	
    /**
     * Utility method to get the RowCount for a certain result set.
     * 
     * @param rs
     *            The ResultSet, whose RowCount should be returned, with the
     *            cursor at an arbitrary position
     * @return the number of rows in the ResultSet. As a side effect the cursor
     *         is set to the beforeFirst position. Returns -1 if an error
     *         occurred.
     */
    public static int getRowCount(ResultSet rs) {
        try {
            // move to last position with data
            rs.last();
            // get number of that position (since we start at 1, this is
            // correct)
            int res = rs.getRow();
            // move cursor back to before the first
            rs.beforeFirst();
 
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("getRowCount has an invalid ResultSet (closed or wrong type)");
            return -1;
        }
    }
}
