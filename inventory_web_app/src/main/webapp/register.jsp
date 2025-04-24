<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Register New Users</h2>
	
	<% if(request.getAttribute("failure")!= null) { %>
	<h3><%= request.getAttribute("failure") %></h3>
	<%} %>
	<div class="container">
        <form action="JdbcServlet" method="post">
	        <label>UserName:</label>
	        <input type="text" name="username" placeholder="Enter UserName"><br><br>
	        <label>Email Address:</label>
	        <input type="email" name="email" placeholder="abc@example.com"><br><br>
	        <label>Mobile Number:</label>
	        <input type="text" name="mobile" maxlength="10" placeholder="ex: 1234567890"><br><br>
	        <label>Password:</label>
	        <input type="password" name="password" placeholder="Enter password"><br><br>
	        <button type="submit" name="button" value="register">Register</button>
	        <p>Already Registered? <a href="index.jsp">click here</a> to login.</p>
       	</form>
    </div>
</body>
</html>