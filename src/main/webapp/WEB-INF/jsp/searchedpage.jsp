<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Search</title>
</head>
<body>

<h1>Persons</h1>
<p>You have searched a person with id ${person.id}. His age is ${person.age}. His name is ${person.name} and he IsAdmin = ${person.admin}</p>

<c:url var="mainUrl" value="/andrei/main/persons" />
<p>Return to <a href="${mainUrl}">Main List</a></p>
<c:url var="editUrl" value="/andrei/main/persons/edit?id=${person.id}" />
<p><a href="${editUrl}">Edit Person</a></p>
<c:url var="deleteUrl" value="/andrei/main/persons/delete?id=${person.id}" />
<p><a href="${deleteUrl}">Delete Person</a></p>

</body>
</html>
