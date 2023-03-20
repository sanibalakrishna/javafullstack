<html>
	<head>
	<title>Books page</title>
		<link rel='stylesheet' href='/webjars/bootstrap/5.2.3/css/bootstrap.min.css'>
	</head>
	<body class="d-flex  justify-content-center align-items-center">

	<div class="card p-5 bg-dark bg-opacity-10" >
	    <h2 class="text-center">Book Details</h2>
		<form method="post" class="mt-3">
		
			<input type="text" name="title" placeholder="title" id="title"/>
			<br><br>
			<input type="text" name="author" placeholder="author" id="author"/>
			<br><br>
			<input type="number" name="price" placeholder="price" id="price"/>
			<br><br>
		<div class="d-flex justify-content-center">
			<button type="submit" class="btn btn-success">Create</button>
			</div>
			
		</form>
				<h2 class="text-error">${errorMsf}</h2>
		</div>
		
		
	
	</body>
</html>