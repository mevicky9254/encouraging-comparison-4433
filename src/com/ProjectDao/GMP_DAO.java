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
	
	
	// Method to perform GMP login
	@Override
	public void GMP_login(String username, String password) throws SomethingWentWrongException, NoRecordFoundException {
		
		
		// Establishing a connection to the database
		Connection con=null;
		
		
		try {
			con=DButility.createConnection();
			
			// Query to validate the GMP login credentials
			String query ="select id from  gmp_user_credentials where username=? and password=? and is_delete=0";
			
			 PreparedStatement ps=con.prepareStatement(query);
			  ps.setString(1, username);
			  ps.setString(2, password);
			
			
			  ResultSet rs=	ps.executeQuery();
			  
			// Check if the result set is empty, indicating invalid credentials
			     if(DButility.isResultSetEmpty(rs)) {
			    	throw new NoRecordFoundException("Invalid username or password");
			     }
			     
			  // If credentials are valid, set the logged-in GMP ID
			     rs.next();
			     LoggedInGMP.LoggedInGMPId=rs.getInt(1);
		    		
				
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Invalid username or password");
		}finally {
			DButility.closeConnection(con);
		}
	}

	
	
	
	
	// Method to perform GMP logout
	@Override
	public void logout() {
		
		// Set the logged-in GMP ID to 0 to indicate logout
		 LoggedInGMP.LoggedInGMPId=0;
		 
		 System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"THANK YOU GMP, Logeed Out SuccesFullY"+ConsoleColors.RESET);
		
	}





	
	// Method to add workers
	@Override
	public void add_workers(Workers_Interface wi) throws SomethingWentWrongException {
		
		Connection con=null;
		
		try {
			con=DButility.createConnection();
			
			// Query to insert worker details into the database
			String query="insert into worker_details (worker_Id ,adhar_Number,name,dob ,gender ,panchayat_Name,district,state) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
			
			
			PreparedStatement ps=con.prepareStatement(query);
			
			
			// Set the values for the prepared statement
			ps.setString(1,wi.getWorker_Id());
			ps.setString(2, wi.getAdhar());
			ps.setString(3, wi.getName());
			ps.setDate(4, Date.valueOf(wi.getDob()));
			ps.setString(5, wi.getGender());
			ps.setString(6, wi.getPanchayat_Name());
			ps.setString(7, wi.getDistrict());
			ps.setString(8, wi.getState());
			
			
			int m=ps.executeUpdate();
			
			// Check if the worker is successfully added
	        if(m>0) {
	        	System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT+"Worker added Successfully !"+ConsoleColors.RESET);
	        }
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while adding Worker");
		}finally {
			DButility.closeConnection(con);
		}
		
	}





	// Method to view details of all workers
	@Override
	public void view_details_of_workers() throws SomethingWentWrongException, NoRecordFoundException {
		
		
            Connection con=null;
		
		try {
			con=DButility.createConnection();
			
		  // SQL query to select worker details from the database
	      String query="SELECT  worker_Id , name , adhar_Number,  panchayat_Name , district, state from worker_details where is_delete=0";
	      
	      // Prepare the SQL statement
		  PreparedStatement ps=con.prepareStatement(query);
		  
		  // Execute the query and retrieve the result set
		  ResultSet rs=	ps.executeQuery();
		  
		     
		  // Check if the result set is empty
		     if(DButility.isResultSetEmpty(rs)) {
		    	throw new NoRecordFoundException("There is no Data");
		     }
		     
		     
		    // Print table headers
		     System.out.println("---------------------------------------------------------------------------------------");
		     System.out.println(ConsoleColors.DARK_RED+"| WORKER ID | WORKER NAME | ADHAR NUMBER | PANCHAYAT NAME | DISTRICT |         STATE   |"+ConsoleColors.RESET);
		     System.out.println("----------------------------------------------------------------------------------------");

		     
		     // Iterate through the result set and print each row of worker details
		     while (rs.next()) {
		         System.out.format("| %9s | %11s | %12s | %14s | %8s | %14s |\n", rs.getString(1), rs.getString(2), rs.getString(3),
		                           rs.getString(4), rs.getString(5), rs.getString(6));
		     }

		     System.out.println("-----------------------------------------------------------------------------------------");
		     
		     
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while displyaing");
		}finally {
			DButility.closeConnection(con);
		}
		
	}





	// Method to view details of all workers using adhar card

	@Override
	public void view_worker_using_adhar(String adhar) throws SomethingWentWrongException, NoRecordFoundException {
		
            Connection con=null;
		
		try {
			con=DButility.createConnection();
			
		// SQL query to select worker details from the database
	      String query="SELECT  worker_Id , name , adhar_Number,  panchayat_Name , district, state from worker_details where adhar_Number=? and is_delete=0";
	      
	      // Prepare the SQL statement
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setString(1,adhar);
		  
		  // Execute the query and retrieve the result set
		  ResultSet rs=	ps.executeQuery();
		     
		     // Check if the result set is empty
		     if(DButility.isResultSetEmpty(rs)) {
		    	throw new NoRecordFoundException("There is no Data");
		     }
		     
		     
		     System.out.println("---------------------------------------------------------------------------------------------");
		     System.out.println(ConsoleColors.DARK_RED+"| WORKER ID | WORKER NAME          | ADHAR NUMBER | PANCHAYAT NAME     | DISTRICT    | STATE |"+ConsoleColors.RESET);
		     System.out.println("----------------------------------------------------------------------------------------------");

		     
		     // Iterate through the result set and print each row of worker details
		     while (rs.next()) {
		         String id = rs.getString(1);
		         String name = rs.getString(2);
		         String adharn = rs.getString(3);
		         String panchayat = rs.getString(4);
		         String district = rs.getString(5);
		         String state = rs.getString(6);

		         System.out.printf("| %-10s| %-20s| %-13s| %-20s| %-12s| %-6s|\n", id, name, adharn, panchayat, district, state);
		     }

		     System.out.println("---------------------------------------------------------------------------------------------");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while displyaing");
		}finally {
			DButility.closeConnection(con);
		}
		
	}





    // Assigning the projects to the workers
	
	@Override
	public void assign_project(int worker_id,int proj_Id)  throws SomethingWentWrongException {
	
		    // Establishing the connection
		    Connection con=null;
		
		try {
			
			
			con=DButility.createConnection();
			
			// SQL query to assign the projects to the worker
			String query =" insert into worker_projects values(?,?)";
			
			// Prepare the SQL statement
			 PreparedStatement ps=con.prepareStatement(query);
			 
			  ps.setInt(1,worker_id);
			  ps.setInt(2,proj_Id);
			 
			  
			// Check if the project is allocated successfully
			 int m =ps.executeUpdate();
			     if(m>0) {
			    	 
			    	 System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT+" PROJECT ALLOCATION IS SUCCESSFULL !"+ConsoleColors.RESET);
			     }
			     
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while Allocating");
		}finally {
			DButility.closeConnection(con);
		}
		
	}





   // View workers based upon number of days
	@Override
	public void view_name_days(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
		
		// Establishing the connection
		Connection con=null;
		
		try {
			con=DButility.createConnection();
			
			String query ="SELECT wd.name ,DATEDIFF(pd.end_Date, pd.start_Date) from project_Details pd INNER JOIN"
					+ " worker_projects wp on pd.PId=wp.project_id INNER JOIN worker_details wd on wp.worker_Id=wd.WId and wd.is_delete=0;";
			
			// Prepare the SQL statement
			 PreparedStatement ps=con.prepareStatement(query);
			
			 // Execute the query and retrieve the result set
			  ResultSet rs=	ps.executeQuery();
			     
			     // Check if the result set is empty
			     if(DButility.isResultSetEmpty(rs)) {
			    	throw new NoRecordFoundException("There is no Data");
			     }
			     
			     
			     System.out.println("-----------------------------------------");
			     System.out.println(ConsoleColors.DARK_RED+"| WORKER'S NAME          | NO. OF DAYS   |"+ConsoleColors.RESET);
			     System.out.println("------------------------------------------");

			     
			     // Iterate through the result set and print each row of worker name and days
			     while (rs.next()) {
			         String workerName = rs.getString(1);
			         int numOfDays = rs.getInt(2);

			         System.out.printf("| %-23s| %-12d|\n", workerName, numOfDays);
			     }

			     System.out.println("-------------------------------------------");

			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while displyaing");
		}finally {
			DButility.closeConnection(con);
		}
		
	}



	

   // Method to view worker name and his wages
	@Override
	public void view_name_wages(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
		
		    // Establishing the connection
		    Connection con=null;
		    
		try {
			con=DButility.createConnection();
			
			String query ="	SELECT wd.name ,DATEDIFF(pd.end_Date, pd.start_Date)*  per_day_wages "
					+ "from project_Details pd INNER JOIN\r\n"
					+ "worker_projects wp on pd.PId=wp.project_id INNER JOIN worker_details wd on"
					+ " wp.worker_Id=wd.WId and wd.is_delete=0";
			
			
		
			
			// Prepare the SQL statement
			 PreparedStatement ps=con.prepareStatement(query);
			
			  
			  // Execute the query and retrieve the result set
			  ResultSet rs=	ps.executeQuery();
			  
			     
			    // Check if the result set is empty
			     if(DButility.isResultSetEmpty(rs)) {
			    	throw new NoRecordFoundException("There is no Data");
			     }
			     
			     
			     System.out.println("------------------------------------------");
			     System.out.println(ConsoleColors.DARK_RED+"| WORKER'S NAME          | TOTAL WAGES   |"+ConsoleColors.RESET);
			     System.out.println("------------------------------------------");

			     
			     // Iterate through the result set and print each row of worker name and total wages
			     while (rs.next()) {
			         String workerName = rs.getString(1);
			         int totalWages = rs.getInt(2);

			         System.out.printf("| %-23s| %-14d|\n", workerName, totalWages);
			     }

			     System.out.println("------------------------------------------");

							
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while displyaing");
		}finally {
			DButility.closeConnection(con);
		}
		
		
	}





   // Method to delete the worker based on worker Id
	@Override
	public void delete_worker(String worker_id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		// Establishing the connection
		Connection con=null;
		
		
		
		try {
			con=DButility.createConnection();
			
			
			String query="update worker_details set is_delete=1 where worker_id=?";
			
			// Prepare the SQL statement
			 PreparedStatement ps=con.prepareStatement(query);
			 
			 ps.setString(1,worker_id);
			 
			 
			// Check if the worker is deleted successfully
			 int m=ps.executeUpdate();
				
		        if(m>0) {
		        	System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT+"Worker with Worker_Id "+worker_id +" is deleted !"+ConsoleColors.RESET);
		        }
			 
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while deleteing");
		}finally {
			DButility.closeConnection(con);
		}
		
		
		
	}






	
}
