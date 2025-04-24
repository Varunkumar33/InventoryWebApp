<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn</title>
</head>
<body>
	<h1>Login Page</h1>
	
	<% if(request.getAttribute("success")!= null) { %>
	<h3><%= request.getAttribute("success") %></h3>
	<%} %>
	<% if(request.getAttribute("failure")!= null) { %>
	<h3><%= request.getAttribute("failure") %></h3>
	<%} %>
	
	<div class="container">
        <form action="JdbcServlet" method="post">
	        <label>UserName:</label>
	        <input type="text" name="username"><br><br>
	        <label>Password:</label>
	        <input type="password" name="password"><br><br>
	        <button type="submit" name="button" value="login">Submit</button>
	        <p>new users? <a href="register.jsp">click here</a> to Register.</p>
	    </form>
    </div>
</body>
</html>
