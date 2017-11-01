<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.11.2017
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show</title>
</head>
<body>
<table style="border: 1px solid #dc1799">

    <c:forEach var="user" items="${listOfUsers}">
        <tr>
            <td><a href="<c:url value="/update?userId=${user.id}"/>">${user.id} </a></td>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.gender}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
