package com.monocept.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.monocept.database.DbConnection;
import com.monocept.model.*;

@WebServlet("/AdminNewCustomer")
public class AdminNewCustomer extends HttpServlet {

    public AdminNewCustomer() {
    	
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String firstName = request.getParameter("firstname");
		String lastName  = request.getParameter("lastname");
		String password  = request.getParameter("password");
		
		
//		System.out.println(firstName);
//		System.out.println(lastName);
//		System.out.println(password);
		
		
		DbConnection database = DbConnection.getConnection();
		database.connect();
		
		boolean status = database.addNewCustomer(firstName, lastName, password);
		
		
		List<Customer> allCustomersWithAccount = database.getAllCustomersWithAccount();
		List<Customer> allCustomers = database.getAllCustomers();
		List<Transaction> allPassbook = database.getAllPassbook();
		
		
		session.setAttribute("allCustomersWithAccount", allCustomersWithAccount);
		session.setAttribute("allCustomers", allCustomers);
		session.setAttribute("allPassbook", allPassbook);
		
//		response.sendRedirect("admin_home.jsp");
		if(status==true)
		response.sendRedirect("admin_home.jsp?jsMethod=true&warning=Congratulations!..&detail=New Customer Created&status=success");
		
		
//		request.setAttribute("allCustomersWithAccount", allCustomersWithAccount);
//		request.setAttribute("allCustomers", allCustomers);
//		request.setAttribute("allPassbook", allPassbook);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("admin_home.jsp");
//		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
