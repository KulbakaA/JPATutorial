<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.11.2017
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateUser</title>
</head>
<body>

<form id="formForUserUpdating" action="<c:url value="/saveChanges"/>">
    <input id="id" name="id" type="hidden" value="${userForUpdate.id}">
    <label for="name"> <input id="name" name="name" type="text" value="${userForUpdate.name}"> </label>
    <br/>
    <label for="lastName"> <input id="lastName" name="lastName" type="text" value="${userForUpdate.lastName}"></label>
    <br/>
    <label for="email"> <input id="email" name="email" type="email" value="${userForUpdate.email}"> </label>
    <br/>
    <label for="gender"> <input id="gender" name="gender" type="text" value="${userForUpdate.gender}"> </label>
    <br/>
    <label for="save"> <input type="submit" id="save" name="save" value="Save it."> </label>
</form>

</body>
</html>
