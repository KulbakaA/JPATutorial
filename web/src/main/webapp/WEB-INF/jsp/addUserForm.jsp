<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30.10.2017
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser</title>
</head>
<body>

<form id="addUserForm" action="<c:url value="/addUser"/>" method="post">
    <label for="name">Enter the name : <input id="name" name="name" type="text"> </label><br/>
    <label for="lastName">Enter the lastName :<input id="lastName" name="lastName" type="text"> </label><br/>
    <label for="email">Enter email : <input id="email" name="email" type="email"> </label><br/>
    <label for="listOfPhones">Enter phone : <input id="listOfPhones" name="listOfPhones[0].number" type="text"> </label><br/>
    <label for="gender">Choose gender of new User :
        <select id="gender" name="gender">
            <option value="FEMALE">Женщина</option>
            <option value="MALE">Мужчина</option>
        </select>
    </label><br/>

    <input type="submit" name="save" value="Добавить">

</form>

</body>
</html>
