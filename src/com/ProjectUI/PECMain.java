package com.ProjectUI;

import java.util.Scanner;

import com.projectCustom.ConsoleColors;

public class PECMain {
	
	public static void BDOlogin(Scanner sc) 
		System.out.println("BDO LOGING In");
		
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the Username"+ConsoleColors.RESET);
		String username=sc.next();
		
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the password"+ConsoleColors.RESET);
		String password=sc.next();
		
		if(username.equals("admin") && password.equals("admin")) {
			
			System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"WELCOME ! Login is SuccesFull"+ConsoleColors.RESET);
			
			Project_Details_UI.functionalities_of_BDO(sc);
			
		}else {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Invalid Password OR User !"+ConsoleColors.RESET);
		}
		
		
		
	}
	
	
    public static void GPMlogin(Scanner sc) {
		
	}
	
    
    
    
    
    
    

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int ch=0;
		
		do {
			System.out.println(ConsoleColors.BLUE_BOLD+"0. Enter 0 to Exit the Application"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.BLUE_BOLD+"1. Enter 1 to login as BDO"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.BLUE_BOLD+"2. Enter 2 to login as Grma Panchayat member"+ConsoleColors.RESET);
			
			ch=sc.nextInt();
			
			switch(ch) {
			
			case 0 :System.out.println("Exiting");
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
