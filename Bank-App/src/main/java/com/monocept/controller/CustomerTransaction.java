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
import com.monocept.model.Account;
import com.monocept.model.Transaction;


@WebServlet("/CustomerTransaction")
public class CustomerTransaction extends HttpServlet {
	
    public CustomerTransaction() {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String customerid = (String)session.getAttribute("id");
		String senderaccno = request.getParameter("senderaccno");
		
		
		String receiver = request.getParameter("receiver");
		
		
		
		
		String type        = request.getParameter("type");
		String amount  = request.getParameter("amount");
		
//		System.out.println("receiver id"+receivercustomerid);
//		System.out.println("receiver acc no :"+receiveraccno);
//		System.out.println(customerid);
//		System.out.println(senderaccno);
//		System.out.println(type);
//		System.out.println(amount);
		
		DbConnection database = DbConnection.getConnection();
		database.connect();
		
		boolean status = false;
		
		if(type.equals("credit")) {
			System.out.println("Crediting ...");
			status = database.credit(customerid, senderaccno, amount);
		}
		
		if(type.equals("debit")) {
			System.out.println("Debiting ...");
			status = database.debit(customerid, senderaccno, amount);
		}
		
		if(type.equals("transfer")) {
			String [] parts = receiver.split(" ");
			
			String receivercustomerid = parts[0];
			String receiveraccno = parts[1];
			System.out.println("Transfering ...");
			status = database.transfer(customerid, senderaccno, amount ,receiveraccno ,receivercustomerid );
		}
		
		
		List<Account> customerAccounts = database.getParticualarCustomerAccountDetails(customerid);
		List<Account> allCustomerAccounts = database.getAllCustomerAccountDetails();
		List<Transaction> customerPassbook = database.getPassbook(customerid);
		
		
		session.setAttribute("customerAccounts", customerAccounts);
		session.setAttribute("allCustomerAccounts", allCustomerAccounts);
		session.setAttribute("customerPassbook", customerPassbook);
		
		if(status == false)
			response.sendRedirect("customer_home.jsp?jsMethod=true&warning=OOPS!..&detail=" + type.toUpperCase() + " Failed&status=error");
		else
			response.sendRedirect("customer_home.jsp?jsMethod=true&warning=Congratulations!..&detail=" + type.toUpperCase() + " Successfull&status=success");
		
		
//		request.setAttribute("customerAccounts", customerAccounts);
//		request.setAttribute("allCustomerAccounts", allCustomerAccounts);
//		request.setAttribute("customerPassbook", customerPassbook);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("customer_home.jsp");
//		dispatcher.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
