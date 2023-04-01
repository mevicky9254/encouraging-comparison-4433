package com.ProjectDao;

import java.util.List;
import java.util.Scanner;

import com.ProjectDto.GMP_Details_Interface;
import com.ProjectDto.Project_Details_Interface;
import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;

public interface Project_Details_DAO_Interface {

	public void createProject( Project_Details_Interface Pd)throws  SomethingWentWrongException ;
	
	public void  view_List_of_Projects() throws NoRecordFoundException,SomethingWentWrongException;
	
	public  void add_GMPS(GMP_Details_Interface GD)throws  SomethingWentWrongException;
	
	public void  view_List_of_GMP_Members() throws NoRecordFoundException,SomethingWentWrongException;
	
	public void allocate_project_to_GMPS(int GMP_id,int project_Id)throws  SomethingWentWrongException, NoRecordFoundException;
	
	public void show_GMPS_with_Allocated_Projects() throws SomethingWentWrongException, NoRecordFoundException;
	
	public void see_details_of_workers()throws NoRecordFoundException,SomethingWentWrongException;
		
	
}
