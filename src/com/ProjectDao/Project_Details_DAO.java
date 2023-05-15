package com.ProjectDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ProjectDto.GMP_Details_Interface;
import com.ProjectDto.Project_Details_DTO;
import com.ProjectDto.Project_Details_Interface;
import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;
import com.projectCustom.ConsoleColors;




public class Project_Details_DAO implements Project_Details_DAO_Interface{
	
	
	
    // Method to create projects
	@Override
	public void createProject(Project_Details_Interface Pd) throws SomethingWentWrongException {
		
		
		    Connection con=null;
		
		try {
			con=DButility.createConnection();

			
			// Query to insert project details into the database
			String query="Insert into project_details (project_Id, project_Name, start_Date, end_Date, no_of_workers, per_day_wages)"
					+ "values(?, ?, ?, ?, ?, ?)";
			
		PreparedStatement ps=con.prepareStatement(query);
		
		
       //	Data Stuffing ---------	
		ps.setString(1, Pd.getProject_Id());
		ps.setString(2, Pd.getProject_Name());
		ps.setDate(3, Date.valueOf(Pd.getStart_Date()));
		ps.setDate(4, Date.valueOf(Pd.getEnd_Date()));
		ps.setInt(5, Pd.getNo_of_workers());
		ps.setDouble(6, Pd.getPer_day_wages());
		
		
		// Check if the project is successfully added
		int m=ps.executeUpdate();
		
        if(m>0) {
        	System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT+" Project Added to Project List");
        }
		
		
			
		} catch (ClassNotFoundException | SQLException e) {
			
			throw new SomethingWentWrongException("Failed to Add the Project");
			
		}finally {
			DButility.closeConnection(con);
		}
		
	}
	
	
	
	
	
	
	// Method to view list of projects

	@Override
	public void  view_List_of_Projects() throws NoRecordFoundException,SomethingWentWrongException{
		
		     // Establishing Connection
		     Connection con=null;
		
		try {
			
			con=DButility.createConnection();
			
			 // SQL query to select project details from the database
			String query="SELECT project_Id, project_Name, no_of_workers, per_day_wages from Project_details";
			
			// Prepare the SQL statement
			PreparedStatement ps=con.prepareStatement(query);
			
			// Execute the query and retrieve the result set
		     ResultSet rs=	ps.executeQuery();
		     
		    // Check if the result set is empty, indicating invalid credentials
		     if(DButility.isResultSetEmpty(rs)) {
		    	throw new NoRecordFoundException("There is no Data");
		     }
		     
		     
		     
		     System.out.println("------------------------------------------------------------------------");
		     System.out.println(ConsoleColors.DARK_RED+"| PROJECT ID | PROJECT NAME                 | NO. OF WORKERS | PER DAY WAGES |"+ConsoleColors.RESET);
		     System.out.println("-------------------------------------------------------------------------");

		     // Iterate through the result set
		     while (rs.next()) {
		         String projectId = rs.getString(1);
		         String projectName = rs.getString(2);
		         int numWorkers = rs.getInt(3);
		         double perDayWages = rs.getDouble(4);

		         System.out.printf("| %-10s| %-30s| %-15d| %-14.2f|\n", projectId, projectName, numWorkers, perDayWages);
		     }

		     System.out.println("--------------------------------------------------------------------------");

		     
        
			
		} catch (ClassNotFoundException | SQLException e) {
			
			throw new  SomethingWentWrongException("Something went wrong");
		}finally {
			DButility.closeConnection(con);
		}
		
		
		
	}


	
	

   // Method to add Gram Panchayat Members
	@Override
	public void add_GMPS(GMP_Details_Interface GD) throws SomethingWentWrongException {

		Connection con=null;
		

		try {
			con=DButility.createConnection();
			
			 // SQL query to insert GMPs into the database
			String query="Insert into gmps_details (GMP_Id, adhar_Number, name , dob , gender, panchayat_Name, district ,state )"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
			
			
			// Prepare the SQL statement
			PreparedStatement ps=con.prepareStatement(query);
			
			
			// Set the values for the prepared statement
			ps.setString(1, GD.getGMP_Id());
			ps.setString(2, GD.getAdahr_Number());
			ps.setString(3, GD.getName());
			ps.setDate(4, Date.valueOf(GD.getDob()));
			ps.setString(5, GD.getGender());
			ps.setString(6, GD.getPanchayat_Name());
			ps.setString(7, GD.getDistrict());
			ps.setString(8, GD.getState());
			
			
			// Check if the GMP is successfully added
			int m=ps.executeUpdate();
			
	        if(m>0) {
	        	System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT+" Gram Panchayat Member added Successfully !"+ConsoleColors.RESET);
	        }
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			throw new SomethingWentWrongException("Failed to Add the Grram Panchayat Members");
			
		}finally {
			DButility.closeConnection(con);
		}
		
		
		
		
	}





    // Method to view list of Gram Panchayat Members
	@Override
	public void view_List_of_GMP_Members() throws NoRecordFoundException, SomethingWentWrongException {
		
		Connection con=null;
		
		try {
			con=DButility.createConnection();
			
		// SQL query to select GMP details from the database
	      String query="SELECT  GMP_Id , name , adhar_Number,  panchayat_Name from gmps_details";
	      
	   // Prepare the SQL statement
		  PreparedStatement ps=con.prepareStatement(query);
		  
		// Execute the query and retrieve the result set
		  ResultSet rs=	ps.executeQuery();
		     
		  // Check if the result set is empty, indicating invalid credentials
		     if(DButility.isResultSetEmpty(rs)) {
		    	throw new NoRecordFoundException("There is no Data");
		     }
		     
		     
		     System.out.println("-----------------------------------------------------------------");
		     System.out.println(ConsoleColors.DARK_RED+"| GMP ID    | GMP NAME         | ADHAR NUMBER | PANCHAYAT          |"+ConsoleColors.RESET);
		     System.out.println("------------------------------------------------------------------");

		  // Iterate through the result set
		     while (rs.next()) {
		         String gmpId = rs.getString(1);
		         String gmpName = rs.getString(2);
		         String adharNumber = rs.getString(3);
		         String panchayatName = rs.getString(4);

		         System.out.printf("| %-9s| %-18s| %-12s| %-20s|\n", gmpId, gmpName, adharNumber, panchayatName);
		     }

		     System.out.println("---------------------------------------------------------------------");

		     			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while displyaing");
		}finally {
			DButility.closeConnection(con);
		}
		
	}

	
	
	

   //Method to allocate projects to the Gram Panchayat Members
	@Override
	public void allocate_project_to_GMPS(int gmp_id,int proj_Id) throws SomethingWentWrongException, NoRecordFoundException {
		
		
		Connection con=null;
		
		try {
			con=DButility.createConnection();
			
		
			// SQL query to allocate projects to GMPs
			String query =" insert into gram_project values(?,?)";
			
			 // Prepare the SQL statement
			 PreparedStatement ps=con.prepareStatement(query);
			 
			  ps.setInt(1,gmp_id);
			  ps.setInt(2,proj_Id);
			 
			  
			// Check if the project is successfully allocated to GMPs
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
	
	
	
	
	
	
	// Method to see Gram Panchayat Member's name and allocated projects
	@Override
	public void show_GMPS_with_Allocated_Projects() throws SomethingWentWrongException, NoRecordFoundException {
		
		Connection con=null;
		try {
			con=DButility.createConnection();
			
			// SQL query to see GMPs name and allocated projects
			String query ="SELECT g.name, g.adhar_Number, p.project_Name \r\n"
					+ "FROM project_Details p\r\n"
					+ "INNER JOIN gram_project gp on p.PId=gp.project_id \r\n"
					+ "INNER JOIN gmps_details g on gp.gmp_id=g.GId";
			
			 // Prepare the SQL statement
			 PreparedStatement ps=con.prepareStatement(query);
			
			// Execute the query and retrieve the result set
			  ResultSet rs=	ps.executeQuery();
			     
			// Check if the result set is empty, indicating invalid credentials
			     if(DButility.isResultSetEmpty(rs)) {
			    	throw new NoRecordFoundException("There is no Data");
			     }
			     
			     System.out.println("------------------------------------------------------------------------------");
			     System.out.println(ConsoleColors.DARK_RED+"| GMP NAME            | GMP ADHAR NUMBER | PROJECT NAME                   |"+ConsoleColors.RESET);
			     System.out.println("------------------------------------------------------------------------------ ");

			  // Iterate through the result set
			     while (rs.next()) {
			         String gmpName = rs.getString(1);
			         String gmpAdharNumber = rs.getString(2);
			         String projectName = rs.getString(3);

			         System.out.printf("| %-20s| %-18s| %-30s|\n", gmpName, gmpAdharNumber, projectName);
			     }

			     System.out.println("---------------------------------------------------------------------------------");

				
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while displyaing");
		}finally {
			DButility.closeConnection(con);
		}
	}
	
	
	
	


   // Method to see the details of workers
	@Override
	public void see_details_of_workers() throws NoRecordFoundException, SomethingWentWrongException {
		
		Connection con=null;
		
		try {
			con=DButility.createConnection();
			
			// SQL query to select workers details from the database
			String query=" Select  worker_Id, adhar_Number, name, dob, gender,  panchayat_Name, district, state from worker_details ";
			
			
			 // Prepare the SQL statement
			  PreparedStatement ps=con.prepareStatement(query);
			
			// Execute the query and retrieve the result set
			  ResultSet rs=	ps.executeQuery();
			     
			// Check if the result set is empty, indicating invalid credentials
			     if(DButility.isResultSetEmpty(rs)) {
			    	throw new NoRecordFoundException("There is no Data");
			     }
			     
			     
			     
			     System.out.println("--------------------------------------------------------------------------------------------------------------------------");
			     System.out.println(ConsoleColors.DARK_RED+"| WORKER ID | ADHAR NUMBER    | NAME           | DATE OF BIRTH | GENDER | PANCHAYAT NAME | DISTRICT    |  STATE       |"+ConsoleColors.RESET);
			     System.out.println("---------------------------------------------------------------------------------------------------------------------------");

			     
			  // Iterate through the result set
			     while (rs.next()) {
			         String workerId = rs.getString(1);
			         String adharNumber = rs.getString(2);
			         String name = rs.getString(3);
			         Date dob = rs.getDate(4);
			         String gender = rs.getString(5);
			         String panchayatName = rs.getString(6);
			         String district = rs.getString(7);
			         String state = rs.getString(8);

			         System.out.printf("| %-10s| %-16s| %-15s| %-14s| %-7s| %-15s| %-13s| %-13s|\n", 
			                             workerId, adharNumber, name, dob, gender, panchayatName, district, state);
			     }

			     System.out.println("---------------------------------------------------------------------------------------------------------------------------");
     
			     
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while displyaing");
		}finally {
			DButility.closeConnection(con);
		}
		
		
	}




	

}
