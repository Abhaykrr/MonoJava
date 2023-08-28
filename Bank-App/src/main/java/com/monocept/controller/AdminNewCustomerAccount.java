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

@WebServlet("/AdminNewCustomerAccount")
public class AdminNewCustomerAccount extends HttpServlet {

    public AdminNewCustomerAccount() {
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String customerid = request.getParameter("customerid");
		String balance    = request.getParameter("balance");
		
		if(Integer.parseInt(balance)<5000) {
			response.sendRedirect("admin_home.jsp?jsMethod=true&warning=Warning!..&detail=Customer Balance Less than 5000&status=error");
			return;
		}
		
//		System.out.println(customerid);
//		System.out.println(balance);
		
		DbConnection database = DbConnection.getConnection();
		database.connect();
		String generated = database.createAccount(customerid, balance);
		
		List<Customer> allCustomersWithAccount = database.getAllCustomersWithAccount();
		List<Customer> allCustomers = database.getAllCustomers();
		List<Transaction> allPassbook = database.getAllPassbook();
		
		session.setAttribute("allCustomersWithAccount", allCustomersWithAccount);
		session.setAttribute("allCustomers", allCustomers);
		session.setAttribute("allPassbook", allPassbook);
		
//		response.sendRedirect("admin_home.jsp");
		if(!generated.equals("null"))
		response.sendRedirect("admin_home.jsp?jsMethod=true&warning=Congratulations!..&detail=New Customer Account:("+generated +") Created&status=success");
		
		
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
