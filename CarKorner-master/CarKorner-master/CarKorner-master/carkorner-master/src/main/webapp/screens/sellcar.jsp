<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sell Car</title>
</head>
<body>
<form action="../SellBuyServlet">
Car name <input type="text" name="carName"/>
<br>
<br>
Car Color <input type="text" name="carColor"/>
<br>
<br>
Car Price <input type="text" name="carPrice"/>
<br>
<br>
model Year <input type="text" name="modelYear"/>
<br>
<br> 
City <input type="text" name="city"/>
<br>
<br>
<input type="submit" value="submit">

 </form>
<!-- This jsp will contain a form to provide the details for selling a car.

The form will contain these fields:
car Name
car Model
car Color
Car Price
modelYear
city

Submit Button-> On submitting the form, the car details will be saved into the usedCar table.

A message will be displayed to the user saying "The car has been saved to our inventory. We will contact you soon"
 -->
 
 
</body>
</html>