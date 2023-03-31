package com.ProjectDao;

import com.ProjectException.NoRecordFoundException;
import com.ProjectException.SomethingWentWrongException;

public interface GMP_DAO_Interface {
	
	public void GMP_login(String username,String Password)throws SomethingWentWrongException,NoRecordFoundException;
	public void logout();

}
