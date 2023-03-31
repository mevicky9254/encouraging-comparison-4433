package com.ProjectDto;

import java.time.LocalDate;

public class Workers_DTO {
	
	
//	WId            | int         | NO   | PRI | NULL    | auto_increment |
//	| worker_Id      | varchar(4)  | NO   | UNI | NULL    |                |
//	| adhar_Number   | varchar(12) | NO   | UNI | NULL    |                |
//	| name           | varchar(50) | NO   |     | NULL    |                |
//	| dob            | date        | YES  |     | NULL    |                |
//	| gender         | varchar(5)  | YES  |     | NULL    |                |
//	| panchayat_Name | varchar(50) | NO   | UNI | NULL    |                |
//	| district       | varchar(50) | YES  |     | NULL    |                |
//	| state          | varchar(50) | YES  |     | NULL    |                |
//	| is_occupied    | int         | YES  |     | 0       |                |
//	| is_delete      | int         | YES  |     | 0       |                |
//	| project_Id     | int         | NO   | MUL | NULL    |

	
	private String worker_Id;
	private String adhar;
	private String name;
	private LocalDate dob;
	private String gender;
	private String panchayat_Name;
	private String district;
	private String state;
	private int is_occupied;
	private int is_delete;
	private int project_Id;
	
	
	public Workers_DTO(String worker_Id, String adhar, String name, LocalDate dob, String gender, String panchayat_Name,
			String district, String state, int is_occupied, int is_delete, int project_Id) {
		super();
		this.worker_Id = worker_Id;
		this.adhar = adhar;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.panchayat_Name = panchayat_Name;
		this.district = district;
		this.state = state;
		this.is_occupied = is_occupied;
		this.is_delete = is_delete;
		this.project_Id = project_Id;
	}


	public String getWorker_Id() {
		return worker_Id;
	}


	public void setWorker_Id(String worker_Id) {
		this.worker_Id = worker_Id;
	}


	public String getAdhar() {
		return adhar;
	}


	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPanchayat_Name() {
		return panchayat_Name;
	}


	public void setPanchayat_Name(String panchayat_Name) {
		this.panchayat_Name = panchayat_Name;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getIs_occupied() {
		return is_occupied;
	}


	public void setIs_occupied(int is_occupied) {
		this.is_occupied = is_occupied;
	}


	public int getIs_delete() {
		return is_delete;
	}


	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}


	public int getProject_Id() {
		return project_Id;
	}


	public void setProject_Id(int project_Id) {
		this.project_Id = project_Id;
	}
	
	
	
	
	
	
	
	
}
