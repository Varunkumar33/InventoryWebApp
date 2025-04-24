package com.tcs.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String button = request.getParameter("button");
		
		Connection con = Helper.getJdbcConnection();
		System.out.println("at servlet");
		
		if("login".equals(button)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			try {
				PreparedStatement psLogin = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
				psLogin.setString(1, username);
				psLogin.setString(2, password);
				ResultSet rs = psLogin.executeQuery();
				if(rs.next()) {
					request.setAttribute("success", rs.getString(1)+ ", Logged In Successfully");
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("failure", "LogIn Failed");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(button.equals("register")) {
			System.out.println("In Register");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String password = request.getParameter("password");
			System.out.println("at register");
			
			
			try {
				PreparedStatement psReg = con.prepareStatement("INSERT INTO users VALUES (?,?,?,?)");
				psReg.setString(1, username);
				psReg.setString(2, email);
				psReg.setString(3, mobile);
				psReg.setString(4, password);
				int result = psReg.executeUpdate();
				if(result > 0) {
					request.setAttribute("success", "Registerd Successfully");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("failure", "Registration Failed");
					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
