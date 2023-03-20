<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books List</title>
    <link rel='stylesheet' href='/webjars/bootstrap/5.2.3/css/bootstrap.min.css'>
</head>
<body>
    <nav class="d-flex bg-dark justify-content-between align-items-center p-2">
    <button type="button" class="btn btn-success  px-5 " onclick="location.href='newbook'">Add</button>
    <h1 class="text-center text-white ">Books</h1>
    <div>
    <button type="button" class="btn btn-secondary px-5 " onclick="location.href='dashboard'">Home</button>
    <button type="button" class="btn btn-primary px-5" onclick="location.href='logout'">Logout</button>
    </div>
    </nav>
    
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                 <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td class="d-flex justify-content-evenly w-10">
                    <button type="button" class="btn btn-primary text-black " onclick="location.href=`updatebook?id=${book.id}&amp;title=${book.title}&amp;author=${book.author}&amp;price=${book.price}`">Edit</button>
                    <button type="button" class="btn btn-danger text-black " onclick="location.href=`deletebook?id=${book.id}`">Delete</button></td>
                                       
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