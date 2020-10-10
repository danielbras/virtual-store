<%--
  Created by IntelliJ IDEA.
  User: carlo 14
  Date: 10/10/2020
  Time::53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing Up</title>
</head>
<body>
    <form method="post" action="/authentication">
        <input type="text" name="name">
        <input type="email" name="email">
        <input type="password" name="password">
        <button type="submit">Sing Up</button>
    </form>
</body>
</html>
