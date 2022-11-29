package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Connect;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String firstname = request.getParameter("first");
		String lastname = request.getParameter("last");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		
		RequestDispatcher dispatcher = null;
		Connection connection = null;
		
		try {
			connection = Connect.Database();
			PreparedStatement statement = connection.prepareStatement("insert into shop (fname, lname, address, email, uname, pass, phone) values(?,?,?,?,?,?,?)");
			statement.setString(1, firstname);
			statement.setString(2, lastname);
			statement.setString(3, address);
			statement.setString(4, email);
			statement.setString(5, username);
			statement.setString(6, password);
			statement.setString(7, phone);
			
			int rowCount = statement.executeUpdate();
			dispatcher = request.getRequestDispatcher("register.jsp");
			
			if (rowCount > 0) {
				request.setAttribute("status", "success");
				
			}else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}
		
	}


