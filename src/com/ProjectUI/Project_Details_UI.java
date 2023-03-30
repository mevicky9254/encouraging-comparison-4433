package com.ProjectUI;

import java.util.Scanner;

import com.projectCustom.ConsoleColors;

public class Project_Details_UI {
	
	
	public static void functionalities_of_BDO(Scanner sc) {
		
		int ch=0;
		
		do {
			
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 1 TO CREATE PROJECT"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 2 TO VIEW LIST OF PROJECTS"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 3 TO ADD GRAM PANCHAYAT MEMBER"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 4 TO  VIEW ALL THE GPMS"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 5 TO ALLOCATE THE PROJECT TO GPMS"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 6 TO SEE THE DETAILS OF ALL WORKERS"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 7 TO LOG OUT"+ConsoleColors.RESET);
			
			ch=sc.nextInt();
			
			switch(ch) {
			
			
			case 1: BDO_Functionalites_UI.createProject(sc);
			         break;
			         
			case 2: BDO_Functionalites_UI.view_List_of_Projects();
	                 break;
	         
	         
			case 3: BDO_Functionalites_UI.add_GMPS(sc);
	                break;
	         
			case 4: BDO_Functionalites_UI.view_list_of_GMPS(sc);
	                break;
	         
			case 5: BDO_Functionalites_UI.allocate_project_to_GMPS(sc);
	                break;
	         
			case 6: BDO_Functionalites_UI.see_details_of_workers(sc);
	                break;
	         
			case 7: BDO_Functionalites_UI.logout();
	                break;
			
			}
			
			
			
			
		}while(ch!=7);
		
		
	}
	

}


//Create a project with details projectName, startDate, endDate, noOfWorkers, 
//per_day_wages
//View List of Projects
//Add gram panchayat member with details aadhaar_number, name, dob, gender, 
//panchayat name, district, state
//View all the GPMs 
//Allocate a project to a GPM.See the details of all workers. 
//Logout