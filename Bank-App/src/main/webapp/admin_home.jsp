<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>   
<%@ page import="com.monocept.model.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="common.css" /> 

<title>Admin Home</title>

</head>
<body>
<h3>Welcome Admin  <%= request.getSession(false).getAttribute("firstname") %> &nbsp;&nbsp; <a href="http://localhost:8080/Bank-App/login.jsp" class="btn btn-danger">Logout</a>
 </h3><br><br>

  <div class="container1">
    <div class="tabs">
        <h3 id="tab-1" onclick="showTab(1)" class="active">Add New Customer</h3>
        <h3 id="tab-4" onclick="showTab(4)">Add Bank Account</h3>
        <h3 id="tab-2" onclick="showTab(2)">View Customers</h3>
        <h3 id="tab-3" onclick="showTab(3)">View Transactions</h3>
    </div>

    <div class="tab-content">

        <div id="content-1" class="show">

      
            <form action="AdminNewCustomer" method="post" class="form-box">
                <div class="form-group">
                  <label for="firstName2">First Name</label>
                  <input name="firstname" type="text" class="form-control" id="firstName2" placeholder="Enter your first name" pattern="^[a-zA-Z]+$" required>
                  <div class="invalid-feedback">
				      Please enter a valid First Name without numbers.
				    </div>
                </div>
                <div class="form-group">
                  <label for="lastName2">Last Name</label>
                  <input name="lastname" type="text" class="form-control" id="lastName2" placeholder="Enter your last name" pattern="^[a-zA-Z]+$" required>
                </div>
                <div class="form-group">
                  <label for="password2">Password</label>
                  <input name="password" type="password" class="form-control" id="password2" placeholder="Enter your password" required>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            
            

          </div>

          <div id="content-4" class="hide">

            <form action="AdminNewCustomerAccount" method="post" class="form-box">

              <div class="form-group">
                <label for="dropdown">Select an customer :</label>
                <select name="customerid" class="form-control" id="dropdown" required>
                   <option value="" selected disabled>Select Customer...</option>
                  <%
					List<Customer> allCustomers1 = (List<Customer>)  request.getSession(false).getAttribute("allCustomers");
					for (Customer customerLine : allCustomers1) {
						out.println("<option value=\"" + customerLine.getCustomerId() + "\">Name: " + customerLine.getFirstName() + "</option>");

					    
					}
					
					%> 
                </select>
              </div>

              <div class="form-group">
                <label for="lastName2">Enter Amount</label>
                <input name="balance" type="text" class="form-control" id="lastName2" placeholder="Enter Amount" required pattern="^[0-9]+$">
              </div>
              <button type="submit" class="btn btn-primary">Submit</button>
            </form>

          
          </div>

        <div id="content-2" class="hide demo">
            <h3 class="text-center">Existing Customers</h3>

			<%
    int cusCurrentPage = 1; // Default current page number
    int cusPageSize = 5 ; // Number of records to display per page

    List<Customer> cusAllCustomers = (List<Customer>) request.getSession(false).getAttribute("allCustomersWithAccount");

    // Get the total number of records and calculate the total number of pages
    int cusTotalRecords = cusAllCustomers.size();
    int cusTotalPages = (int) Math.ceil((double) cusTotalRecords / cusPageSize);

    String cusRequestedPage = request.getParameter("page");
    if (cusRequestedPage != null) {
        cusCurrentPage = Integer.parseInt(cusRequestedPage);
        // Validate the current page number to ensure it is within the range
        if (cusCurrentPage < 1) {
            cusCurrentPage = 1;
        } else if (cusCurrentPage > cusTotalPages) {
            cusCurrentPage = cusTotalPages;
        }
    }

    // Calculate the starting index and ending index of the records to display on the current page
    int cusStartIndex = (cusCurrentPage - 1) * cusPageSize;
    int cusEndIndex = Math.min(cusStartIndex + cusPageSize, cusTotalRecords);

    List<Customer> cusCustomersPerPage = cusAllCustomers.subList(cusStartIndex, cusEndIndex);
%>

<table class="table table-bordered">
    <thead>
        <tr>
            <th>Serial No</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Account Number</th>
            <th>Balance</th>
        </tr>
    </thead>
    <tbody>
        <% int cusIndex = (cusCurrentPage - 1) * cusPageSize + 1; // Start index for the current page %>
        <% for (Customer cusCustomerLine : cusCustomersPerPage) { %>
        <tr>
            <td><%= cusIndex++ %></td>
            <td><%= cusCustomerLine.getFirstName() %></td>
            <td><%= cusCustomerLine.getLastName() %></td>
            <td><%= cusCustomerLine.getAccountNo() %></td>
            <td>RS <%= cusCustomerLine.getBalance() %></td>
        </tr>
        <% } %>
    </tbody>
</table>

<!-- Pagination links -->
<div class="pagination">
    <ul class="pagination-list">
        <% if (cusCurrentPage > 1) { %>
        <li class="pagination-item">
            <a class="pagination-link" href="?page=1&tab=2">First</a>
        </li>
        <li class="pagination-item">
            <a class="pagination-link" href="?page=<%= cusCurrentPage - 1 %>&tab=2">Previous</a>
        </li>
        <% } %>


        <% if (cusCurrentPage < cusTotalPages) { %>
        <li class="pagination-item">
            <a class="pagination-link" href="?page=<%= cusCurrentPage + 1 %>&tab=2">Next</a>
        </li>
        <li class="pagination-item">
            <a class="pagination-link" href="?page=<%= cusTotalPages %>&tab=2">Last</a>
        </li>
        <% } %>
    </ul>
</div>
			

            <%--<table class="table table-bordered">
                <thead>
                    <tr>
                    <th>Serial No</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Account Number</th>
                    <th>Balance</th>
                    </tr>
                </thead>
                <tbody>
                    
                    
                  <%
					int index = 1;
					List<Customer> allCustomers = (List<Customer>)  request.getSession(false).getAttribute("allCustomersWithAccount");
					for (Customer customerLine : allCustomers) {
					        out.println("<tr>"+
					        		"<td>"+(index++) +"</td>"+
			                        "<td>"+ customerLine.getFirstName() +"</td>"+
			                        "<td>"+customerLine.getLastName() +"</td>"+
			                        "<td>"+customerLine.getAccountNo()+"</td>"+
			                        "<td>RS "+customerLine.getBalance()+"</td>"+
			                        "</tr>");
					    
					}
					
					%> 
                </tbody>
                </table>--%>


        </div>  

        <div id="content-3" class="hide">
            <h3 class="text-center">Transactions</h3>
            
             <div style="display: flex; justify-content: center;">
							  <label  for="start-date" style="margin-right: 10px;">Start Date:</label>
							  <input type="date" id="start" name="start-date" style="margin-right: 20px;" 
							         format="yyyy-MM-dd">
							  <label for="end-date" style="margin-right: 10px;">End Date:</label>
							  <input type="date" id="end" name="end-date" format="yyyy-MM-dd">
							</div>

		
					
					<button onclick="applyFilter()">Apply Filter</button>
            
            <%
    int currentPage = 1; // Default current page number
    int pageSize = 5; // Number of records to display per page

    List<Transaction> transactions = (List<Transaction>) request.getSession(false).getAttribute("allPassbook");
    
    // Get the total number of records and calculate the total number of pages
    int totalRecords = transactions.size();
    int totalPages = (int) Math.ceil((double) totalRecords / pageSize);

    // Check if the current page number is specified in the request, otherwise set it to the first page
    String requestedPage = request.getParameter("page");
    if (requestedPage != null) {
        currentPage = Integer.parseInt(requestedPage);
        // Validate the current page number to ensure it is within the range
        if (currentPage < 1) {
            currentPage = 1;
        } else if (currentPage > totalPages) {
            currentPage = totalPages;
        }
    }

    // Calculate the starting index and ending index of the records to display on the current page
    int startIndex = (currentPage - 1) * pageSize;
    int endIndex = Math.min(startIndex + pageSize, totalRecords);

    // Get the subset of records for the current page
    List<Transaction> currentPageTransactions = transactions.subList(startIndex, endIndex);
%>

<table class="table table-bordered">
    <thead>
        <tr>
            <th>Transaction Id</th>
            <th>Customer Id</th>
            <th>Sender Account No</th>
            <th>Receiver Account No</th>
            <th>Type of Transaction</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Status</th>
        </tr>
    </thead>
    <tbody>
    
	                         
        <% for (Transaction transaction : currentPageTransactions) { 
        	
					 out.println("<tr>"+
		        			 "<td>"+transaction.getId()+"</td>"+
		        			 "<td>"+transaction.getCustomerId()+"</td>"+
		                     "<td>"+transaction.getSenderAccountNo()+"</td>"+
		                     "<td>"+transaction.getReceiverAccountNo()+"</td>"+
		                     "<td>"+transaction.getType()+"</td>"+
		                     "<td>"+transaction.getAmount()+"</td>"+
		                     "<td>"+transaction.getDate()+"</td>"+
		                     "<td>"+transaction.getStatus()+"</td>"+
		                     "</tr>");
				
         }%>
    </tbody>
</table>

<!-- Pagination links -->
<div class="pagination">
    <ul class="pagination-list">
        <% if (currentPage > 1) { %>
        <li class="pagination-item">
            <a class="pagination-link" href="?page=1&tab=3">First</a>
        </li>
        <li class="pagination-item">
            <a class="pagination-link" href="?page=<%= currentPage - 1 %>&tab=3">Previous</a>
        </li>
        <% } %>

        <% if (currentPage < totalPages) { %>
        <li class="pagination-item">
            <a class="pagination-link" href="?page=<%= currentPage + 1 %>&tab=3">Next</a>
        </li>
        <li class="pagination-item">
            <a class="pagination-link" href="?page=<%= totalPages %>&tab=3">Last</a>
        </li>
        <% } %>
    </ul>
</div>

            
            
            
          <%--  <table class="table table-bordered">
                <thead>
                    <tr>
                    <th>Transaction Id</th>
                    <th>Customer Id</th>
                    <th>Sender Account No</th>
                    <th>Receiver Account No</th>
                    <th>Type of Transaction</th>
                    <th>Amount</th>
                    <th>Date</th>
                    <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                 
                    
                     <%
                     
						List<Transaction> allPassbook = (List<Transaction>)  request.getSession(false).getAttribute("allPassbook");
						for (Transaction passLine : allPassbook) {
						        out.println("<tr>"+
				                        "<td>"+ passLine.getId() +"</td>"+
				                        "<td>"+passLine.getCustomerId() +"</td>"+
				                        "<td>"+passLine.getSenderAccountNo()+"</td>"+
				                        "<td>"+passLine.getReceiverAccountNo()+"</td>"+
				                        "<td>"+passLine.getType()+"</td>"+
				                        "<td>"+passLine.getAmount()+"</td>"+
				                        "<td>"+passLine.getDate()+"</td>"+
				                        "<td>"+passLine.getStatus()+"</td>"+
				                        "</tr>");
						    
						}
					
					%> 
                   
                </tbody>
                </table>--%>
          </div>
    </div>
  </div>

  <script>
    function showTab(tabNumber){
        document.getElementsByClassName('show')[0].classList.add('hide');
        document.getElementsByClassName('show')[0].classList.remove('show');
        document.getElementById('content-'+ tabNumber).classList.add('show');
        document.getElementById('content-'+ tabNumber).classList.remove('hide');
        document.getElementsByClassName('active')[0].classList.remove('active');
        document.getElementById('tab-'+ tabNumber).classList.add('active');

    }
    
    var tab = '<%= request.getParameter("tab")%>'
    
    if(tab === '3')
    	showTab(3);
    
    if(tab === '2')
    	showTab(2);
    
    
    
    var jsMethod = '<%= request.getParameter("jsMethod") %>';
    var warning = '<%= request.getParameter("warning") %>';
    var detail = '<%= request.getParameter("detail") %>';
    var status = '<%= request.getParameter("status") %>';
   
    
    console.log(jsMethod);
   
    
    if (jsMethod === 'true') {
   
 	   swal(warning, detail, status);
 	   
 	   setTimeout(function() {
 		      var url = location.href.split('?')[0]; 
 		      location.href = url;
 		    }, 2000);
    }
    
    (function () {
 	   'use strict'

 	   // Fetch all the forms we want to apply custom Bootstrap validation styles to
 	   var forms = document.querySelectorAll('.needs-validation')

 	   // Loop over them and prevent submission
 	   Array.prototype.slice.call(forms)
 	     .forEach(function (form) {
 	       form.addEventListener('submit', function (event) {
 	         if (!form.checkValidity()) {
 	           event.preventDefault()
 	           event.stopPropagation()
 	         }

 	         form.classList.add('was-validated')
 	       }, false)
 	     })
 	 })()
 	 
 	  function applyFilter() {
    	 const startDate = document.getElementById("start").value;
    	 alert(startDate);
    	    const endDate = document.getElementById("end").value;
    	    const url = window.location.href + '?start-date=' + startDate + '&end-date=' + endDate + '&tab=3';
			 window.location.href = url;
    }
  </script>
  
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>