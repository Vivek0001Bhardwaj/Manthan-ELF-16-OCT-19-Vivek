<%@page import="com.manthan.shoppingapplication.bean.UserBean"%>
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

	<form name="lf" action="./LoginUserServlet" method="get">

		<table>
			<tr>
				<td>Email</td>
				<td>:</td>
				<td><input type="email" name="email" required="required"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="password" name="password" required="required"></td>
			</tr>
			<tr>
				<td><a href="./ForgotPassword.jsp">Forgot Password link</a></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" required="required"></td>
				<td></td>
				<td><input type="reset" value="Reset" required="required"></td>
			</tr>
		</table>

	</form>

</body>
</html>