<%@page import="java.util.ArrayList"%>
<%@page import="com.manthan.user.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% ArrayList<UserBean> ar = (ArrayList<UserBean>) request.getAttribute("arUb"); %>
<% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Result</title>
</head>
<body>
	
	<% if(!msg.equals("User Valid") && !msg.isEmpty()) {%>
	<h2 style="color: red;"><%=msg %></h2><br><br>
	<a href="./RegisterUser.jsp">Register Student link</a>
	<%} 
	else {%>
	<h1 style="color: blue;">User Data &#128071</h1>
	
	<table style="border: 1px solid; border-collapse: collapse;">
		<tr>
			<th style="border: 1px solid;">User Name</th>
			<th style="border: 1px solid;">Age</th>
			<th style="border: 1px solid;">Gender</th>
		</tr>
		<% for(UserBean eib : ar) { %>
			<tr>
				<td style="border: 1px solid;"><%= eib.getUserName() %></td>
				<td style="border: 1px solid;"><%= eib.getAge() %></td>
				<td style="border: 1px solid;"><%= eib.getGender() %></td>
			</tr>
		<% } %>
		
		<tr>
		</tr>
		<tr>
			<td style="border: 1px solid;" colspan="3"><a href="./LogoutUserServlet">Logout</a></td>
		</tr>
	</table>
	<%} %>
</body>
</html>