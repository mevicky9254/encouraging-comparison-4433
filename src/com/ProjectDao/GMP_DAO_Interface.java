package com.ProjectDao;

import java.util.Scanner;

import com.ProjectDto.Workers_Interface;
import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;

public interface GMP_DAO_Interface {
	
	public void GMP_login(String username,String Password)throws SomethingWentWrongException,NoRecordFoundException;
	
	public void logout();
	
    public  void add_workers(Workers_Interface wi) throws SomethingWentWrongException;
	
    public  void view_details_of_workers()throws SomethingWentWrongException,NoRecordFoundException;
  
    public void view_worker_using_adhar(String adhar) throws SomethingWentWrongException,NoRecordFoundException;

    public void assign_project(int worker_id, int proj_Id)  throws SomethingWentWrongException;

    public  void view_name_days(Scanner sc) throws SomethingWentWrongException,NoRecordFoundException;
 
    public  void view_name_wages(Scanner sc)throws SomethingWentWrongException,NoRecordFoundException;

    public void delete_worker(String worker_id) throws SomethingWentWrongException,NoRecordFoundException;

	

	

    

}
