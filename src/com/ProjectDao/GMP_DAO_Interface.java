package com.ProjectDao;

import java.util.Scanner;

import com.ProjectDto.Workers_Interface;
import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;

public interface GMP_DAO_Interface {
	
	
	/**
	 * Performs login for the GMP system using the provided username and password.
	 *
	 * @param username the username of the user
	 * @param password the password of the user
	 * @throws SomethingWentWrongException if an unexpected error occurs during login
	 * @throws NoRecordFoundException if no user record is found with the provided credentials
	 */
	public void GMP_login(String username, String password) throws SomethingWentWrongException, NoRecordFoundException;
	
	
	/**
	 * Logs out the currently logged-in user from the GMP system.
	 */
	public void logout();
	
	
	/**
	 * Adds a new worker to the system using the provided worker interface object.
	 *
	 * @param wi the worker interface object representing the worker to be added
	 * @throws SomethingWentWrongException if an unexpected error occurs while adding the worker
	 */
	public void add_workers(Workers_Interface wi) throws SomethingWentWrongException;
	
	
	/**
	 * Retrieves and displays details of all workers in the system.
	 *
	 * @throws SomethingWentWrongException if an unexpected error occurs while retrieving worker details
	 * @throws NoRecordFoundException if no worker records are found in the system
	 */
	public void view_details_of_workers() throws SomethingWentWrongException, NoRecordFoundException;
	
  
    /**
     * Retrieves and displays the details of a worker using their Aadhar number.
     *
     * @param adhar the Aadhar number of the worker
     * @throws SomethingWentWrongException if an unexpected error occurs while retrieving worker details
     * @throws NoRecordFoundException if no worker record is found with the provided Aadhar number
     */
    public void view_worker_using_adhar(String adhar) throws SomethingWentWrongException, NoRecordFoundException;
    
    

    /**
     * Assigns a project to a worker with the specified worker ID and project ID.
     *
     * @param worker_id the ID of the worker
     * @param proj_Id the ID of the project
     * @throws SomethingWentWrongException if an unexpected error occurs while assigning the project
     */
    public void assign_project(int worker_id, int proj_Id) throws SomethingWentWrongException;
    
    

    /**
     * Retrieves and displays the names of workers along with the number of days they have worked.
     *
     * @param sc the scanner object used for user input
     * @throws SomethingWentWrongException if an unexpected error occurs while retrieving worker details
     * @throws NoRecordFoundException if no worker records are found in the system
     */
    public void view_name_days(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException;
    
    
 
    /**
     * Retrieves and displays the names of workers along with their wages.
     *
     * @param sc the scanner object used for user input
     * @throws SomethingWentWrongException if an unexpected error occurs while retrieving worker details
     * @throws NoRecordFoundException if no worker records are found in the system
     */
    public void view_name_wages(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException;
    
    

    /**
     * Deletes a worker with the specified worker ID from the system.
     *
     * @param worker_id the ID of the worker to be deleted
     * @throws SomethingWentWrongException if an unexpected error occurs while deleting the worker
     * @throws NoRecordFoundException if no worker record is found with the provided worker ID
     */
    public void delete_worker(String worker_id) throws SomethingWentWrongException,NoRecordFoundException;

	 

}
