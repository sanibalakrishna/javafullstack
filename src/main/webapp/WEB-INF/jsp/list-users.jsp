
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users List</title>
    <link rel='stylesheet' href='/webjars/bootstrap/5.2.3/css/bootstrap.min.css'>
</head>
<body>
    <nav class="d-flex bg-dark justify-content-between  align-items-center p-2">
    <button type="button" class="btn btn-success  px-5 " onclick="location.href='newuser'">Add</button>
    <h1 class="text-center text-white ">Users</h1>
    <div>
    <button type="button" class="btn btn-secondary px-5 " onclick="location.href='dashboard'">Home</button>
    <button type="button" class="btn btn-primary px-5 " onclick="location.href='logout'">Logout</button>
    </div>
    
    </nav>
    
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                 <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.address}</td>
                    <td class="d-flex justify-content-evenly w-10">
                    <button type="button" class="btn btn-primary text-black " onclick="location.href=`updateuser?id=${user.id}&amp;name=${user.name}&amp;email=${user.email}&amp;address=${user.address}`">Edit</button>
                    <button type="button" class="btn btn-danger text-black " onclick="location.href=`deleteuser?id=${user.id}`">Delete</button></td>
                                       
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${not empty message}">
    <script>
        alert("${message}");
    </script>
</c:if>
    
    
</body>
</html>