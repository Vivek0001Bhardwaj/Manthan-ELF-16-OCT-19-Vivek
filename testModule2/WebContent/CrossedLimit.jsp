<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <% String msg = (String) request.getAttribute("msg"); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Limit Page</title>
</head>
<body>
	<%-- <% if(msg!=null && !msg.isEmpty()) {%>
	<h1 style="color: red;"><%=msg %></h1>
	<%} %> --%>
	
	<h1 style="color: red;">Crossed limit of wrong login, so you are locked for 10 min</h1>
</body>
</html>