<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authors List</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
<h2>Authors</h2>
<a href="<c:url value='/authors/new'/>">Add New Author</a>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.name}</td>
            <td><a href="<c:url value='/authors/edit/${author.id}'/>">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html> 