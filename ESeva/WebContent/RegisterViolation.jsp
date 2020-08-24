<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register a Violation</title>
<link rel="stylesheet" type="text/css" href="css/homepage.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
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
  <a href="IssueTicket.jsp">Issue a ticket</a>
  <a href="AcceptPayment.jsp">Accept Payment</a> 
  <a href="RegisterEmmergency.html">Register an Emmergency</a> 
  <a href="TrafficInspectorSos.jsp">SOS</a>
  </div> 
  
</div>

<br>


<div class="para">

<h3 style="font-size:32px; border:3px solid black; padding:10px">Register a Violation/Violators</h3>
<p>Please fill in the details below.</p>
</div>

<br>
<form method="post" action="login">
  <div class="mainn">
  <br>
    <label for="vname"><b>Violators Name :</b></label>
    <input type="text" placeholder="Enter name" id="vname" name="vname"></input>
    
    <br>
    <br>   
    
    <label for="vtype"><b>Driving License number :</b></label>
    <input type="text" placeholder="Enter License Number" id="vtype" name="vtype">
    
    <br>
    <br> 
    
    <label for="pov"><b>Place of Violation :</b></label>
    <input type="text" placeholder="Enter Place" id="pov" name="pov">
    
    <br>
    <br>
    
    <label for="vt"><b>Vehicle type :</b></label>
    <input type="text" placeholder="Enter Vehicle Type" id="vt" name="vt">
    
    <br>
    <br> 
    
    <label for="vc"><b>Vehicle colour :</b></label>
    <input type="text" placeholder="Enter Vehicle Colour" id="vc" name="vc">
    
    <br>
    <br> 
    
    <label for="vn"><b>Vehicle number :</b></label>
    <input type="text" placeholder="Enter Vehicle Number" id="vn" name="vn">
    
    <br>
    <br> 
  
	<label for="fa"><b>Fine Amount :</b></label>
    <input type="text" placeholder="Enter Fine Amount" id="fa" name="fa">
    
    <br>
    <br>   
  
   	<label for="od"><b>Offence Description :</b></label>
    <input type="text" placeholder="Enter Discription" id="od" name="od">
    
    <br>
    <br> 
    
    <label for="ro"><b>Repeated Offender :</b></label>
    <input type="radio" id="ro" name="ro" value="Yes">
    <label for="yes">Yes</label>
    <input type="radio" id="ro" name="ro" value="No">
    <label for="no">No</label><br>
    
    <br>
    <br>  
    
   	<button type="submit">Submit</button>
  </div>
  
 
  </form>

</body>
</html>