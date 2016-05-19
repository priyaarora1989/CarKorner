<%@ page import="com.dishtech.frontController.SignUpServlet" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>
<%! String f;%>
<% f = (String)request.getAttribute("flag"); %>
<%= f %>

<script type="text/javascript">

int f=0;
		alert(f);
	
</script>


</head>

<body bgcolor="lightgreen">

<form name="signupp"  action="../SignUpServlet" method="get" autocommit="on"> 
<center>

User name <input type="text" name="newusername" placeholder="enter new username">
<br/>
<br>
Email ID <input type="text" name="emailid" placeholder="enter email id">
<br/>
<br>
contact no <input type="text" name="contactnumber" placeholder="enter contactnumber">
<br/>
<br>
Password <input type="password" name="password" placeholder="enter password"> 
<br/>
<br>
<input type="submit" name="Signup" value="signup">

<!--  This jsp will be used to sign up a user. 

This will have a form with following fields
User Name 
Email Id
Contact number
Password

A sign up button. On click of button, the user details will be saved into the User table.

-->

</center>
</form> 
</body>
</html>