package com.ProjectUI;

import java.time.LocalDate;
import java.util.Scanner;

import com.ProjectDao.GMP_DAO;
import com.ProjectDao.GMP_DAO_Interface;
import com.ProjectDao.Project_Details_DAO;
import com.ProjectDao.Project_Details_DAO_Interface;
import com.ProjectDto.Workers_DTO;
import com.ProjectDto.Workers_Interface;
import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;
import com.projectCustom.ConsoleColors;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//Functionalities of the Gram Panchayat Member
public class GMP_Functionalities_UI {
	
	
	
	
	
	//Method to add workers
	public static void add_workers(Scanner sc) {
		
		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Workers's ID"+ConsoleColors.RESET);
 		 String worker_Id=sc.next(); 
    	 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the Adhar card Number "+ConsoleColors.RESET);
 		 long adhar=sc.nextLong(); 
 		 String adharCard = String.valueOf(adhar);
 		  sc.nextLine();
 		 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Worker's Name"+ConsoleColors.RESET);
 		 String name=sc.nextLine();
 		 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Worker's Date of Birth"+ConsoleColors.RESET);
 		 LocalDate dob=LocalDate.parse(sc.next());
 		 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Worker's Gender"+ConsoleColors.RESET);
 		 String gender=sc.next(); 
    	 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Panchayat name"+ConsoleColors.RESET);
 		 String panchayat_Name=sc.next(); 
 		 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  District name"+ConsoleColors.RESET);
 		 String district =sc.next(); 
 		 
 		 
 		 System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  State name"+ConsoleColors.RESET);
 		 String state =sc.next(); 
 		 
 		 
 		 
 		  // Validate the length of adhar
 	 	   if (adharCard.length() != 12) {
 	 	      System.out.println("Invalid Aadhaar card number. It should be 12 digits long.");
 	 	    return;
 	 	    }

 	 	   // Validate numeric characters of adhar
 	 	 if (!adharCard.matches("[0-9]+")) {
 	 	    System.out.println("Invalid Aadhaar card number. It should only contain numeric digits.");
 	 	    return;
 	 	 }
 		 
 		 
 		 
 		Workers_Interface wi=new Workers_DTO(worker_Id, adharCard, name,dob,gender,panchayat_Name,district, state);
 		 
 		GMP_DAO_Interface gd=new GMP_DAO();
 		
 		try {
			gd.add_workers(wi);
		} catch (SomethingWentWrongException ex) {
			System.out.println(ConsoleColors.RED_BOLD_BRIGHT+ ex+ ConsoleColors.RESET);
		}
 		 
		
	}
	
	
	
	
	
	
	
	// Method to view details of workers
    public static void view_details_of_workers(Scanner sc) {
	
	     GMP_DAO_Interface gd=new GMP_DAO();
	  try {
		gd.view_details_of_workers();
	 } catch (SomethingWentWrongException | NoRecordFoundException ex) {
		System.out.println(ConsoleColors.RED_BOLD_BRIGHT+ ex+ ConsoleColors.RESET);
	 }
		
	 }



    
    


   // Method to view details of workers using adhar
    
    public static void view_worker_using_adhar(Scanner sc) {
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Enter the Aadhaar Card Number: " + ConsoleColors.RESET);
        long adhar = sc.nextLong();
        String adharCard = Long.toString(adhar);

        // Validate Aadhaar card number
        if (!isValidAadhaar(adharCard)) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid Aadhaar Card Number." + ConsoleColors.RESET);
            return;
        }

        // Hash Aadhaar card number using SHA-256 algorithm
        String hashedAdhar = hashSHA256(adharCard);

        GMP_DAO_Interface gd = new GMP_DAO();

        try {
            gd.view_worker_using_adhar(hashedAdhar);
        } catch (SomethingWentWrongException | NoRecordFoundException ex) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + ex + ConsoleColors.RESET);
        }
    }

    // Validate Aadhaar card number (assumed 12-digit number)
    private static boolean isValidAadhaar(String adharCard) {
        return adharCard.matches("^\\d{12}$");
    }

    // Hashing using SHA-256 algorithm
    private static String hashSHA256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(input.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle hashing algorithm exception
            e.printStackTrace();
            return null;
        }
    }
   
   
    
   
    
   
   // Method to assign projects to workers
   public static void assign_project(Scanner sc) {
	
	  System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the workrs ID "+ConsoleColors.RESET);
	  int W_Id=sc.nextInt(); 
		 
	  System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Project ID"+ConsoleColors.RESET);
	  int project_Id=sc.nextInt();
   
	  GMP_DAO_Interface gd=new GMP_DAO();
	
	 
	 try {
		gd.assign_project(W_Id, project_Id);
	} catch (SomethingWentWrongException  ex) {
		
		System.out.println(ConsoleColors.RED_BOLD_BRIGHT+ ex+ ConsoleColors.RESET);
	}
	
 }

   
   

   // Method to view name and duration of projects
   public static void view_name_days(Scanner sc) {
	
	 GMP_DAO_Interface gd=new GMP_DAO();
	 
	 try {
		gd.view_name_days(sc);
	} catch (SomethingWentWrongException | NoRecordFoundException ex) {
		System.out.println(ConsoleColors.RED_BOLD_BRIGHT+ ex+ ConsoleColors.RESET);
	}
	
   }



  // Method to view name of worker and total wages
  public static void view_name_wages(Scanner sc) {
	
	 GMP_DAO_Interface gd=new GMP_DAO();
	 
	 try {
		gd.view_name_wages(sc);
	} catch (SomethingWentWrongException | NoRecordFoundException ex) {
		System.out.println(ConsoleColors.RED_BOLD_BRIGHT+ ex+ ConsoleColors.RESET);
	}
	
 }

  
  


   //Method to delete worker based on worker id
   public static void delete_worker(Scanner sc) {
	
	System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Enter the  Workers's ID"+ConsoleColors.RESET);
	 String worker_Id=sc.next(); 
	 
	 GMP_DAO_Interface gd=new GMP_DAO();
	 
	 try {
		 
		gd.delete_worker(worker_Id);
		
	} catch (SomethingWentWrongException | NoRecordFoundException ex) {
		System.out.println(ConsoleColors.RED_BOLD_BRIGHT+ ex+ ConsoleColors.RESET);
	}
	 
	
  }


   
   

  // Method to log out
   public static void logout_GMP(Scanner sc) {
	
	GMP_DAO_Interface gd=new GMP_DAO();
	gd.logout();
	
   }
	




	
	public static void dispaly_Menu(Scanner sc) {
		
	int ch=0;
		
		do {
			
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 1 TO ADD WORKERS"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 2 TO VIEW DETAILS OF WORKERS"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 3 TO VIEW DETAILS OF WORKERS USING ADHAR"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 4 TO  ASSIGN PROJECTS TO WORKERS"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 5 TO VIEW WORKER NAME AND NO. OF DAYS HE WORKED"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 6 TO VIEW WORKER NAME AND HIS TOTAL WAGES"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 7 TO DELETE A WORKER"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"PRESS 8 TO LOG OUT"+ConsoleColors.RESET);
			
			ch=sc.nextInt();
			
			switch(ch) {
			
			
			case 1: GMP_Functionalities_UI.add_workers(sc);
			         break;
			         
			case 2: GMP_Functionalities_UI.view_details_of_workers(sc);
	                 break;
	         
	         
			case 3: GMP_Functionalities_UI.view_worker_using_adhar(sc);
	                break;
	         
			case 4: GMP_Functionalities_UI.assign_project(sc);
	                break;
	         
			case 5: GMP_Functionalities_UI.view_name_days(sc);
	                break;
	         
			case 6: GMP_Functionalities_UI.view_name_wages(sc);
	                break;
	         
			case 7: GMP_Functionalities_UI.delete_worker(sc);
                     break;
			case 8:GMP_Functionalities_UI.logout_GMP(sc);
	                break;
			
			}
			
			
			
			
		}while(ch!=8);
		
	}
	

}
