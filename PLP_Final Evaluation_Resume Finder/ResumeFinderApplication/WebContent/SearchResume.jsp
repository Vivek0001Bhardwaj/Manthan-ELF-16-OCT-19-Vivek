<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Resume</title>

<link rel="stylesheet" href="./All.css">

</head>
<body>
	<div class="topnav">
		<h1>RESUME FINDER</h1>
	</div>
	<a href="./uploadResumeJsp">Upload Resume</a>
	<br>
	<br>
	<br>
	<br>
	<form action="./SearchResumeServlet" method="post">
		<h1>Search Resume</h1>
		<br> <input type="text" name="searchText" required="required">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Search">
	</form>
	<br>
	<br>
	<br>
	<br>
</body>
</html>