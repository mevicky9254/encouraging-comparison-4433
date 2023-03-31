package com.ProjectDto;

import java.time.LocalDate;

public class GMP_Details_DTO implements GMP_Details_Interface  {

	
	
//	 GId            | int         | NO   | PRI | NULL    | auto_increment |
//	 | GMP_Id         | varchar(4)  | NO   | UNI | NULL    |                |
//	 | adhar_Number   | varchar(12) | NO   | UNI | NULL    |                |
//	 | name           | varchar(50) | NO   |     | NULL    |                |
//	 | dob            | date        | YES  |     | NULL    |                |
//	 | gender         | varchar(5)  | YES  |     | NULL    |                |
//	 | panchayat_Name | varchar(50) | NO   | UNI | NULL    |                |
//	 | district       | varchar(50) | YES  |     | NULL    |                |
//	 | state          | varchar(50) | YES  |     | NULL    |                |
//	 | project_Id     | int         | NO   | MUL | NULL    |
//	 
	
	
	private  String GMP_Id;
	private String adahr_Number;
	private  String name;
	private  LocalDate dob;
	private  String gender;
	private  String panchayat_Name;
	private  String district;
	private  String state;
	private int project_id;
	
	
	


	public GMP_Details_DTO(String gMP_Id, String adahr_Number, String name, LocalDate dob, String gender,
			String panchayat_Name, String district, String state ,int project_id) {
		super();
		GMP_Id = gMP_Id;
		this.adahr_Number = adahr_Number;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.panchayat_Name = panchayat_Name;
		this.district = district;
		this.state = state;
		this.project_id=project_id;
		
	}

	
@Override
	public String getGMP_Id() {
		return GMP_Id;
	}

@Override
	public void setGMP_Id(String gMP_Id) {
		GMP_Id = gMP_Id;
	}

@Override
	public String getAdahr_Number() {
		return adahr_Number;
	}

@Override
	public void setAdahr_Number(String adahr_Number) {
		this.adahr_Number = adahr_Number;
	}

@Override
	public String getName() {
		return name;
	}

@Override
	public void setName(String name) {
		this.name = name;
	}

@Override
	public LocalDate getDob() {
		return dob;
	}

@Override
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

@Override
	public String getGender() {
		return gender;
	}

@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

@Override
	public String getPanchayat_Name() {
		return panchayat_Name;
	}

@Override
	public void setPanchayat_Name(String panchayat_Name) {
		this.panchayat_Name = panchayat_Name;
	}

@Override
	public String getDistrict() {
		return district;
	}

@Override
	public void setDistrict(String district) {
		this.district = district;
	}

@Override
	public String getState() {
		return state;
	}

@Override
	public void setState(String state) {
		this.state = state;
	}

@Override
public int getProject_id() {
	return project_id;
}

@Override
public void setProject_id(int project_id) {
	this.project_id = project_id;
}
	
	
	
	
}
