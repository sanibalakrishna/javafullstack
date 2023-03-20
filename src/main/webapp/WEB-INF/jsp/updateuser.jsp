<html>
	<head>
	<title>Update User page</title>
	<link rel='stylesheet' href='/webjars/bootstrap/5.2.3/css/bootstrap.min.css'>
	</head>
	<body class="d-flex  justify-content-center align-items-center">
	
	
	<div class="card p-5 bg-dark bg-opacity-10">
	    <h2>Update User ${id}</h2>
	    
		<form method="post" class="mt-4" action="updateuser">
		 <input type="hidden" name="id" value="${id}" id="id"/>
		 <fieldset>
  <legend>Name</legend>
		    <input type="text" name="name" placeholder="name" id="name" value="${name}"/>
			<br><br>
			</fieldset>
			<fieldset>
  <legend>Email</legend>
			<input type="email" name="email" placeholder="email" id="email" value="${email}"/>
			<br><br>
			</fieldset>
			<fieldset>
  <legend>Address</legend>
			<input type="text" name="address" placeholder="address" id="address" value="${address}"/>
			<br><br>
			</fieldset>
			<div class="d-flex justify-content-around">
			<button type="button" class="btn btn-danger" onclick="location.href='list-users'">back</button>
			<input type="submit" class="btn btn-success" value="Update"/>
			</div>
			
		</form>
		
		<h2 class="text-error">${errorMsf}</h2>
	
		</div>
		
	
	</body>
</html>