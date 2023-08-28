<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> 
<title>DashBoard</title>
</head>
<body>

<%@ page import="javax.servlet.http.HttpSession" %>

<%
  HttpSession session1 = request.getSession(false); // Get the session without creating a new one if it doesn't exist

  if (session1 == null || session1.getAttribute("username") == null) {
      System.out.println("Dash.jsp ss id :" +session1.getId());
     
      response.sendRedirect("exit.html");
      
  } else {
	  System.out.println(session1.getAttribute("username"));
  }
      // If the user is authenticated, proceed with rendering the dashboard content
%>

	 <div class="container mt-5">
      <div class="row">
       <div class="col-md-12 d-flex justify-content-center">
       
              <h1>Welcome <%= session1.getAttribute("username") %></h1>
             
       	
        </div>
         <form action="Logout" method="get">
  				<button value="submit" type="button submit" class="btn btn-primary btn-block mb-4">log out </button>
	
			</form>
       </div>
       </div>

</body>
</html>