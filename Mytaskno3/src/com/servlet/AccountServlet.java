package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.Accountdao;
import com.model.Model;






/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Accountdao accDao;
    
    public void init() {
		accDao = new Accountdao();
	}
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		try {
			switch (action) {
			
			case "/list":
				listShop(request, response);
				break;
			case "/view":
				viewacc(request, response);
				break;
			case "/viewedit":
				viewedit(request, response);
				break;	
			case "/updateacc":
				updateacc(request, response);
				break;	
			case "/delete":
				deleteAcc(request, response);
				break;
			case "/insertpro":
				insertpro(request, response);
				break;
			case "/food":
				listFood(request, response);
				break;
			case "/viewpro":
				viewpro(request, response);
				break;	
			case "/editpro":
				editpro(request, response);
				break;
			case "/updatepro":
				updatepro(request, response);
				break;
			case "/deletepro":
				deletePro(request, response);
				break;
			case "/pl":
				listPL(request, response);
				break;	
			case "/viewpl":
				viewpl(request, response);
				break;	
			case "/calculate":
				Calculate(request, response);
				break;	
			}
			}catch (SQLException ex) {
				throw new ServletException(ex);
			}
			}
			
			private void listShop(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
				List<Model> listShop = accDao.viewList();
				request.setAttribute("listShop", listShop);
				RequestDispatcher dispatcher = request.getRequestDispatcher("admincontrol.jsp");
				dispatcher.forward(request, response);
			}
			
			private void listFood(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
				String product= request.getParameter("product");
				List<Model> listFood = accDao.proList(product);
				request.setAttribute("listFood", listFood);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Listproduct.jsp");
				dispatcher.forward(request, response);
			}
			
			private void Calculate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
				String checked[]= request.getParameterValues("check");
				String a = "";
		    	for(String f: checked) {
					
					a+=f+",";
				}
		    	a = a.substring(0, a.length() -1);
				List<Model> PLlist = accDao.PLList(a);
				request.setAttribute("PLlist", PLlist);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Invoice.jsp");
				dispatcher.forward(request, response);
			}
			
			private void listPL(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
				String product= request.getParameter("product");
				List<Model> listPL = accDao.proList(product);
				request.setAttribute("listPL", listPL);
				RequestDispatcher dispatcher = request.getRequestDispatcher("userpl.jsp");
				dispatcher.forward(request, response);
			}
			
			private void viewacc (HttpServletRequest request, HttpServletResponse response)
					throws SQLException, ServletException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				Model all = accDao.viewacc(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
				request.setAttribute("shop", all);
				dispatcher.forward(request, response);

			}
			
			private void viewpro (HttpServletRequest request, HttpServletResponse response)
					throws SQLException, ServletException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				Model all = accDao.viewpro(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("viewpro.jsp");
				request.setAttribute("shop", all);
				dispatcher.forward(request, response);

			}
			
			private void viewpl (HttpServletRequest request, HttpServletResponse response)
					throws SQLException, ServletException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				Model all = accDao.viewpro(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Viewpl.jsp");
				request.setAttribute("shop", all);
				dispatcher.forward(request, response);

			}
			
			private void editpro (HttpServletRequest request, HttpServletResponse response)
					throws SQLException, ServletException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				Model all = accDao.viewpro(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("editpro.jsp");
				request.setAttribute("shop", all);
				dispatcher.forward(request, response);

			}
			
			private void viewedit (HttpServletRequest request, HttpServletResponse response)
					throws SQLException, ServletException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				Model all = accDao.viewacc(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("editacc.jsp");
				request.setAttribute("shop", all);
				dispatcher.forward(request, response);

			}
			
			private void deleteAcc(HttpServletRequest request, HttpServletResponse response) 
					throws SQLException, IOException {
				int id =  Integer.parseInt(request.getParameter("id"));
				accDao.deleteacc(id);
				response.sendRedirect("list");

			}
			
			private void deletePro(HttpServletRequest request, HttpServletResponse response) 
					throws SQLException, IOException {
				int id =  Integer.parseInt(request.getParameter("id"));
				accDao.deletepro(id);
				response.sendRedirect("product.jsp");

			}
			
			private void insertpro(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
				String name = request.getParameter("name");
				String cost = request.getParameter("cost");
				String product = request.getParameter("product");
				String photo = request.getParameter("photo");
				Model model = new Model(name, cost, product, photo);
				accDao.insertPro(model);
				response.sendRedirect("product.jsp");
			}
			
			private void updatepro (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String cost = request.getParameter("cost");
				String product = request.getParameter("product");
				String photo = request.getParameter("photo");
				Model book = new Model(id, name, cost, product, photo);
				accDao.updatepro(book);
				response.sendRedirect("product.jsp");
			}
			
			private void updateacc (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
				int id = Integer.parseInt(request.getParameter("id"));
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String address = request.getParameter("address");
				String email = request.getParameter("email");
				String uname = request.getParameter("uname");
				String pass = request.getParameter("pass");
				String phone = request.getParameter("phone");
				Model book = new Model(id, fname, lname, address, email, uname, pass, phone);
				accDao.updateacc(book);
				response.sendRedirect("list");
			}

}
