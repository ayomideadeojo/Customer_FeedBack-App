<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.time.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
body {background-color: dodgerblue;
 font-family: Times New roman;
 padding: 20px;
 border: 20px Orange;
 border-radius: 4px;
 width: 25%; }

</style>
</head>
<h1 style='color:white; background-color:orange;text-align:center'><br>Department FeedBack</h1>
<body><center>
	<form method="post" action="ControllerServlet">
	    <label>Department List</label>
	      <select name="department">
    <option value="Customer Service">Customer Service</option>
    <option value="Billing">Billing</option>
    <option value="Sales">Sales</option>
    <option value="Technical Support">Technical Support</option>
  </select>
   <h1>Feedback</h1> <input name="feedback" type="text">
        
       <input type="submit" value="Go!" /></form></center>
</body>
</body>
</html>