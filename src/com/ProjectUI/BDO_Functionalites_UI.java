package com.ProjectUI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.ProjectDao.Project_Details_DAO;
import com.ProjectDao.Project_Details_DAO_Interface;
import com.ProjectDto.Project_Details_DTO;
import com.ProjectDto.Project_Details_Interface;
import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;
import com.projectCustom.ConsoleColors;

public class BDO_Functionalites_UI {

	
	public static void createProject(Scanner sc) {
		
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Project ID"+ConsoleColors.RESET);
		String project_Id=sc.next();
		
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the Project Name"+ConsoleColors.RESET);
		 String project_Name=sc.next();
		
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
 		
 	}
     
     
     
     public static void view_list_of_GMPS(Scanner sc) {
  		
  	}
     
     
     public static void allocate_project_to_GMPS(Scanner sc) {
  		
  	}
     
     
     public static void see_details_of_workers(Scanner sc) {
  		
  	}
     
     public static void logout() {
    	 
    	 System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"WELCOME ! Logeed Out SuccesFullY"+ConsoleColors.RESET);
  		
  	}
     

}
