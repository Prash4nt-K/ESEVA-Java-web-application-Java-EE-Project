<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ page import ="java.io.IOException"%>
<%@ page import ="java.io.PrintWriter"%>
<%@ page import ="ESeva.pojo.ViolatorPojo"%>
<%@ page import ="ESeva.dbutil.DBConnection"%>
<%@ page import ="ESeva.dao.RegisterViolationDao"%>
<%@ page import ="java.util.ArrayList"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Traffic Central Team</title>
<link rel="stylesheet" type="text/css" href="css/homepage.css">
<link rel="stylesheet" type="text/css" href="css/login.css">

<script>

function validate()
{
	var cid = document.getElementById("cid");
	
	if(cid.value == "")
	{
		alert("Please enter Challan Id");
		return false;
	}
	else
	{
		return true;
	}
}
    
    
</script>
</head>
<body>


<div><p></p></div>

<div>
	<div class="Space">
  <a href="home.html"><img class="pho" src ="images/TrafficPolice.png"></a>
  </div>
  
  <div class="navi">
  <p></p>
  <a href="home.html">Home</a>
  <a href="TrafficCentralTeam.jsp">SOS Emergency</a>
  <a href="FineCollected.jsp">Fine Collected</a> 
  </div> 
  
</div>
<div class="para">

<h3 style="font-size:32px; border:3px solid black; padding:10px">Registered traffic violations</h3>
<p>List below.</p>
</div>


<%
	ArrayList <ViolatorPojo> ar = new ArrayList<>();
	ar = RegisterViolationDao.getDetailsOfViolators();
	
	ViolatorPojo vp;

	out.println("<html> <head> <style ='text/css'>table{border-spacing:5px; border:3px solid black; font-size:18px; padding:3px; margin:20px;} th,td{padding:5px;}</style></head>");		
	out.println("<body>");


	if(ar.size() > 0)
	{

	out.println("<table id='aaaa'>");
	out.println("<tr><th>Challan Id</th><th>Violator Name</th><th>Vehicle Type</th><th>Vehicle Number</th><th>Place Of Violation</th><th>Offence Description</th><th>Date</th><th>Time</th><th>Fine Amount</th>");

	for(int i=0;i<ar.size();i++)
	{
		vp =  ar.get(i);
		out.println("<tr><td>"+vp.getCid()+"</td><td>"+vp.getViolatorName()+"</td><td>"+vp.getVehicleType()+"</td><td>"+vp.getVehicleNo()+"</td><td>"+vp.getPlaceOfViolation()+"</td><td>"+vp.getOffenceDes()+"</td><td>"+vp.getDate()+"</td><td>"+vp.getTime()+"</td><td>"+vp.getAmount()+"</td>");
	
	}
	}
	else
	{
		response.sendRedirect("NoViolationsRegistered.html");
	}

	out.println("</body></html>");
%>

    
</body>
</html>