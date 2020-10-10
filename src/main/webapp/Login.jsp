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
            <legend>Sing In</legend><br>

            <label>E-mail:</label>
            <input type="email" name="email">
            <button type="submit" >Sing In</button>
            <br><br>
        </fieldset>
    </form>
    <form method="post" action="/InsertDataBase">
        <fieldset>
            <legend>Sing Up</legend><br>

            <label>Nome: </label>
            <input type="text" name="name"><br>
            <label>E-mail:</label>
            <input type="email" name="email"><br>
            <label>Senha: </label>
            <input type="password" name="password"><br><br>
            <button type="submit">Sing Up</button>
        </fieldset>
    </form>
</body>
</html>
