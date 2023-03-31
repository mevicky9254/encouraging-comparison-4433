package com.ProjectDto;

import java.time.LocalDate;

public interface Workers_Interface {

	public String getWorker_Id() ;

	public void setWorker_Id(String worker_Id) ;


	public String getAdhar();


	public void setAdhar(String adhar);


	public String getName() ;


	public void setName(String name) ;


	public LocalDate getDob();


	public void setDob(LocalDate dob);


	public String getGender() ;


	public void setGender(String gender);


	public String getPanchayat_Name();


	public void setPanchayat_Name(String panchayat_Name);


	public String getDistrict();


	public void setDistrict(String district) ;


	public String getState();


	public void setState(String state) ;


	public int getIs_occupied();


	public void setIs_occupied(int is_occupied);


	public int getIs_delete();


	public void setIs_delete(int is_delete);


	public int getProject_Id() ;


	public void setProject_Id(int project_Id);
	
	
	
	
}
