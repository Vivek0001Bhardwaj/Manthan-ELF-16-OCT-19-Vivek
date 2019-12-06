<%@page import="com.manthan.shoppingapplication.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% UserBean ub = (UserBean) session.getAttribute("userBean"); %>
<% String msg = (String) request.getAttribute("msg"); %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>
	<% if(msg!=null && !msg.isEmpty()) {%>
	<h1 style="color: red;"><%=msg %></h1>
	<%} %>
	<form name="lf" action="./ForgotPasswordServlet" method="get">
		 
		 <table>
			<tr>
				<td>UserID</td>
				<td>:</td>
				<td><input type="number" name="userId" value="<%= ub.getUserId() %>" disabled="disabled"></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td>:</td>
				<td><input type="text" name="userName" value="<%= ub.getUserName() %>" disabled="disabled"></td>
			</tr>
			<tr>
				<td>New Password</td>
				<td>:</td>
				<td><input type="password" name="password" required="required"></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td>:</td>
				<td><input type="password" name="confPassword" required="required"></td>
			</tr>
			<tr>
				<td><input type="submit" value="SetPwd" required="required"></td>
				<td></td>
				<td><input type="reset" value="Reset" required="required"></td>
			</tr>
		</table>
		 
	</form>
	
</body>
</html>