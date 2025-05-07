<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book-Author Join Data</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
<h2>Book-Author Join Data</h2>
<table>
    <tr>
        <th>Book ID</th>
        <th>Book Title</th>
        <th>Author Name</th>
    </tr>
    <c:forEach items="${bookAuthors}" var="ba">
        <tr>
            <td>${ba.bookId}</td>
            <td>${ba.bookTitle}</td>
            <td>${ba.authorName}</td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value='/books'/>">Back to list</a>
</body>
</html> 