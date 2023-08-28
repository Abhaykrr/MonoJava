package com.monocept.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CityController")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CityController() {
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		PrintWriter writer = response.getWriter();
		String city = request.getParameter("city");
		
		Cookie cookie = new Cookie("cityCookie", city);
		cookie.setMaxAge(3600); 
		cookie.setPath("/"); 
		response.addCookie(cookie);
		
		writer.write("<h1>"+city+"</h1> \r\n"
				+ "\r\n"
				+ " <form action=\"NewCityController\" method=\"post\">\r\n"
				+ "      \r\n"
				+ "      \r\n"
				+ "      <div class=\"text-center\">\r\n"
				+ "      <button type=\"submit\" class=\"btn btn-primary align-center\">Visit</button>\r\n"
				+ "      </div>\r\n"
				+ "      \r\n"
				+ "      \r\n"
				+ "    </form>");
		
		
//		response.sendRedirect(city +".html");
		
		
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
