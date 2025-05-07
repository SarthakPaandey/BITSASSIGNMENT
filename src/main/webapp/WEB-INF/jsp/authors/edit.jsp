<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Author</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
<h2>Edit Author</h2>
<form action="<c:url value='/authors/update/${author.id}'/>" method="post">
    <label>Name:</label><br/>
    <input type="text" name="name" value="${author.name}"/><br/>
    <button type="submit">Update</button>
</form>
<a href="<c:url value='/authors'/>">Back to list</a>
</body>
</html> 