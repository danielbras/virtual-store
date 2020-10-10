<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 10/10/2020
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Virtual Store</title>
</head>
<body>
    <form method="post" action="/Authentication">
        <fieldset>
            <legend>Sing In</legend>

            <br><label>E-mail:</label>
            <input type="email" name="email">
            <button type="submit" >Sing In</button>
            <a href="/SingUp.html">Sing Up</a>
            <br><br>
        </fieldset>
    </form>
    <form action="/SingIn.html">
        <fieldset>
            <legend>Sing Up</legend>
            <input type="text" name="name" placeholder="Nome"><br>
            <input type="email" name="email" placeholder="Email"><br>
            <input type="password" name="password" placeholder="Senha"><br>
            <button type="submit">Sing Up</button>
        </fieldset>
    </form>
</body>
</html>
