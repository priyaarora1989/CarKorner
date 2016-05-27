<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<script type="text/javascript">

function isEmpty()
{	
var x=document.login.loginUsername.value;
var y=document.login.loginPassword.value;

if(x.length==0 || y.length==0)
	{
	alert(" Please enter username and password ");
	return false;
	}
else
	{
	return true;
	}
}
</script>

<body bgcolor="lightblue">

<form name="login" method="get" action="LoginServlet">
<center>
<br>
Username <input type="text" name="loginUsername" value="" placeholder="enter ur name" autofill="on">
<br>
<br/>
Password <input type="password" name="loginPassword" placeholder="Enter Password" value="">
<br>
<br/>
 <input type="submit" name="Login" value="Submit" onClick="return isEmpty()"> 
 
 </center>
 
<!--  this should be the first page of the application. 

There will be two textboxes,
Username
Password

Login button- This button will take the details of the user , authenticate the user
and take the user to the search.jsp. 
If the user credentials do not match, a message will be displayed saying, username and password do not match.

On the bottom of login button, there should be a link saying, 'If not an existing user, SignUp'. On the click of this
link, the user should be taken to the sign up page.

 -->
 
 <a style="position: bottom;background-color: white; width: 600px; height: 800px;" href="screens/signup.jsp"> If not an existing user, SignUp </a>
</body>
</html>

