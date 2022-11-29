package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Connect;


/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String Fuser = request.getParameter("admin");
		String Fpass = request.getParameter("pass");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			Connection connection = Connect.Database();
			PreparedStatement statement = connection.prepareStatement("select * from admin where uname = ? and pass = ?");
			statement.setString(1, Fuser);
			statement.setString(2, Fpass);
			
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				
				session.setAttribute("admin", rs.getString("uname"));
				dispatcher = request.getRequestDispatcher("list");
			}else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("admin.jsp");
			}
			dispatcher.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	}