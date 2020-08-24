<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ page import ="java.io.IOException"%>
<%@ page import ="java.io.PrintWriter"%>
<%@ page import ="ESeva.pojo.ViolatorPojo"%>
<%@ page import ="ESeva.dbutil.DBConnection"%>
<%@ page import ="ESeva.dao.PaymentDao"%>
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
  <a href="TrafficViolationsCentralTeam.jsp">Traffic Violations</a>
  <a href="TrafficCentralTeam.jsp">SOS Emergency</a>
  </div> 
  
</div>
<div class="para">

<h3 style="font-size:32px; border:3px solid black; padding:10px">Fine Collected</h3>
<p>List below.</p>
</div>
<br>

<%
	ArrayList<ViolatorPojo> ar =  PaymentDao.getFineCollectedDetails();
	
	ViolatorPojo vp;

	out.println("<html> <head> <style ='text/css'>table{border-spacing:5px; border:3px solid black; font-size:18px; padding:3px; margin:20px;} th,td{padding:5px;}</style></head>");		
	out.println("<body>");


	if(ar.size() > 0)
	{

	out.println("<table id='aaaa'>");
	out.println("<tr><th>Violator Name</th><th>Collected Fine Amount</th><th>Offence Description</th><th>Payment Date</th><th>Payment Time</th>");

	for(int i=0;i<ar.size();i++)
	{
		vp =  ar.get(i);
		out.println("<tr><td>"+vp.getViolatorName()+"</td><td>"+vp.getAmount()+"</td><td>"+vp.getOffenceDes()+"</td><td>"+vp.getDate()+"</td><td>"+vp.getTime()+"</td>");
	
	}
	}
	else
	{
		response.sendRedirect("NoFineCollected.html");
	}
%>

    
</body>
</html>