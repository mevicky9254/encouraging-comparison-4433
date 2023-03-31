package com.ProjectUI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.ProjectDao.Project_Details_DAO;
import com.ProjectDao.Project_Details_DAO_Interface;
import com.ProjectDto.GMP_Details_DTO;
import com.ProjectDto.GMP_Details_Interface;
import com.ProjectDto.Project_Details_DTO;
import com.ProjectDto.Project_Details_Interface;
import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;
import com.projectCustom.ConsoleColors;

public class BDO_Functionalites_UI {

	
	public static void createProject(Scanner sc) {
		
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Project ID"+ConsoleColors.RESET);
		String project_Id=sc.next();
        sc.nextLine();
		
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the Project Name"+ConsoleColors.RESET);
		 String project_Name=sc.nextLine();
		
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter Start Date as YYYY-MM-DD"+ConsoleColors.RESET);
		LocalDate start_Date=LocalDate.parse(sc.next());
	
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter End Date as YYYY-MM-DD"+ConsoleColors.RESET);
		LocalDate End_Date=LocalDate.parse(sc.next());
		
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the Number Of Workers"+ConsoleColors.RESET);
		int no_of_workers=sc.nextInt();
		
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter Daily Wages for the Project"+ConsoleColors.RESET);
		double per_day_wages=sc.nextDouble();
		
		 System.out.println(project_Name);
		 System.out.println(start_Date);
		
		Project_Details_Interface PD=new Project_Details_DTO (project_Id,project_Name,start_Date,End_Date,no_of_workers,per_day_wages);
		
	Project_Details_DAO_Interface pdd=new Project_Details_DAO();
		
		try {
	       pdd.createProject(PD);
		} catch (SomethingWentWrongException ex) {
			System.out.println(ConsoleColors.RED_BOLD_BRIGHT+ ex+ ConsoleColors.RESET);
	}
		
	}
	
	
	
	
     public static void view_List_of_Projects() {
    	 
    	 Project_Details_DAO_Interface pdd=new Project_Details_DAO();
    	 try {
    		 
		 	pdd.view_List_of_Projects();
		 
		} catch (NoRecordFoundException | SomethingWentWrongException ex) {
			
			System.out.println(ConsoleColors.RED_BOLD_BRIGHT+ ex+ ConsoleColors.RESET);
			
		}
    	 
    	
	}
     
     
     
     
     
     public static void add_GMPS(Scanner sc) {
    	 
    	 
//    	 GId            | int         | NO   | PRI | NULL    | auto_increment |
//    	 | GMP_Id         | varchar(4)  | NO   | UNI | NULL    |                |
//    	 | adhar_Number   | varchar(12) | NO   | UNI | NULL    |                |
//    	 | name           | varchar(50) | NO   |     | NULL    |                |
//    	 | dob            | date        | YES  |     | NULL    |                |
//    	 | gender         | varchar(5)  | YES  |     | NULL    |                |
//    	 | panchayat_Name | varchar(50) | NO   | UNI | NULL    |                |
//    	 | district       | varchar(50) | YES  |     | NULL    |                |
//    	 | state          | varchar(50) | YES  |     | NULL    |                |
//    	 | project_Id     | int         | NO   | MUL | NULL    |
//    	 
    	 
    	 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Gram Panchayat Member's ID"+ConsoleColors.RESET);
 		 String GMP_Id=sc.next(); 
    	 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the Adhar card Number "+ConsoleColors.RESET);
 		 long adhar=sc.nextLong(); 
 		 String adharCard=""+adhar;
 		  sc.nextLine();
 		 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Gram Panchayat Member's Name"+ConsoleColors.RESET);
 		 String name=sc.nextLine();
 		 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Gram Panchayat Member's Date of Birth"+ConsoleColors.RESET);
 		 LocalDate dob=LocalDate.parse(sc.next());
 		 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Gram Panchayat Member's Gender"+ConsoleColors.RESET);
 		 String gender=sc.next(); 
    	 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Panchayat name"+ConsoleColors.RESET);
 		 String panchayat_Name=sc.next(); 
 		 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  District name"+ConsoleColors.RESET);
 		 String district =sc.next(); 
 		 
 		 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  State name"+ConsoleColors.RESET);
 		 String state =sc.next(); 
 		 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  project id"+ConsoleColors.RESET);
 		 int project_id =sc.nextInt(); 
 		
 		 
 		 GMP_Details_Interface gd=new GMP_Details_DTO(GMP_Id, adharCard,name ,dob,gender,panchayat_Name,district,state,project_id);
 		 
 		 Project_Details_DAO_Interface pdd=new Project_Details_DAO();
 		 
 		 try {
			pdd.add_GMPS(gd);
		} catch (SomethingWentWrongException ex) {
			System.out.println(ConsoleColors.RED_BOLD_BRIGHT+ ex+ ConsoleColors.RESET);
			
		}
 		
 	}
     
     
     
     
     
     public static void view_list_of_GMPS(Scanner sc) {
    	 
    	 
    	 Project_Details_DAO_Interface pdd=new Project_Details_DAO();
    	 
    	 try {
			pdd.view_List_of_GMP_Members();
		} catch (NoRecordFoundException | SomethingWentWrongException ex) {
			
			System.out.println(ConsoleColors.RED_BOLD_BRIGHT+ ex+ ConsoleColors.RESET);
		}
  		
  	}
     
     
     
     
     
     
     
     
     
     public static void allocate_project_to_GMPS(Scanner sc) {
    	 
    	 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Gram Panchayat Member's ID"+ConsoleColors.RESET);
 		 String GMP_Id=sc.next(); 
 		 
 		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Project ID"+ConsoleColors.RESET);
		String project_Id=sc.next();
       
		
		 Project_Details_DAO_Interface pdd=new Project_Details_DAO();
		 
		 try {
			pdd.allocate_project_to_GMPS(GMP_Id, project_Id);
		} catch (SomethingWentWrongException | NoRecordFoundException ex) {
			
			System.out.println(ConsoleColors.RED_BOLD_BRIGHT+ ex+ ConsoleColors.RESET);
		}
  		
  	}
     
     
     
     
     
     
     
     
     
     public static void see_details_of_workers() {
    	 
    	 
    	 Project_Details_DAO_Interface pdd=new Project_Details_DAO(); 
    	 
    	 try {
			pdd.see_details_of_workers();
		} catch (NoRecordFoundException | SomethingWentWrongException ex) {
			System.out.println(ConsoleColors.RED_BOLD_BRIGHT+ ex+ ConsoleColors.RESET);
		}
  		
  	}
     
     
     
     
     
     
     
     
     public static void logout() {
    	 
    	 System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"WELCOME ! Logeed Out SuccesFullY"+ConsoleColors.RESET);
  		
  	}
     

}
