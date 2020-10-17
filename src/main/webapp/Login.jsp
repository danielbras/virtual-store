<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 10/10/2020
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Virtual Store</title>
</head>
<body>
    <form method="post" action="/ListaProdutos">
        <fieldset>
            <legend>Sing In</legend><br>

            <label>Email:</label><br>
            <input type="email" name="email"><br>
            <label>Senha: </label><br>
            <input type="password" name="senha"><br><br>
            <button type="submit" >Sing In</button>
            <br><br>
        </fieldset>
    </form>

    <form method="post" action="/AddUsuario">
        <fieldset>
            <legend>Sing Up</legend><br>

            <label>Nome:</label><br>
            <input type="text" name="nome"><br>
            <label>Email:</label><br>
            <input type="email" name="email"><br>
            <label>Senha: </label><br>
            <input type="password" name="senha"><br><br>
            <button type="submit">Sing Up</button>
        </fieldset>
    </form>
</body>
</html>
