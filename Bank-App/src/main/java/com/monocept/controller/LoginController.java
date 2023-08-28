package com.monocept.controller;

import java.io.IOException;
import java.time.LocalDate;
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

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    public LoginController() {
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String firstname = request.getParameter("username");
		String password = request.getParameter("password");
		String role     = request.getParameter("role");
		
		System.out.println(firstname);
		System.out.println(password);
		System.out.println(role);
		
		DbConnection database = DbConnection.getConnection();
		database.connect();
		
		HttpSession session = request.getSession();
		
		if(role.equals("user")) {
			Customer customer = database.checkCustomer(firstname, password);
			
			if(customer.getCustomerId() == null) {
				response.sendRedirect("login.jsp?jsMethod=true");
			}else {
				session.setAttribute("id",customer.getCustomerId());
				session.setAttribute("firstname",firstname);
				session.setAttribute("lastname",customer.getLastName());
				session.setAttribute("password",password);
				session.setAttribute("role",role);
				
				List<Account> customerAccounts = database.getParticualarCustomerAccountDetails(customer.getCustomerId());
				List<Account> allCustomerAccounts = database.getAllCustomerAccountDetails();
				List<Transaction> customerPassbook = database.getPassbook(customer.getCustomerId());
				
				System.out.println(customerAccounts);
				System.out.println(allCustomerAccounts);
				System.out.println(customerPassbook);
				
				session.setAttribute("customerAccounts", customerAccounts);
				session.setAttribute("allCustomerAccounts", allCustomerAccounts);
				session.setAttribute("customerPassbook", customerPassbook);
				
				response.sendRedirect("customer_home.jsp");
				
//				request.setAttribute("customerAccounts", customerAccounts);
//				request.setAttribute("allCustomerAccounts", allCustomerAccounts);
//				request.setAttribute("customerPassbook", customerPassbook);
//				
//				RequestDispatcher dispatcher = request.getRequestDispatcher("customer_home.jsp");
//				dispatcher.forward(request, response);
			}
		}
		
		if(role.equals("admin")) {
			String data[] = database.checkAdmin(firstname, password);
			
			if(data[0].equals("false")) {
				response.sendRedirect("login.jsp?jsMethod=true");
			}else {
				session.setAttribute("id",Integer.parseInt(data[0]));
				session.setAttribute("firstname",firstname);
				session.setAttribute("role",role);
				
				List<Customer> allCustomersWithAccount = database.getAllCustomersWithAccount();
				List<Customer> allCustomers = database.getAllCustomers();
				List<Transaction> allPassbook =  database.getAllPassbook();
				
				session.setAttribute("allCustomersWithAccount", allCustomersWithAccount);
				session.setAttribute("allCustomers", allCustomers);
				session.setAttribute("allPassbook", allPassbook);
				
				response.sendRedirect("admin_home.jsp");
				
//				
//				request.setAttribute("allCustomersWithAccount", allCustomersWithAccount);
//				request.setAttribute("allCustomers", allCustomers);
//				request.setAttribute("allPassbook", allPassbook);
//				
//				
//				RequestDispatcher dispatcher = request.getRequestDispatcher("admin_home.jsp");
//				dispatcher.forward(request, response);
			}
		}
		
		
		System.out.println("--session details---");
		System.out.println(session.getAttribute("id"));
		System.out.println(session.getAttribute("firstname"));
		System.out.println(session.getAttribute("role"));
		System.out.println("---------------------");
		
		 LocalDate date = LocalDate.now();
		 
		 System.out.println(java.sql.Date.valueOf(date));

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
