package com.monocept.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.monocept.database.DbConnection;


@WebServlet("/CustomerEditProfile")
public class CustomerEditProfile extends HttpServlet {

    public CustomerEditProfile() {
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String customerid = (String)session.getAttribute("id");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(password);
		
		DbConnection database = DbConnection.getConnection();
		database.connect();
		boolean status = database.editCustomer(firstname, lastname, password, customerid);
		
		response.sendRedirect("login.jsp");
		//response.sendRedirect("customer_home.jsp?jsMethod=true&warning=Congratulations!..&detail=Profile Update Successfull&status=success");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
