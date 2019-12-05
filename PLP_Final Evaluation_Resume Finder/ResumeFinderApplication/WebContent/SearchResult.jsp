<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="SearchResume.jsp"></jsp:include>


<% List<File> fl = (List<File>) request.getAttribute("filesList"); %>
<% List<String> userNames = (List<String>) request.getAttribute("userNames"); %>
<% List<String> userMails = (List<String>) request.getAttribute("userMails"); %>
<% String msg = (String) request.getAttribute("message"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Result</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<% if(msg!=null && !msg.isEmpty()) {%>
	<table border="2px" style="border-collapse: collapse; margin-left: 375px;">
		<tr>
			<th>File Name</th>
			<th>Name</th>
			<th>Email</th>
			<th>Download Link</th>
		</tr>
		<%
			File file = null;
			String un = null;
			String umID = null;
		%>
		<% for(int i=0;i<fl.size();i++) {%>
		<%
			file = fl.get(i);
			un = userNames.get(i);
			umID = userMails.get(i);
		%>
		<tr>
			<td><%= file.getName() %></td>
			<td><%= un %></td>
			<td><%= umID %></td>
			<td><a href="DownloadFileServlet?fileName=<%= file.getName() %>">download</a></td>
		</tr>
		<%} %>
	</table>
	<%} else { %>
	
	<h1 style="color: red; border: 2px solid; border-spacing: 5">No file present with this Entry</h1>
		
	<%}%>
</body>
</html>