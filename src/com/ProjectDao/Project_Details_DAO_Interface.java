package com.ProjectDao;

import java.util.List;

import com.ProjectDto.Project_Details_Interface;
import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;

public interface Project_Details_DAO_Interface {

	public void createProject( Project_Details_Interface Pd)throws  SomethingWentWrongException ;
	
	public void  view_List_of_Projects() throws NoRecordFoundException,SomethingWentWrongException;
	
}
