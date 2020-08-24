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
<title>Issue Ticket</title>
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
  <a href="RegisterViolation.html">Register a Traffic Violation/Violators</a>
  <a href="AcceptPayment.jsp">Accept Payment</a> 
  <a href="RegisterEmmergency.html">Register an Emmergency</a> 
  <a href="TrafficInspectorSos.jsp">SOS</a>
  </div> 
  
</div>
<div class="para">

<h3 style="font-size:32px; border:3px solid black; padding:10px">Issue a Ticket</h3>
<p>Please button to issue ticket.</p>
</div>

<form>
  <div class="mainn2">  
  <button onclick="AfterIssue.html">Issue Ticket</button>
  </div>
 </form>
<br><br><br><br><br><br>

<div class="para">
<p>E-Challan</p>
</div>
<%
	String cid = request.getParameter("cid");
	ViolatorPojo vp = PaymentDao.getDetailsOfChallan(cid);
	
	if(PaymentDao.check1 == true)
	{
	out.println("<html> <head> <style ='text/css'>table{background-color:white; border-spacing:5px; border:3px solid black; font-size:18px; padding:3px; margin:20px;} th,td{padding:5px;}</style></head>");		
	out.println("<body>");
	
	out.println("<table id='aaaa'>");
	out.println("<tr><th>Challan Id</th><th>Violator Name</th><th>Vehicle Type</th><th>Vehicle Number</th><th>Place Of Violation</th><th>Offence Description</th><th>Date</th><th>Time</th><th>Fine Amount</th>");
	
	out.println("<tr><td>"+vp.getCid()+"</td><td>"+vp.getViolatorName()+"</td><td>"+vp.getVehicleType()+"</td><td>"+vp.getVehicleNo()+"</td><td>"+vp.getPlaceOfViolation()+"</td><td>"+vp.getOffenceDes()+"</td><td>"+vp.getDate()+"</td><td>"+vp.getTime()+"</td><td>"+vp.getAmount()+"</td>");
	
	out.println("</body></html>");
	}
	else
	{
		response.sendRedirect("IssueTicketError.jsp");
	}
%>

    
</body>
</html>