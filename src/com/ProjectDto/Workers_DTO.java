package com.ProjectDto;

import java.time.LocalDate;

public class Workers_DTO implements Workers_Interface {
	
	

	
	private String worker_Id;
	private String adhar;
	private String name;
	private LocalDate dob;
	private String gender;
	private String panchayat_Name;
	private String district;
	private String state;
	
	
	
	public Workers_DTO(String worker_Id, String adhar, String name, LocalDate dob, String gender, String panchayat_Name,
			String district, String state) {
		
		this.worker_Id = worker_Id;
		this.adhar = adhar;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.panchayat_Name = panchayat_Name;
		this.district = district;
		this.state = state;
		
	}

    @Override
	public String getWorker_Id() {
		return worker_Id;
	}

    @Override
	public void setWorker_Id(String worker_Id) {
		this.worker_Id = worker_Id;
	}

    @Override
	public  String getAdhar() {
		return adhar;
	}

    @Override
	public void setAdhar(String adhar) {
		this.adhar = adhar;
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


	
	
	
	
	
	
	
	
	
}
