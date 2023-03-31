package com.ProjectDto;

import java.time.LocalDate;

public interface GMP_Details_Interface {
	
	
	public String getGMP_Id() ;
	
	public void setGMP_Id(String gMP_Id) ;

	public String getAdahr_Number() ;
	
	public void setAdahr_Number(String adahr_Number) ;

	public String getName() ;

	public void setName(String name) ;

	public LocalDate getDob() ;

	public void setDob(LocalDate dob) ;

	public String getGender();

	public void setGender(String gender) ;

	public String getPanchayat_Name();

	public void setPanchayat_Name(String panchayat_Name);

	public String getDistrict() ;

	public void setDistrict(String district) ;

	public String getState();

	public void setState(String state);


	public int getProject_id() ;

	
	public void setProject_id(int project_id);
	

}
