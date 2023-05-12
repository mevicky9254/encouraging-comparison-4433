package com.ProjectDao;

import java.util.List;
import java.util.Scanner;

import com.ProjectDto.GMP_Details_Interface;
import com.ProjectDto.Project_Details_Interface;
import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;

public interface Project_Details_DAO_Interface {

	/**
	 * Creates a new project.
	 *
	 * @param Pd The project details.
	 * @throws SomethingWentWrongException If an error occurs while creating the project.
	 */
	public void createProject(Project_Details_Interface Pd) throws SomethingWentWrongException;

	/**
	 * Retrieves and displays the list of projects.
	 *
	 * @throws NoRecordFoundException      If no projects are found.
	 * @throws SomethingWentWrongException If an error occurs while retrieving the list of projects.
	 */
	public void view_List_of_Projects() throws NoRecordFoundException, SomethingWentWrongException;

	/**
	 * Adds a GMP (General Management Personnel) to the system.
	 *
	 * @param GD The GMP details.
	 * @throws SomethingWentWrongException If an error occurs while adding the GMP.
	 */
	public void add_GMPS(GMP_Details_Interface GD) throws SomethingWentWrongException;

	/**
	 * Retrieves and displays the list of GMP members.
	 *
	 * @throws NoRecordFoundException      If no GMP members are found.
	 * @throws SomethingWentWrongException If an error occurs while retrieving the list of GMP members.
	 */
	public void view_List_of_GMP_Members() throws NoRecordFoundException, SomethingWentWrongException;

	/**
	 * Allocates a project to a GMP member.
	 *
	 * @param GMP_id    The ID of the GMP member.
	 * @param project_Id The ID of the project.
	 * @throws SomethingWentWrongException If an error occurs while allocating the project.
	 * @throws NoRecordFoundException      If the GMP member or project is not found.
	 */
	public void allocate_project_to_GMPS(int GMP_id, int project_Id) throws SomethingWentWrongException, NoRecordFoundException;

	/**
	 * Displays the GMP members along with their allocated projects.
	 *
	 * @throws SomethingWentWrongException If an error occurs while retrieving the information.
	 * @throws NoRecordFoundException      If no GMP members with allocated projects are found.
	 */
	public void show_GMPS_with_Allocated_Projects() throws SomethingWentWrongException, NoRecordFoundException;

	/**
	 * Displays the details of workers.
	 *
	 * @throws NoRecordFoundException      If no workers are found.
	 * @throws SomethingWentWrongException If an error occurs while retrieving the details of workers.
	 */
	public void see_details_of_workers() throws NoRecordFoundException, SomethingWentWrongException;
	
}
