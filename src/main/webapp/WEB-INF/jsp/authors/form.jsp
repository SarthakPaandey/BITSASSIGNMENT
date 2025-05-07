<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Author</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
<h2>Create New Author</h2>
<c:if test="${not empty errorMessage}">
    <div class="error">${errorMessage}</div>
</c:if>
<form action="<c:url value='/authors'/>" method="post">
    <label>Name:</label><br/>
    <input type="text" name="name" value="${author.name}"/><br/>
    <button type="submit">Submit</button>
</form>
<a href="<c:url value='/authors'/>">Back to list</a>
</body>
</html> 