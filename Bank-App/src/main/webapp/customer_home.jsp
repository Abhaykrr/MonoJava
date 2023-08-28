<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>   
<%@ page import="com.monocept.model.*" %> 
<%@ page import="java.text.SimpleDateFormat" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="common.css" /> 
<title>Customer Home</title>

</head>
<body>

<h3>Welcome User <%= request.getSession(false).getAttribute("firstname") %> &nbsp;&nbsp; <a href="http://localhost:8080/Bank-App/login.jsp" class="btn btn-danger">Logout</a> </h3><br><br>

  <div class="container1">
    <div class="tabsc">
        <h3 id="tab-1" onclick="showTab(1)" class="active">Edit Profile</h3>
        <h3 id="tab-2" onclick="showTab(2)">New Transaction</h3>
        <h3 id="tab-3" onclick="showTab(3)">Passbook</h3>
    </div>

    <div class="tab-content">

        <div id="content-1" class="show">	
				
      
            <form action="CustomerEditProfile" method="post" class="form-box">
                <div class="form-group">
                  <label for="firstName2">First Name</label>
                  <input name="firstname" type="text" class="form-control" id="firstName2" value="<%= request.getSession(false).getAttribute("firstname") %>"  pattern="^[a-zA-Z]+$" required>
                </div>
                <div class="form-group">
                  <label for="lastName2">Last Name</label>
                  <input name="lastname" type="text" class="form-control" id="lastName2" value="<%= request.getSession(false).getAttribute("lastname") %>"  pattern="^[a-zA-Z]+$" required>
                </div>
                <div class="form-group">
                  <label for="password2">Password</label>
                  <input name="password" type="text" class="form-control" id="password2" value="<%= request.getSession(false).getAttribute("password") %>" required>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

          </div>

          

          <div id="content-2" class="hide">

            <form action="CustomerTransaction" method="post" class="form-box" onsubmit="return validateForm()">

              <div class="form-group">
                <label for="dropdown">From :</label>
                <select name="senderaccno" class="form-control" id="sender" required>
                 <option value="" selected disabled>Select Your Account No.</option>
                  <%
                  List<Account> customerAccounts = (List<Account>) request.getSession(false).getAttribute("customerAccounts");
					for (Account customerLine : customerAccounts) {
						out.println("<option value=\"" + customerLine.getAccountNo() + "\">Account No : "+customerLine.getAccountNo() +" | Balance :	 " + customerLine.getBalance() + "</option>");

					    
					}
                  %>
                 
                </select>
              </div>
              
               <div class="form-group">
                <label for="dropdown">Transaction Type: :</label>
                <select name="type" class="form-control" id="dropdown">
                  <option value="credit">Credit</option>
                  <option value="debit">Debit</option>
                  <option value="transfer">Transfer</option>
                 
                </select>
              </div>
              
               <div class="form-group">
                <label for="dropdown">Send To : In Case of Transfer Only</label>
                <select  name="receiver" class="form-control" id="receiver">
                 <option value="" selected disabled>Select Receiver Account No</option>
                   <%
                   
                   List<Account> allCustomerAccounts = (List<Account>) request.getSession(false).getAttribute("allCustomerAccounts");
					for (Account customerLine : allCustomerAccounts) {
						out.println("<option value=\"" + customerLine.getCustomerId() +" "+ customerLine.getAccountNo()  + "\">Account No: " + customerLine.getAccountNo() + " | Balance: " + customerLine.getBalance() + "</option>");

					    
					}
                   
           //       List<List<String>> allCustomerAccounts = (List<List<String>>) request.getSession(false).getAttribute("allCustomerAccounts");
			//		for (List<String> customerLine : allCustomerAccounts) {
			//			out.println("<option value=\"" + customerLine.get(0) + "\">Account No : "+customerLine.get(0) +" | Balance : " + customerLine.get(1) + "</option>");

					    
			//		}
                  %>
                 
                </select>
              </div>

              <div class="form-group">
                <label for="lastName2">Enter Amount</label>
                <input name="amount" type="text" class="form-control" id="lastName2" placeholder="Enter amount" required pattern="^[0-9]+$">
              </div>
              <button type="submit" class="btn btn-primary">Submit</button>
            </form>

          
          </div> 

        <div id="content-3" class="hide">
        	<h5>My Accounts -><%
        //	 List<List<String>> customerAccounts = (List<List<String>>) request.getAttribute("customerAccounts");
			for (Account customerLine : customerAccounts) {
				out.println("[Account No : "+customerLine.getAccountNo() +" | Balance : " + customerLine.getBalance()+"]");

			    
			}
        		%></h5>
            <h3 class="text-center">My Transactions</h3>
            
		            
					         <div style="display: flex; justify-content: center;">
							  <label  for="start-date" style="margin-right: 10px;">Start Date:</label>
							  <input type="date" id="start" name="start-date" style="margin-right: 20px;" 
							         format="yyyy-MM-dd">
							  <label for="end-date" style="margin-right: 10px;">End Date:</label>
							  <input type="date" id="end" name="end-date" format="yyyy-MM-dd">
							</div>

		
					
					<button onclick="applyFilter()">Apply Filter</button>
					
					
					
						
            
            
	            <table class="table table-bordered">
	                <thead>
	                    <tr>
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
	                     
							List<Transaction> customerPassbook = (List<Transaction>) request.getSession(false).getAttribute("customerPassbook");
	                     
	                         String startDate = request.getParameter("start-date");
	                         String endDate = request.getParameter("end-date");
	                         
	                         
	                        	 
							for (Transaction passLine : customerPassbook) {
								
								if(startDate !=null && endDate !=null){
									int left =  startDate.compareTo(passLine.getDate());
									int right =  endDate.compareTo(passLine.getDate());
									
									
									
									if(left<=0 && right>=0){
										  out.println("<tr>"+
							                        "<td>"+passLine.getSenderAccountNo()+"</td>"+
							                        "<td>"+passLine.getReceiverAccountNo()+"</td>"+
							                        "<td>"+passLine.getType()+"</td>"+
							                        "<td>"+passLine.getAmount()+"</td>"+
							                        "<td>"+passLine.getDate()+"</td>"+
							                        "<td>"+passLine.getStatus()+"</td>"+
							                        "</tr>");
									}
								}else{
									 out.println("<tr>"+
						                        "<td>"+passLine.getSenderAccountNo()+"</td>"+
						                        "<td>"+passLine.getReceiverAccountNo()+"</td>"+
						                        "<td>"+passLine.getType()+"</td>"+
						                        "<td>"+passLine.getAmount()+"</td>"+
						                        "<td>"+passLine.getDate()+"</td>"+
						                        "<td>"+passLine.getStatus()+"</td>"+
						                        "</tr>");
								}
								
							       
							    
							}
						
						%> 
	                   
	                </tbody>
	                </table>
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
    
    
    var jsMethod = '<%= request.getParameter("jsMethod") %>';
    var warning = '<%= request.getParameter("warning") %>';
    var detail = '<%= request.getParameter("detail") %>';
    var status = '<%= request.getParameter("status") %>';
    var tab = '<%= request.getParameter("tab") %>';
    
    if(tab === '3') showTab(3);
    	
   
    
    console.log(jsMethod);
    
    if (jsMethod === 'true') {
 	   swal(warning, detail, status);
 	   
 	   setTimeout(function() {
 		      var url = location.href.split('?')[0]; 
 		      location.href = url;
 		    }, 2000);
    }
  
    function validateForm() {
        var sender = document.getElementById("sender").value;
        var receiver = document.getElementById("receiver").value;

     
        
        if (sender === receiver.split(" ")[1]) {
          alert("Sender and receiver accounts cannot be the same!");
          return false; // Prevent form submission
        }
        return true; // Allow form submission
      }
    
    
    function applyFilter() {
    	 const startDate = document.getElementById("start").value;
    	 alert(startDate);
    	    const endDate = document.getElementById("end").value;
    	    const url = window.location.href.split('?')[0] + '?start-date=' + startDate + '&end-date=' + endDate + '&tab=3';
			 window.location.href = url;
    }
    
    
    

  </script>
  
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>