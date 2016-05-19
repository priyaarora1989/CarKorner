/**
 * 
 */
package com.dishtech.dao;

import java.sql.*;

import com.dishtech.beans.User;

/**
 * @author Love Hasija
 * 
 */
public class UserDAO implements IUserDAO{
	 
	Connection con;
	Statement st;
	ResultSet rs;
	
	public void getConnection() throws ClassNotFoundException, SQLException
	{
		System.out.println("----------enter signup page-----------");
		
		System.out.println(" -- Driver starts loaded -----");
		
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		System.out.println("----- driver loaded----");
		
		con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
		System.out.println("--- connection established-----");
		
		
		st=con.createStatement();
		System.out.println(" -- create statement ----");
	
		// TODO Auto-generated constructor stub
	}
	
	public void insertUserDetails(User user) throws SQLException
	{
		
		String name,email,password;
		 long contactno;
		
		name=user.getName();
		System.out.println(name);
		email=user.getEmail();
		System.out.println(email);
		contactno=user.getContactno();
		System.out.println(contactno);
		password=user.getPassword();
		System.out.println(password);
		
		st.executeUpdate("INSERT INTO carkorner.user(username,emailid,contactno,password) VALUES('"+name+"','"+email+"','"+contactno+"','"+password+"')");
		System.out.println("----- inserted successfulyyyyyyyyyyyyyyyyyyy----");
	}
	
	public Boolean checkUserDetails(User user) throws SQLException
	{	
		String loginName,loginPassword;
		String pass = null;
		
		loginName=user.getLoginName();
		System.out.println("enetred name is " +loginName);
		
		loginPassword=user.getLoginPassword();
		System.out.println("entred pass is " +loginPassword);
		
		rs=st.executeQuery("select password from carkorner.user where username='"+loginName +"'");
		System.out.println("----- execute successfully------");
		
		while(rs.next())
		{
			pass= rs.getString(1);
			System.out.println("pass value is :" +pass);
			System.out.println(" loginpassword value is :" +loginPassword);
		} 
		
	
		if (pass.equalsIgnoreCase(loginPassword)){ 
			System.out.println("  return true   ");
			return true;
	}
		 else {
			 System.out.println("   return false    ");
			return false;
		 }
	}
}
