package com.dishtech.controller;

import java.sql.*;

import java.sql.SQLException;

import com.dishtech.beans.User;
import com.dishtech.service.*;


public class UserController {
	
	User user= new User();
	
	UserService us = new UserService();
	
	public void createUser(String name, String email, String password,long contactno) throws ClassNotFoundException, SQLException
	{
		
		System.out.println(" - - - enter create user ------");
		
		user.setName(name);
		System.out.println(" ----- set name -------");
		
		user.setEmail(email);
		System.out.println(" -- set email ----");
		
		user.setContactno(contactno);
		System.out.println("---- set contact no ----");
		
		user.setPassword(password);
		System.out.println(" ---- set password -------");
		
		us.userDetails(user);
		System.out.println(" --- userdetails called -----");
		
		//Create the user object
		//Send to service and service to DAO
		//Insert the details into the table.
	}	
	
	public boolean loginUser(String loginName, String loginPassowrd) throws ClassNotFoundException, SQLException{
		
		System.out.println("---- enter user controller page -------");
		
		user.setLoginName(loginName);
		user.setLoginPassword(loginPassowrd);
		
		 return us.userCheck(user);
		
		
	}
}
