<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<title>Welcome page</title>
	<link rel='stylesheet' href='/webjars/bootstrap/5.2.3/css/bootstrap.min.css'>
	</head>
	<body>
	 <nav class="d-flex bg-dark justify-content-center align-items-center p-2">
	 <h1 class="text-center text-white ">Admin DashBoard</h1>

	     <button type="button" class="btn btn-primary position-absolute end-0  px-5 " onclick="location.href='logout'">Logout</button>
	 
    </nav>
	<h1 class="text-center">welcome ${sessionScope.adminUser.name}</h1>
	<div  class="d-flex  justify-content-around p-2">
	 <button type="button" class="btn btn-success  px-5 " onclick="location.href='list-books'">Books</button>
    
    <button type="button" class="btn btn-primary px-5" onclick="location.href='list-users'">Users</button></div>
	
	<c:if test="${not empty message}">
    <script>
        alert("${message}");
    </script>
</c:if>
	</body>
</html>