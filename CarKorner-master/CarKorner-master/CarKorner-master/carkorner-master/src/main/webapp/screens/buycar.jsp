<%@page import="org.omg.CORBA.Request"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
<%@page import="com.dishtech.beans.UsedCar"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy Car</title>
</head>
<body>
<form action="../BuyServlet">
Car name <input type = "text" name="carName">
<br>
<br>
Minimum Price <input type="text" name="minPrice">
<br>
<br>
Maximum Price <input type="text" name="maxPrice">
<br>
<br>
City <input type="text" name="city">
<br>
<br>
Contact Number <input type="text" name="contactNumber">
<br>
<br>
<input type="submit" value="submit">
</form> 
<table border="1" style="width:75%">
<tr> 
	<th> Car Name</th>
		<th> Price </th>
</tr> 
<tr> 
<td> 
<%!
ArrayList<UsedCar> list = new ArrayList<UsedCar>(); 	
Iterator<UsedCar> it = null;
UsedCar car = new UsedCar();
%>
<%	
list=  (ArrayList) request.getAttribute("list");
if(list!=null)
{
it = list.iterator();
while(it.hasNext())
{
	car = it.next();
%>
<%=
car.getCarName()
%>
<%= car.getCarName() %>
</td>
<td>
<%= car.getPrice() %>
<%} 
}
%>
 </td>
</tr>
</table>

<!-- This jsp will provide a form for filling the details for buying the car.

The user will provide the following details:
Car Name - Text box 
Minimum Price - Text box
Maximum Price -- Text box
City --
Contact Number --- Text Box

Submit button -- On the click of submit button, the request would be sent to the servlet to check 
if in the usedCars table. this car is present in the user's budget. If yes, display the car name, car price
seller name and contact number of the seller in the table.

If the usedCars table doesnot contain any such records then a message will be displayed,

"We do not have any cars of your choice in our inventory yet. We will send you a mail when the car will
be available. Thanks for reaching out."
 -->
 
</body>
</html>