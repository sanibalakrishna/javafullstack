<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
	<title>New User</title>
	<link rel='stylesheet' href='/webjars/bootstrap/5.2.3/css/bootstrap.min.css'>
	<style>
	body{
	background: rgb(36,7,0);
background: linear-gradient(298deg, rgba(36,7,0,1) 8%, rgba(11,246,141,0.7287289915966386) 50%, rgba(68,0,255,0.711922268907563) 86%);}
	</style>
	
	</head>
	<body class="d-flex  justify-content-center align-items-center">
	
	
	<div class="card p-5 bg-dark bg-opacity-10 ">
	    <h2 class="text-center">REGISTER ADMIN</h2>
	    
		<form method="post" class="mt-4" action="register">
		    <input type="text" name="name" placeholder="name" id="name"/>
			<br><br>
			<input type="email" name="email" placeholder="email" id="email"/>
			<br><br>
			<input type="password" name="password" placeholder="password" id="password"/>
			<br><br>
			<div class="d-flex justify-content-center">
			<button type="submit" class="btn btn-success">Create</button>
			</div>
			
		</form>
		  <h6>${message}</h6>
		<div class="d-flex justify-content-center">
		<a href="login">Already have an Account</a>
		</div>
	  
		</div>
		
	
	</body>
</html>