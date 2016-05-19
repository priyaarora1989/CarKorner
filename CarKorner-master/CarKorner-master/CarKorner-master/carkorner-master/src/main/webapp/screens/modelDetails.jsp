<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.dishtech.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Model Details</title>
<style type="text/css">

#frst_col {margin:1%;float:left;width:30%;font-weight: bold;font-size: large;}
#second_col {margin:1%;float:left;width: 30%;font-weight: bold;font-size: large;}
#thrd_col {margin:1%;float:right;width:30%; auto;}
#ist_row {margin:1%;margin-top:10%;width:80%;height:30%;}
#data {width:100%;height:30%;border:1px solid black;margin-top:1%;}
#features {width:100%;height:10%;border:1px solid black;margin-top:1%;float:right;}
</style>
</head>
<body>

<div id="container">

 	<div id="frst_col">
		<%! Car car = new Car(); %>
		<% car =(Car) request.getAttribute("car"); 
		%>
		<%= car.getCarName() %>
	</div>

	<div id="second_col">
		<% car =(Car) request.getAttribute("car"); 
		%>
		<%= car.getModelName() %>
	</div>	
	
	<div id="thrd_col"> 
		<% car =(Car) request.getAttribute("car"); 
		%>
		<%= car.getCarPrice()  %> Lakhs
	</div>

	<div id="data">
		<table border="1" style="width:75%" >
			<th>Color
			<tr> 
				<td> <% car = (Car) request.getAttribute("car"); %>
					<%! ArrayList<String> list = new ArrayList<String>();
					 %>				
					<%list = car.getColorName(); 
						Iterator<String> it = list.iterator();
						while(it.hasNext())
						{
					out.println(it.next()); 
					%>					 	
				</td>
			</tr> 
			<tr> 
				<td> <% out.println(it.next()); %></td>
			</tr> 
			<tr> 
				<td> <% out.println(it.next()); %> </td>
			</tr> 
			<tr> 
				<td> <% out.println(it.next()); %> </td>
			</tr> 
			<tr> 
				<td> <% out.println(it.next()); %> </td>
			</tr> 
			<tr> 
				<td>  <% out.println(it.next()); }  %> </td>
			</tr> 
		</table>
	</div>		
	
	<div id="features"> 
		<table border="1" align="right" style="width:75%;" >
			<th align="center" style="font-weight:bold;"> Features </th>
			<tr> 
				 <td> AirBag </td>
			 	<td>	<% car = (Car)request.getAttribute("car"); %>
			 	  <%= car.getAirBags() %> 		
			 	</td>
			 </tr>
			 
			 <tr>
				 <td> dualStorageAirBags </td>
	    		  <td> 
			  				 <% car = (Car) request.getAttribute("car"); %>
					<%! ArrayList<Boolean> feature = new ArrayList<Boolean>();
					 %>				
					<% feature = car.getFeature(); 
						Iterator<Boolean> ite = feature.iterator();
						while(ite.hasNext())
						{
							out.println(ite.next());
					%>

			  </td>
			  </tr>
			 
			 <tr>
			 	<td> ABS </td>
			 	<td> <% out.println(ite.next());  %> </td>
			 </tr>
			  
			 <tr> 
			 <td> EBD </td>
			 <td> 
			 	<% out.println(ite.next());  %>
			 </td>
			  </tr>
			  
			  <tr>
			 <td> BA </td>
			 <td>
			 	<% 	out.println(ite.next());  %>
			  </td>
			  </tr>
			
			 <tr>
			 <td> ESP </td>
			 <td>  
			 		<% 	out.println(ite.next());  %>
			 </td>
			  </tr>
			
			
			 <tr>
			 <td> fourWheelDrive </td>
 			 <td> 
 			 		<% 	out.println(ite.next());  %>
 			 </td>
			  </tr>
			
			 <tr>
			 <td> hillHoldControl </td>
 			 <td> <% 	out.println(ite.next());  %>  </td>
			  </tr>
			
			
			 <tr>
			 <td> engineMobilizer </td>
 			 <td> <% 	out.println(ite.next());  %> </td>
			  </tr>
			
			
			 <tr>
			 <td>  centralLocking </td>
			 <td> <% 	out.println(ite.next());  %> </td>
			  </tr>
			
			
			 <tr>
			 <td> speedSensoredDoorLock </td>
			 <td> <% 	out.println(ite.next());  %> </td>
			  </tr>
			
			
			 <tr>
			 <td> childSafetyLock </td>
 			 <td> <% 	out.println(ite.next());  } %>  </td>
			  </tr>	
			
		</table>
	</div>
	
	<div>
		<table border="1"  style="width:75%;" >
			<th> Specification
			<tr> 
				<td> WheelBase </td>
				<td> <% car = (Car) request.getAttribute("car"); %>
					<%! Specifications sp = new Specifications(); %>
					<% sp = car.getSp();
					out.println(sp.getWheelBase()) ;%>					 	
				</td>
			</tr> 
			
			 <tr>
			 <td> WheelBase </td>
 			 <td> <%= sp.getWheelBase() %>  </td>
			  </tr>	
			   <tr>
			 <td> GroundClearance </td>
 			 <td> <%= 	sp.getGroundClearance() %>  </td>
			  </tr>	
			   <tr>
			 <td> KERWeight </td>
 			 <td> <%= sp.getKERWeight() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> Doors </td>
 			 <td> <%= sp.getDoors() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> SeatingCapacity </td>
 			 <td> <%= sp.getSeatingCapacity() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> NoOfSeatingSpace </td>
 			 <td> <%= sp.getNoOfSeatingSpace() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> BootSpace </td>
 			 <td> <%= sp.getBootSpace() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> FuelTankCapacity </td>
 			 <td> <%= sp.getFuelTankCapacity() 	 %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> FuelType </td>
 			 <td> <%= sp.getFuelType() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> MaxTorque </td>
 			 <td> <%= sp.getMaxTorque() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> Mileage </td>
 			 <td> <%= sp.getMileage() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> Displacement </td>
 			 <td> <%= sp.getDisplacement() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> MaxPower </td>
 			 <td> <%= sp.getMaxPower() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> Cylinders </td>
 			 <td> <%= sp.getCylinders() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> TurboChargers </td>
 			 <td> <%= 	sp.getTurboChargers() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> TurboChargersType </td>
 			 <td> <%= sp.getTurboChargers() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> Valve </td>
 			 <td> <%= sp.getValve() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> NoOfGears </td>
 			 <td> <%= sp.getNoOfGears() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> TransmissionType </td>
 			 <td> <%= sp.getTransmissionType() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> setDriveTrain </td>
 			 <td> <%= sp.getDriveTrain() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> DualClutch </td>
 			 <td> <%= sp.getDualClutch() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> SportMode </td>
 			 <td> <%= sp.getSportMode() %>  </td>
			  </tr>	
			  
			   <tr>
			 <td> DrivingMode </td>
 			 <td> <%= sp.getDrivingMode() %>  </td>
			  </tr>	
			  
		</table>
	</div>
</div>


<!-- 
On the top: Car name, car model Name and car price will be displayed.
After that, the  page would contain the data in four tables.

The tables would contain the following details
modelFeatures
model Specifications
model summary
model Colors

 On the bottom, there will be a back button which will take the user to the search screen
 and the same information will be displayed which was display before.
 -->
 
</body>
</html>