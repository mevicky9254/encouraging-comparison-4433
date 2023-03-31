package com.ProjectDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ProjectDto.Project_Details_DTO;
import com.ProjectDto.Project_Details_Interface;
import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;
import com.projectCustom.ConsoleColors;

public class Project_Details_DAO implements Project_Details_DAO_Interface{

	@Override
	public void createProject(Project_Details_Interface Pd) throws SomethingWentWrongException {
		
		
		Connection con=null;
		
		try {
			con=DButility.createConnection();
//			insert into project_details( project_Id, project_Name, start_Date,end_Date,no_of_workers,per_day_wages )values("P001","Lining of the feeder canal","2023-01-01","2023-07-07",30,300.0);
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
	
	
	

	@Override
	
	public void  view_List_of_Projects() throws NoRecordFoundException,SomethingWentWrongException{
		
		Connection con=null;
		
		try {
			
			con=DButility.createConnection();
			
			String query="SELECT project_Id, project_Name, no_of_workers, per_day_wages from Project_details";
			
			PreparedStatement ps=con.prepareStatement(query);
			
			
		     ResultSet rs=	ps.executeQuery(query);
		     
		     if(DButility.isResultSetEmpty(rs)) {
		    	throw new NoRecordFoundException("There is no Data");
		     }
		     
		     
		     while(rs.next()) {
	    		 System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getDouble(4));
	    	 }
		     
		       
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new  SomethingWentWrongException("Something went wrong");
		}finally {
			DButility.closeConnection(con);
		}
		
		
		
		
		
	}
	
	
	

}
