	package com.dishtech.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dishtech.beans.User;

public interface IUserService {

	public void userDetails(User user) throws ClassNotFoundException, SQLException;
	
	public Boolean userCheck(User user) throws ClassNotFoundException, SQLException;
}
