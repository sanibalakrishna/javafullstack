<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
	<head>
	<title>New User</title>
	<link rel='stylesheet' href='/webjars/bootstrap/5.2.3/css/bootstrap.min.css'>
	<style>
	body{
	background: rgb(2,0,36);
background: linear-gradient(298deg, rgba(2,0,36,1) 4%, rgba(246,11,146,1) 53%, rgba(0,212,255,0.9248074229691877) 100%);
	}
	
	</style>
	</head>
	<body class="d-flex  justify-content-center align-items-center">
	
	
	
	<div class="card p-5 bg-dark bg-opacity-10 ">
	    <h2 class="text-center"> ADMIN LOGIN</h2>
	    
		<form method="post" class="mt-4" action="login">
		    <input type="text" name="email" placeholder="email" id="email"/>
			<br><br>
		
			<input type="password" name="password" placeholder="password" id="password"/>
			<br><br>
			<div class="d-flex justify-content-center">
			<button type="submit" class="btn btn-success">Login</button>
			</div>
			
		</form>
		<h6 class="text-dark">${message}</h6>
		<div class="d-flex justify-content-center">
		<a href="register">Register</a>
		</div>
		 
		
	
		</div>
		
	
	</body>
</html>