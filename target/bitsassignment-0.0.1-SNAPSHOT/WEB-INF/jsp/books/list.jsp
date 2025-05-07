<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books List</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
<h2>Books</h2>
<a href="<c:url value='/books/new'/>">Add New Book</a>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author.name}</td>
            <td><a href="<c:url value='/books/edit/${book.id}'/>">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value='/books/join'/>">View Join Data</a>
</body>
</html> 