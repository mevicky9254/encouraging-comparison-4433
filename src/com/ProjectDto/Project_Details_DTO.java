package com.ProjectDto;

import java.time.LocalDate;

public class Project_Details_DTO implements Project_Details_Interface {
	
	
	private String project_Id;
	private String project_Name;
	private LocalDate start_Date;
	private LocalDate end_Date;
	private int no_of_workers;
	private double per_day_wages;
	 
	 
	 
	 
	public Project_Details_DTO(String project_Id, String project_Name, LocalDate start_Date, LocalDate end_Date,
			int no_of_workers, double per_day_wages) {
		
		this.project_Id = project_Id;
		this.project_Name = project_Name;
		this.start_Date = start_Date;
		this.end_Date = end_Date;
		this.no_of_workers = no_of_workers;
		this.per_day_wages = per_day_wages;
	}



@Override
	public String getProject_Id() {
		return project_Id;
	}


@Override

	public void setProject_Id(String project_Id) {
		this.project_Id = project_Id;
	}



@Override
	public String getProject_Name() {
		return project_Name;
	}



@Override
	public void setProject_Name(String project_Name) {
		this.project_Name = project_Name;
	}



@Override
	public LocalDate getStart_Date() {
		return start_Date;
	}



@Override
	public void setStart_Date(LocalDate start_Date) {
		this.start_Date = start_Date;
	}



@Override
	public LocalDate getEnd_Date() {
		return end_Date;
	}



@Override
	public void setEnd_Date(LocalDate end_Date) {
		this.end_Date = end_Date;
	}



@Override
	public int getNo_of_workers() {
		return no_of_workers;
	}



@Override
	public void setNo_of_workers(int no_of_workers) {
		this.no_of_workers = no_of_workers;
	}



@Override
	public double getPer_day_wages() {
		return per_day_wages;
	}



@Override
	public void setPer_day_wages(double per_day_wages) {
		this.per_day_wages = per_day_wages;
	}



@Override
public String toString() {
	return "Project_Details_DTO [project_Id=" + project_Id + ", project_Name=" + project_Name + ", start_Date="
			+ start_Date + ", end_Date=" + end_Date + ", no_of_workers=" + no_of_workers + ", per_day_wages="
			+ per_day_wages + "]";
}
	 
	 
	 
	
	
	 

}
