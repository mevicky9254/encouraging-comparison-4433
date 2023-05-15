package com.ProjectDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * The DButility class provides utility methods for managing database connections and operations.
 */
public class DButility {
	
	
	 /**
     * Creates a database connection using the configured details.
     *
     * @return The Connection object representing the database connection.
     * @throws ClassNotFoundException if the database driver class is not found.
     * @throws SQLException           if a database access error occurs.
     */
	public  static Connection createConnection() throws ClassNotFoundException, SQLException {
		
		
		 // Load the MySQL JDBC driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		 // Load database connection details from the "dbDetails" ResourceBundle
		ResourceBundle rs=ResourceBundle.getBundle("dbDetails");
		
		
		 // Create and return the database connection
		return DriverManager.getConnection(rs.getString("url"),rs.getString("user"),rs.getString("password"));
		
		
		
		
	}
	
	
	
	/**
     * Closes the database connection.
     *
     * @param con The Connection object representing the database connection to be closed.
     */
	public static void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

	/**
     * Checks if the ResultSet is empty.
     *
     * @param rs The ResultSet object to be checked.
     * @return true if the ResultSet is empty, false otherwise.
     * @throws SQLException if a database access error occurs.
     */
	public static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		
		
		if(!rs.isBeforeFirst() && rs.getRow()==0) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
