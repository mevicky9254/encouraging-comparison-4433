package com.ProjectDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;

public class GMP_DAO implements GMP_DAO_Interface {

	@Override
	public void GMP_login(String username, String password) throws SomethingWentWrongException, NoRecordFoundException {
		
		Connection con=null;
		
		
		
		try {
			con=DButility.createConnection();
			
			String query ="select id from  gmp_user_credentials where username=? and password=? and is_delete=0";
			
			 PreparedStatement ps=con.prepareStatement(query);
			  ps.setString(1, username);
			  ps.setString(2, password);
			
			
			  ResultSet rs=	ps.executeQuery();
			     
			     if(DButility.isResultSetEmpty(rs)) {
			    	throw new NoRecordFoundException("Invalid username or password");
			     }
			     
			     rs.next();
			     LoggedInGMP.LoggedInGMPId=rs.getInt(1);
		    		
				
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Invalid username or password");
		}finally {
			DButility.closeConnection(con);
		}
	}

	@Override
	public void logout() {
		 LoggedInGMP.LoggedInGMPId=0;
		
	}

}
