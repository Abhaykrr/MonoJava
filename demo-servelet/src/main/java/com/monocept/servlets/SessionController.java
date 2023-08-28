package com.monocept.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionController")
public class SessionController extends HttpServlet {

    public SessionController() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("username", uname);
		
			
		System.out.println("java file session id" +session.getId());
		response.sendRedirect("dashboard.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
