package com.ProjectDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DButility {
	
	
	public  static Connection createConnection() throws ClassNotFoundException, SQLException {
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		ResourceBundle rs=ResourceBundle.getBundle("dbDetails");
		
		
		
		return DriverManager.getConnection(rs.getString("url"),rs.getString("user"),rs.getString("password"));
		
		
		
		
	}
	
	
	
	
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
	
	

	
	public static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		
		
		if(!rs.isBeforeFirst() && rs.getRow()==0) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
