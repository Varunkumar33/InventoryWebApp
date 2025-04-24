<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<% if(request.getAttribute("success")!= null) { %>
	<h3><%= request.getAttribute("success") %></h3>
	<%} %>
	
	<h1>Welcome To Home Page</h1>
</body>
</html>