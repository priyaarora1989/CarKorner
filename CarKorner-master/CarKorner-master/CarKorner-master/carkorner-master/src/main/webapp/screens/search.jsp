<%@page import="org.omg.CORBA.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dishtech.beans.*,java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Search</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<style type="text/css">

#container {width:100%;margin: 0;;height:70%;border:1px solid black;margin-bottom:80%;}
#frst_col {margin:1%;float:left;width:30%;}
#second_col {margin:1%;float:left;width: 30%;}
#thrd_col {margin:1%;float:right;width:30%; auto;}
#text {margin:20%;width:50%;border:1px solid black;height:40%;margin-top:20%;}
#details{margin:5%;width:50%;border:1px solid black;height:100%;margin-bottom:5%;font-weight: bold;}

#button {
     background:none!important;
     border:none; 
     padding:0!important;
     font: inherit;
     /*border is optional*/
     border-bottom:1px solid #444; 
     cursor: pointer;
}
</style>
</head>
<body>


<div id="container">
	
	<div id="frst_col">

		<form action="screens/search.jsp"  defaultbutton="search_car">
		<button type="submit"  style="width:250px;height:100px;">Search car</button>
		</form>
	</div>
	
	<div id="second_col"> 
		<form action="screens/buycar.jsp"  >
		<button type="submit" style="width:250px;height:100px;">Buy car</button>
		</form>
	</div>

	<div id="thrd_col"> 
		<form action="screens/sellcar.jsp" >
		<button type="submit"  style="width:250px;height:100px;">Sell car</button>
		</form>
	</div>
	
	<div id="text">
		<form action="SearchCarServlet" method="get">
			<center>
				<input type="text" name="search" align="middle" style="width:150px;border:1px solid black;height:25px; margin-top:1%">
				<br>
				<br/>
				<input type="submit" value="search" style="margin-bottom:1%">
			</center> 
		</form>
	</div>
	
	
	<div id="details">
	
	<%! Car car = new Car();
	String carName;
	Float carPrice;
	ArrayList<Model> list = new ArrayList<Model>();
	Float modelId;
	String modelName;
	%>
			<%  car = (Car) request.getAttribute("car"); 				
			 if (car!=null)
			 {
				 list = car.getList();
 				out.println(car.getCarName());
 				
 				out.println(car.getCarPrice() +"Lakhs");
 				for(Model model : list)
				{
					 modelId = model.getModelId();
					  modelName = model.getModelName();					  
		%>
		
		<list>
		<ul>
			<li> <form action="ModelDetailsServlet" method="get">
						
					  <input type="hidden" name="carName" value="<%= car.getCarName() %>">
					  <input type="hidden" name="modelId" value="<%= modelId %>">
					  <input type="hidden" name="modelName" value="<%= modelName %>">
   					  <input type="submit" id="button" value="<%= modelName %>">
				</form>
						
		</ul>
		 </list>
					<%
				} 
 			}
 		
 			%>
			 
	</div>
</div>


<!--  This is the first page that should be displayed after the user logs in. The header 
should be included in the jsp. Then we should have buttons on the top like in carkorner.com,
(Search Car, Buy Car, Sell Car). By default the search car button should be presed, 
and the center part of the page should contain a search box with a search button.

 On the click of the search, call the servlet which will fetch the car results based on the
 name entered by the user in the search box. The servlet will provide the car models of the car,
 name of car and price of car.
 
 The car name and car price should be displayed in bold on jsp.
 The car models should be displayed as links in a list format on jsp.
 
 On click of the carModel Name, a new request would be sent to the servlet, which would fetch the details of that 
 model.
 
 -->

</body>
</html>