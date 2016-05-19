package com.dishtech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dishtech.beans.User;

public interface IUserDAO {

	public void insertUserDetails(User user) throws SQLException ;
	
	public Boolean checkUserDetails(User user) throws SQLException;
	
	public void getConnection() throws ClassNotFoundException, SQLException;
}
