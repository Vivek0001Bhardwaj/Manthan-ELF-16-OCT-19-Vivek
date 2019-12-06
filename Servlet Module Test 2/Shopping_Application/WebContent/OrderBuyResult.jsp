<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% String msg = (String) request.getAttribute("msg"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% if(msg!=null && !msg.isEmpty()) {%>
	<h1 style="color: red;"><%=msg %></h1>
	<%} %>
	
	<a href="./LogoutUserServlet">Logout</a>
</body>
</html>