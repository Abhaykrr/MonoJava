package com.monocept.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewCityController")
public class NewCityController extends HttpServlet {
	
    public NewCityController() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		Cookie[] cookies = request.getCookies();
		
	
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
		        if (cookie.getName().equals("cityCookie")) {
		           
		            String cookieValue = cookie.getValue();
		            writer.write("<h1>Welcome to "+cookieValue +"</h1>");
//		            response.sendRedirect(cookieValue +"visit.html");
//		            System.out.println("Cookie value: " + cookieValue);
		            
		            break; 
		        }
		    }
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
