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
		 System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"THANK YOU GMP, Logeed Out SuccesFullY"+ConsoleColors.RESET);
		
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
			
			
	      String query="SELECT  worker_Id , name , adhar_Number,  panchayat_Name , district, state from worker_details where is_delete=0";
	      
		  PreparedStatement ps=con.prepareStatement(query);
		  
		  
		  ResultSet rs=	ps.executeQuery();
		     
		     if(DButility.isResultSetEmpty(rs)) {
		    	throw new NoRecordFoundException("There is no Data");
		     }
		     
		     
		     
		     System.out.println("---------------------------------------------------------------------------------------");
		     System.out.println(ConsoleColors.DARK_RED+"| WORKER ID | WORKER NAME | ADHAR NUMBER | PANCHAYAT NAME | DISTRICT |         STATE   |"+ConsoleColors.RESET);
		     System.out.println("----------------------------------------------------------------------------------------");

		     while (rs.next()) {
		         System.out.format("| %9s | %11s | %12s | %14s | %8s | %14s |\n", rs.getString(1), rs.getString(2), rs.getString(3),
		                           rs.getString(4), rs.getString(5), rs.getString(6));
		     }

		     System.out.println("-----------------------------------------------------------------------------------------");
		     
		     
		     
		     
		     
//		     while(rs.next()) {
//	    		 System.out.println("WORKER ID : "+rs.getString(1)+" WORKER NAME : "+rs.getString(2)+"  Adhar Number : "+rs.getString(3)
//	    		 + " Panchayat Name : "+rs.getString(4) + " DISTRICT : "+rs.getString(5) + " STATE : "+rs.getString(6));
//	    	 }
			
			
			
			
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
			
			
	      String query="SELECT  worker_Id , name , adhar_Number,  panchayat_Name , district, state from worker_details where adhar_Number=? and is_delete=0";
	      
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setString(1,adhar);
		  
		  ResultSet rs=	ps.executeQuery();
		     
		     if(DButility.isResultSetEmpty(rs)) {
		    	throw new NoRecordFoundException("There is no Data");
		     }
		     
		     
		     System.out.println("---------------------------------------------------------------------------------------------");
		     System.out.println(ConsoleColors.DARK_RED+"| WORKER ID | WORKER NAME          | ADHAR NUMBER | PANCHAYAT NAME     | DISTRICT    | STATE |"+ConsoleColors.RESET);
		     System.out.println("----------------------------------------------------------------------------------------------");

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

		     
		     
		     
//		     while(rs.next()) {
//	    		 System.out.println("WORKER ID : "+rs.getString(1)+" WORKER NAME : "+rs.getString(2)+"  Adhar Number : "+rs.getString(3)
//	    		 + " Panchayat Name : "+rs.getString(4) + " DISTRICT : "+rs.getString(5) + " STATE : "+rs.getString(6));
//	    	 }
			
			
			
			
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
			
			String query =" insert into worker_projects values(?,?)";
			
			 PreparedStatement ps=con.prepareStatement(query);
			 
			  ps.setInt(1,worker_id);
			  ps.setInt(2,proj_Id);
			 
			  
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






	@Override
	public void view_name_days(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
		Connection con=null;
		try {
			con=DButility.createConnection();
			
			String query ="SELECT wd.name ,DATEDIFF(pd.end_Date, pd.start_Date) from project_Details pd INNER JOIN"
					+ " worker_projects wp on pd.PId=wp.project_id INNER JOIN worker_details wd on wp.worker_Id=wd.WId and wd.is_delete=0;";
			
			 PreparedStatement ps=con.prepareStatement(query);
			
			  
			  ResultSet rs=	ps.executeQuery();
			     
			     if(DButility.isResultSetEmpty(rs)) {
			    	throw new NoRecordFoundException("There is no Data");
			     }
			     
			     
			     System.out.println("-----------------------------------------");
			     System.out.println(ConsoleColors.DARK_RED+"| WORKER'S NAME          | NO. OF DAYS   |"+ConsoleColors.RESET);
			     System.out.println("------------------------------------------");

			     while (rs.next()) {
			         String workerName = rs.getString(1);
			         int numOfDays = rs.getInt(2);

			         System.out.printf("| %-23s| %-12d|\n", workerName, numOfDays);
			     }

			     System.out.println("-------------------------------------------");

			     
//			     while(rs.next()) {
//		    		 System.out.println("WORKER'S NAME : "+rs.getString(1)+" NO. OF DAYS : "+rs.getInt(2));
//		    	 }
				
			
			
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
			
			String query ="	SELECT wd.name ,DATEDIFF(pd.end_Date, pd.start_Date)*  per_day_wages "
					+ "from project_Details pd INNER JOIN\r\n"
					+ "worker_projects wp on pd.PId=wp.project_id INNER JOIN worker_details wd on"
					+ " wp.worker_Id=wd.WId and wd.is_delete=0";
			
			
		
			
			
			 PreparedStatement ps=con.prepareStatement(query);
			
			  
			  ResultSet rs=	ps.executeQuery();
			     
			     if(DButility.isResultSetEmpty(rs)) {
			    	throw new NoRecordFoundException("There is no Data");
			     }
			     
			     
			     System.out.println("------------------------------------------");
			     System.out.println(ConsoleColors.DARK_RED+"| WORKER'S NAME          | TOTAL WAGES   |"+ConsoleColors.RESET);
			     System.out.println("------------------------------------------");

			     while (rs.next()) {
			         String workerName = rs.getString(1);
			         int totalWages = rs.getInt(2);

			         System.out.printf("| %-23s| %-14d|\n", workerName, totalWages);
			     }

			     System.out.println("------------------------------------------");

			     
//			     while(rs.next()) {
//		    		 System.out.println("WORKER'S NAME : "+rs.getString(1)+" TOTAL_WAGES : "+rs.getInt(2));
//		    	 }
				
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong while displyaing");
		}finally {
			DButility.closeConnection(con);
		}
		
		
	}






	@Override
	public void delete_worker(String worker_id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Connection con=null;
		
		
		
		try {
			con=DButility.createConnection();
			
			String query="update worker_details set is_delete=1 where worker_id=?";
			
			 PreparedStatement ps=con.prepareStatement(query);
			 
			 ps.setString(1,worker_id);
			 
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
