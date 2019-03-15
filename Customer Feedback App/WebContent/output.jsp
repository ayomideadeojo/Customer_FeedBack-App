<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {background-color: dodgerblue;
 font-family: Times New roman;
 padding: 20px;
 border: 20px solid black;
 border-radius: 4px;
 width: 70%; }

</style>
</head>
<body>
	<center><h1>Entries Since the First of the Month :)</h1>
	<c:forEach var="item" items="${feedbackList}">
		<h3> Date:${item.date} Department:${item.department} Feedback:${item.text}</h3>
	</c:forEach></center>
</body>
</html>