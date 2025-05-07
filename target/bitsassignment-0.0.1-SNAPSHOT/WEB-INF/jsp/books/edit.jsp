<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Book</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
<h2>Edit Book</h2>
<form action="<c:url value='/books/update/${book.id}'/>" method="post">
    <label>Title:</label><br/>
    <input type="text" name="title" value="${book.title}"/><br/>
    <label>Author:</label><br/>
    <select name="author.id">
        <c:forEach items="${authors}" var="author">
            <option value="${author.id}" <c:if test="${book.author != null and book.author.id == author.id}">selected</c:if>>
                ${author.name}
            </option>
        </c:forEach>
    </select><br/>
    <button type="submit">Update</button>
</form>
<a href="<c:url value='/books'/>">Back to list</a>
</body>
</html> 