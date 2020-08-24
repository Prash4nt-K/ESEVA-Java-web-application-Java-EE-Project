<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ page import ="java.io.IOException"%>
<%@ page import ="java.io.PrintWriter"%>
<%@ page import ="ESeva.pojo.EmergencyPojo"%>
<%@ page import ="ESeva.dbutil.DBConnection"%>
<%@ page import ="ESeva.dao.EmergencyDao"%>
<%@ page import ="java.util.ArrayList"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medical Rapid Force Team</title>
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
  </div> 
  
</div>
<div class="para">

<h3 style="font-size:32px; border:3px solid black; padding:10px">Medical Emergency</h3>
<p>Emergency List.</p>
</div>

<br>

<%
	ArrayList<EmergencyPojo> ar = EmergencyDao.getDetailsForEmergency();

	EmergencyPojo ep;

	out.println("<html> <head> <style ='text/css'>table{border-spacing:5px; border:3px solid black; font-size:18px; padding:3px; margin:20px;} th,td{padding:5px;}</style></head>");		
	out.println("<body>");

	if(ar.size() > 0)
	{
	out.println("<table id='aaaa'>");
	out.println("<tr><th>Location</th><th>Accedent Type</th><th>Number Of People</th><th>Priority</th><th>Date</th><th>Time</th>");

	for(int i=0;i<ar.size();i++)
	{
		ep =  ar.get(i);
		out.println("<tr><td>"+ep.getLocation()+"</td><td>"+ep.getAccedentType()+"</td><td>"+ep.getNumberOfPeople()+"</td><td>"+ep.getPriority()+"</td><td>"+ep.getDate()+"</td><td>"+ep.getTime()+"</td>");
	
	}
	}
	else
	{
		response.sendRedirect("NoEmergency.html");
	}

	out.println("</body></html>");
%>

    
</body>
</html>