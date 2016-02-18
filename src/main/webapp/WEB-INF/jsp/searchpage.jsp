<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Search</title>
</head>
<body>

<h1>Searching Existing Person</h1>
<c:url var="searchUrl" value="/andrei/main/persons/search" />
<form:form modelAttribute="personAttribute" method="POST" action="${searchUrl}">
    <table>
        <tr>
            <td><form:label path="id">Id:</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
    </table>

    <input type="submit" value="Search" />
</form:form>

</body>
</html>
