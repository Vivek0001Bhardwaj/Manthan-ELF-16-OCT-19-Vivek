<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<% String msg = (String) request.getAttribute("msg"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Resume</title>
<base>

<link rel="stylesheet" href="./All.css">

</head>
<body>
	<div class="topnav">
		<h1>RESUME FINDER</h1>
	</div>
	<a href="./searchResumeJsp">Search Resume</a>
	<br>
	<br>
	<form action="./UploadResumeServlet" method="post" enctype="multipart/form-data">
		<h1>Upload Resume</h1>
		<br> <input type="file" name="file" value="Upload">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Upload">
	</form>
	<br>
	<br>
	<br>
	<br>

	<% if(msg!=null && !msg.isEmpty()) {%>
	<h1 style="color: red; border: 2px solid; border-spacing: 5"><%=msg %></h1>
	<%} %>
</body>
</html>