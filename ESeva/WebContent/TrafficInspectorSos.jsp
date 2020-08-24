<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.io.IOException"%>
<%@ page import ="java.io.PrintWriter"%>
<%@ page import ="ESeva.pojo.SargentPojo"%>
<%@ page import ="ESeva.dbutil.DBConnection"%>
<%@ page import ="ESeva.dao.RegisterViolationDao"%>
<%@ page import ="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Traffic Inspector</title>
<link rel="stylesheet" type="text/css" href="css/homepage.css">

<script type="text/javascript">

function welcome()
{
	alert("Emergency has been registered. Backup team is on its way !");
}
</script>

</head>
<body onload="welcome()">

<div><p></p></div>

<div>
	<div class="Space">
  <a href="home.html"><img class="pho" src ="images/TrafficPolice.png"></a>
  </div>
  
  <div class="navi">
  <p></p>
  <a href="home.html">Home</a>
  <a href="RegisterViolation.html">Register a Traffic Violation/Violators</a>
  <a href="IssueTicket.jsp">Issue a ticket</a>
  <a href="AcceptPayment.jsp">Accept Payment</a>
  <a href="RegisterEmmergency.html">Register an Emmergency</a>
  <a href="TrafficInspectorSos.jsp">SOS</a>
  </div> 
  
</div>

<div><p></p></div>

<%
	HttpSession ses = request.getSession();

	String name = (String)ses.getAttribute("name");
	String password = (String)ses.getAttribute("passwd");
	String sid = (String)ses.getAttribute("sid");
	String location = (String)ses.getAttribute("workLoc");

	SargentPojo sp = new SargentPojo();
	sp.setSid(sid);
	sp.setUsername(name);
	sp.setWorkLocation(location);
	
	try
	{
	RegisterViolationDao.registerSos(sp);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	

%>

</body>
</html>