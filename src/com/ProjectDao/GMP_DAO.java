package com.ProjectDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ProjectDto.Workers_Interface;
import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;
import com.projectCustom.ConsoleColors;

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






	@Override
	public void add_workers(Workers_Interface wi) throws SomethingWentWrongException {
		
		Connection con=null;
		
		try {
			con=DButility.createConnection();
			
			String query="insert into worker_details (worker_Id ,adhar_Number,name,dob ,gender ,panchayat_Name,district,state) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
			
			
			PreparedStatement ps=con.prepareStatement(query);
			
			
			
			ps.setString(1,wi.getWorker_Id());
			ps.setString(2, wi.getAdhar());
			ps.setString(3, wi.getName());
			ps.setDate(4, Date.valueOf(wi.getDob()));
			ps.setString(5, wi.getGender());
			ps.setString(6, wi.getPanchayat_Name());
			ps.setString(7, wi.getDistrict());
			ps.setString(8, wi.getState());
			
			
			
			
			
			int m=ps.executeUpdate();
			
	        if(m>0) {
	        	System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT+"Worker added Successfully !"+ConsoleColors.RESET);
	        }
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while adding Worker");
		}finally {
			DButility.closeConnection(con);
		}
		
	}






	@Override
	public void view_details_of_workers() throws SomethingWentWrongException, NoRecordFoundException {
		
		
Connection con=null;
		
		try {
			con=DButility.createConnection();
			
			
	      String query="SELECT  worker_Id , name , adhar_Number,  panchayat_Name , district, state from worker_details";
	      
		  PreparedStatement ps=con.prepareStatement(query);
		  
		  
		  ResultSet rs=	ps.executeQuery();
		     
		     if(DButility.isResultSetEmpty(rs)) {
		    	throw new NoRecordFoundException("There is no Data");
		     }
		     
		     
		     while(rs.next()) {
	    		 System.out.println("GMP ID : "+rs.getString(1)+" GMP NAME : "+rs.getString(2)+"  Adhar Number : "+rs.getString(3)
	    		 + " Panchayat Name : "+rs.getString(4) + " DISTRICT : "+rs.getString(5) + " STATE : "+rs.getString(6));
	    	 }
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while displyaing");
		}finally {
			DButility.closeConnection(con);
		}
		
	}






	@Override
	public void view_worker_using_adhar(String adhar) throws SomethingWentWrongException, NoRecordFoundException {
		
Connection con=null;
		
		try {
			con=DButility.createConnection();
			
			
	      String query="SELECT  worker_Id , name , adhar_Number,  panchayat_Name , district, state from worker_details";
	      
		  PreparedStatement ps=con.prepareStatement(query);
		  
		  
		  ResultSet rs=	ps.executeQuery();
		     
		     if(DButility.isResultSetEmpty(rs)) {
		    	throw new NoRecordFoundException("There is no Data");
		     }
		     
		     
		     while(rs.next()) {
	    		 System.out.println("GMP ID : "+rs.getString(1)+" GMP NAME : "+rs.getString(2)+"  Adhar Number : "+rs.getString(3)
	    		 + " Panchayat Name : "+rs.getString(4) + " DISTRICT : "+rs.getString(5) + " STATE : "+rs.getString(6));
	    	 }
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while displyaing");
		}finally {
			DButility.closeConnection(con);
		}
		
	}






	@Override
	public void assign_project(int worker_id,int proj_Id)  throws SomethingWentWrongException {
	
		Connection con=null;
		try {
			con=DButility.createConnection();
			
			String query =" insert into gram_project values(?,?)";
			
			 PreparedStatement ps=con.prepareStatement(query);
			 
			  ps.setInt(1,worker_id);
			  ps.setInt(2,proj_Id);
			 
			  
			 int m =ps.executeUpdate();
			     if(m>0) {
			    	 
			    	 System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT+" PROJECT ALLOCATION IS SUCCESSFULL !"+ConsoleColors.RESET);
			     }
			     
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while displyaing");
		}finally {
			DButility.closeConnection(con);
		}
		
	}






	@Override
	public void view_name_days(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
		Connection con=null;
		try {
			con=DButility.createConnection();
			
			String query ="SELECT w.name as WORKER'S NAME, DATEDIFF(p.end_Date, p.start_Date) AS NO_OF_DAYS \r\n"
					+ "FROM project_Details p\r\n"
					+ "INNER JOIN worker_projects wp on p.PId=w.project_id \r\n"
					+ "INNER JOIN worker_details w on wp.worker_Id=w.WId";
			
			 PreparedStatement ps=con.prepareStatement(query);
			
			  
			  ResultSet rs=	ps.executeQuery();
			     
			     if(DButility.isResultSetEmpty(rs)) {
			    	throw new NoRecordFoundException("There is no Data");
			     }
			     
			     while(rs.next()) {
		    		 System.out.println("WORKER'S NAME : "+rs.getString(1)+" NO. OF DAYS : "+rs.getInt(2));
		    	 }
				
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while displyaing");
		}finally {
			DButility.closeConnection(con);
		}
		
	}






	@Override
	public void view_name_wages(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		
		Connection con=null;
		try {
			con=DButility.createConnection();
			
			String query ="SELECT w.name , DATEDIFF(p.end_date, p.start_date) * p.daily_wages \r\n"
					+ "FROM project_details p\r\n"
					+ "INNER JOIN worker_projects wp ON p.PId = wp.project_id\r\n"
					+ "INNER JOIN worker_details w ON wp.worker_Id = w.WId;\r\n"
					+ "";
			
			 PreparedStatement ps=con.prepareStatement(query);
			
			  
			  ResultSet rs=	ps.executeQuery();
			     
			     if(DButility.isResultSetEmpty(rs)) {
			    	throw new NoRecordFoundException("There is no Data");
			     }
			     
			     while(rs.next()) {
		    		 System.out.println("WORKER'S NAME : "+rs.getString(1)+" TOTAL_WAGES : "+rs.getInt(2));
		    	 }
				
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while displyaing");
		}finally {
			DButility.closeConnection(con);
		}
		
		
	}






	@Override
	public void delete_worker(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
	}






	
}
