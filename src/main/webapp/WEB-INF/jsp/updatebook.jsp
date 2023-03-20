<html>
	<head>
	<title>Update Book</title>
		<link rel='stylesheet' href='/webjars/bootstrap/5.2.3/css/bootstrap.min.css'>
		<style>
		.legendborder{
          position:absolute;
          top:-2px;
		}
		
		</style>
	</head>
	<body class="d-flex  justify-content-center align-items-center">

	<div class="card p-5 bg-dark  bg-opacity-10" >
	    <h2 class="text-center">Update Book ${id}</h2>
		<form method="post" class="mt-3" action="updatebook">
		 <input type="hidden" name="id" value="${id}" id="id"/>
		    			<fieldset>
  <legend>Title</legend>
			<input type="text" name="title" placeholder="title" id="title" value="${title}"/>
			<br><br>
			</fieldset>
						<fieldset>
  <legend>author</legend>
			<input type="text" name="author" placeholder="author" id="author" value="${author}"/>
			<br><br>
			</fieldset>
				<fieldset>
  <legend>Price</legend>
			<input type="number" name="price" placeholder="price" id="price" value="${price}"/>
			 </fieldset>
			<br><br>
	
			



		<div class="d-flex justify-content-around">
			<button type="button" class="btn btn-danger" onclick="location.href='list-books'">back</button>
			<input type="submit" class="btn btn-success" value="Update"/>
			</div>
			
		</form>
				<h2 class="text-error">${errorMsf}</h2>
		</div>
		
		
	
	</body>
</html>