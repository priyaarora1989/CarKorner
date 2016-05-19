/**
 * 
 */
package com.dishtech.beans;

/**
 * @author Love Hasija
 * 
 */
public class User {

	private String name,email,password,loginName,loginPassword;
	private long contactno;
	
	public String getName() {
		
		System.out.println(" get name " +name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("name =" +name);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		System.out.println(" email =" +email);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		System.out.println("password=" +password);
	}

	public long getContactno() {
		return contactno;
	}

	public void setContactno(long contactno) {
		this.contactno = contactno;
		System.out.println("contact no = " +contactno);
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}



	
}
