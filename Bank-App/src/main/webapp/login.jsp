<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <title>Document</title>
  <style>
    body {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    form {
      max-width: 400px;
      width: 100%;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
 
    .center-btn {
      display: flex;
      justify-content: center;
    }

 
  </style>
</head>
<body>

  <form action="LoginController" method="post">

  <h2 class="text-center">Login</h2>
  
  <!-- Username input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example1">Username</label>
    <input name="username" id="form2Example1" class="form-control" required>
    <div class="invalid-feedback">
      Please enter a username.
    </div>
  </div>

  <!-- Password input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example2">Password</label>
    <input name="password" type="password" id="form2Example2" class="form-control" required>
    <div class="invalid-feedback">
      Please enter a password.
    </div>
  </div>

  <!-- Dropdown menu for User/Admin selection -->
  <div class="form-group">
    <label for="userRole">Select Role:</label>
    <div class="input-group">
      <select name="role" class="form-control" id="userRole" required>
        <option value="" selected disabled>Select role...</option>
        <option value="user">User</option>
        <option value="admin">Admin</option>
      </select>
      <div class="invalid-feedback">
        Please select a role.
      </div>
    </div>
  </div>
  <br><br>

  <!-- Submit button -->
  <div class="center-btn">
    <button value="submit" type="submit" class="btn btn-primary btn-block">Login</button>
  </div>
</form>
  
  <script type="text/javascript">
  
   var jsMethod = '<%= request.getParameter("jsMethod") %>';
  
   if (jsMethod === 'true') {
	   swal("Try Again!", "Invalid login Credentials", "error");
	   
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
 
  </script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-vDfH3wXCE5yBltYIOTKjOmYcZpKwmXv2dwhAadBXoILH6A7m3ulcGAtkyWy9sSZz" crossorigin="anonymous"></script>
</body>
</html>
