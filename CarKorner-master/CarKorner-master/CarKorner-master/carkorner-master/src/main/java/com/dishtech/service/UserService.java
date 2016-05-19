/**
 * 
 */
package com.dishtech.service;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.dishtech.beans.User;

import com.dishtech.dao.UserDAO;

/**
 * @author Love Hasija
 * 
 */
public class UserService implements IUserService{
	
	UserDAO dao = new UserDAO();
	
	public void userDetails(User user) throws ClassNotFoundException, SQLException
	{				
		dao.getConnection();
		System.out.println("-- builddd---------");
		
		dao.insertUserDetails(user);	
	}
	
	public Boolean userCheck(User user) throws ClassNotFoundException, SQLException
	{
		dao.getConnection();
		System.out.println("---- service get connection buildd------");
		return dao.checkUserDetails(user);
	}
}
