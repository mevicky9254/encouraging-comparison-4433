package com.ProjectDto;

import java.time.LocalDate;

public interface Project_Details_Interface {

	
	
	public String getProject_Id() ;

	public void setProject_Id(String project_Id);

	public String getProject_Name();

	public void setProject_Name(String project_Name) ;

	public LocalDate getStart_Date() ;

	public void setStart_Date(LocalDate start_Date) ;

	public LocalDate getEnd_Date() ;

	public void setEnd_Date(LocalDate end_Date);

	public int getNo_of_workers() ;

	public void setNo_of_workers(int no_of_workers) ;

	public double getPer_day_wages() ;

	public void setPer_day_wages(double per_day_wages) ;
	 
	
	
}
