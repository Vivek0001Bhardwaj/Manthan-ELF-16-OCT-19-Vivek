
<%@page import="com.manthan.shoppingapplication.bean.UserBean"%>
<%@page import="com.manthan.shoppingapplication.bean.OrderBean"%>
<%@page import="com.manthan.shoppingapplication.bean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% ArrayList<ProductBean> arPB = (ArrayList<ProductBean>) request.getAttribute("pbList"); %>
<% ArrayList<OrderBean> arOB = (ArrayList<OrderBean>) request.getAttribute("obList"); %>
<% String msg = (String) request.getAttribute("msg"); %>
<% String msgPB = (String) request.getAttribute("msgPB"); %>
<% String msgOB = (String) request.getAttribute("msgOB"); %>
<% UserBean ub = (UserBean) session.getAttribute("userBean"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% if(!msg.equals("User Valid") && !msg.isEmpty()) {%>
	<h2 style="color: red;"><%=msg %></h2><br><br>
	<a href="./RegisterUser.jsp">Register Student link</a>
	<%} 
	else {%>
		<form action="./SearchProductServlet" method="get">
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
			<br>
			<br>
		</table>
		
		<table>
			<tr>
				<td>Search Product</td>
				<td> : </td>
				<td><input type="text" name="searchPrd"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
		</form>
		<br>
		<br>
		<a href="./OrderHistoryServlet">Order History &#128071</a>
	<%} %>
	
	<% if(!msg.equals("Product Details Sent") && !msg.isEmpty()) {%>
		
		<%if(arPB!=null && !arPB.isEmpty()) {%>
			
			<h1 style="color: blue;">Product Details &#128071</h1>
	
			<table style="border: 1px solid; border-collapse: collapse;">
				<tr>
					<th style="border: 1px solid;">Product ID</th>
					<th style="border: 1px solid;">Product Name</th>
					<th style="border: 1px solid;">Product Cost</th>
					<th style="border: 1px solid;">Product Color</th>
					<th style="border: 1px solid;">Description</th>
					<th style="border: 1px solid;">Number of products</th>
					<th style="border: 1px solid;">Buy</th>
				</tr>
				<% for(ProductBean pib : arPB) { %>
					<tr>
						<%int productID = pib.getProductId(); %>
						<td style="border: 1px solid;"><%= productID %></td>
						<td style="border: 1px solid;"><%= pib.getProductName() %></td>
						<td style="border: 1px solid;"><%= pib.getProductCost() %></td>
						<td style="border: 1px solid;"><%= pib.getProductColor() %></td>
						<td style="border: 1px solid;"><%= pib.getDescription() %></td>
						<td style="border: 1px solid;"><%= pib.getNumberOfProducts() %></td>
						<td style="border: 1px solid;"><a href="./OrderProductServlet?prdID=productID">Buy</a>></td>
					</tr>
				<% } %>
			</table>
			
		<%}else {%>
		<h1 style="color: blue;">No Product Present</h1>
		<%}%>
	<%} %>
	
	<% if(!msg.equals("Order History") && !msg.isEmpty()) {%>
		
		<%if(arOB!=null && !arOB.isEmpty()) {%>
			
			<h1 style="color: blue;">Product Details &#128071</h1>
	
			<table style="border: 1px solid; border-collapse: collapse;">
				<tr>
					<th style="border: 1px solid;">Product ID</th>
					<th style="border: 1px solid;">User ID</th>
					<th style="border: 1px solid;">Price</th>
				</tr>
				<% for(OrderBean oib : arOB) { %>
					<tr>
						<td style="border: 1px solid;"><%= oib.getProductId() %></td>
						<td style="border: 1px solid;"><%= oib.getUserId() %></td>
						<td style="border: 1px solid;"><%= oib.getPrice() %></td>
					</tr>
				<% } %>
			</table>
			
		<%} else {%>
			<h1 style="color: blue;">No Order History Present</h1>
		<%}%>
	<%} %>
	
	<% if(!msg.equals("Order Added To Cart") && !msg.isEmpty()) {%>
		<h1 style="color: red;"><%=msg %></h1>
	<%} else {%>
			<h1 style="color: blue;">May Be Out Of Stock</h1>
	<%}%>
	
	<br>
	<br>
	<a href="./LogoutUserServlet">Logout</a>
</body>
</html>