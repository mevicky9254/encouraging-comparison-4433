package com.ProjectUI;

import java.util.Scanner;

import com.ProjectDao.GMP_DAO;
import com.ProjectDao.GMP_DAO_Interface;
import com.ProjectDao.LoggedInGMP;
import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;
import com.projectCustom.ConsoleColors;

public class PECMain {
	
	
	
	 /**
     * Performs the login process for the BDO (Block Development Officer).
     *
     * @param sc The Scanner object for user input.
     */
	public static void BDOlogin(Scanner sc) {
		
		
		
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the Username"+ConsoleColors.RESET);
		String username=sc.next();
		
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the password"+ConsoleColors.RESET);
		String password=sc.next();
		
		
		//Validating user name and password
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			
			System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"WELCOME ADMIN ! Login is SuccesFull"+ConsoleColors.RESET);
			
			Project_Details_UI.functionalities_of_BDO(sc);
			
		}else {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Invalid Password OR User !"+ConsoleColors.RESET);
		}
		
		
	}
	
	

	
	

    /**
     * Performs the login process for the Gram Panchayat Member.
     *
     * @param sc The Scanner object for user input.
     */
    public static void GPMlogin(Scanner sc)  {
    	
    	
    	System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the Username"+ConsoleColors.RESET);
		String username=sc.next();
		
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the password"+ConsoleColors.RESET);
		String password=sc.next();
    	
		
		GMP_DAO_Interface Gd=new GMP_DAO();
		
		try {
			try {
				
				
				Gd.GMP_login(username, password);
				
			    // The condition checks if the LoggedInGMPId is not equal to 0, indicating a successful login.
			    // If the condition is true, it means a Gram Panchayat Member (GMP) has been logged in.
				if(LoggedInGMP.LoggedInGMPId!=0) {
					System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"WELCOME GMP ! Login is SuccesFull"+ConsoleColors.RESET);
					GMP_Functionalities_UI.dispaly_Menu(sc);
				}
			} catch (NoRecordFoundException e) {
				System.out.println(e);
			}
		} catch (SomethingWentWrongException e) {
			System.out.println(e);
		}
		
	}
	
    
                         
    
    
    
    
     //main method
	public static void main(String[] args) {
		
	
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"                                             "+ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"                WELCOME TO THE               "+ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"                                             "+ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"          PEOPLE'S EMPLOYEMENT CENTRE        "+ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"                                             "+ConsoleColors.RESET);
		System.out.println();
		
		System.out.println("================================================");
		System.out.println();
		
		int ch=0;
		
		do {
			System.out.println(ConsoleColors.BLUE_BOLD+"0. Enter 0 to Exit the Application"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.BLUE_BOLD+"1. Enter 1 to login as BDO"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.BLUE_BOLD+"2. Enter 2 to login as Grma Panchayat member"+ConsoleColors.RESET);
			
			ch=sc.nextInt();
			
			switch(ch) {
			
			case 0 :System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+"APPLICATION IS CLOSED !!"+ConsoleColors.RESET);
			        break;
			
			case 1: BDOlogin(sc);
			        break;
			        
			case 2: GPMlogin(sc);
	                break;
			default :System.out.println("Invalid choice");
			}
			
			
		}while(ch!=0);
		
		
		
		sc.close();

	}

}
