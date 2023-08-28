package com.monocept.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.write("<body>\r\n"
				+ "    <h1>Welcome to Servlets</h1>\r\n"
				+ "    <h2>My name is Abhay Kumar</h2>\r\n"
				+ "    <p>Im from patna bihar</p>\r\n"
				+ "\r\n"
				+ "    Locations in bihar\r\n"
				+ "    <ul>\r\n"
				+ "        <li>Patna</li>\r\n"
				+ "        <li>Gaya</li>\r\n"
				+ "        <li>Buxar</li>\r\n"
				+ "    </ul>\r\n"
				+ "</body>");
		
		writer.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
