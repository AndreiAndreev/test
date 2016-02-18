<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Persons</title>
</head>
<body>
<h1>Persons</h1>

<c:url var="addUrl" value="/andrei/main/persons/add" />
<table style="border: 1px solid; width: 500px; text-align:center">
    <thead style="background:#fcf">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Is Admin</th>
        <th>Created Date</th>
        <th colspan="4"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${persons}" var="person">
        <c:url var="editUrl" value="/andrei/main/persons/edit?id=${person.id}" />
        <c:url var="deleteUrl" value="/andrei/main/persons/delete?id=${person.id}" />
        <c:url var="searchUrl" value="/andrei/main/persons/search?id=${person.id}" />
        <tr>
            <td><c:out value="${person.id}" /></td>
            <td><c:out value="${person.name}" /></td>
            <td><c:out value="${person.age}" /></td>
            <td><c:out value="${person.admin}" /></td>
            <td><c:out value="${person.createdDate}" /></td>
            <td><a href="${editUrl}">Edit</a></td>
            <td><a href="${deleteUrl}">Delete</a></td>
            <td><a href="${addUrl}">Add</a></td>
            <td><a href="${searchUrl}">Search</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${empty persons}">
    There are currently no persons in the list. <a href="${addUrl}">Add</a> a person.
</c:if>

</body>
</html>