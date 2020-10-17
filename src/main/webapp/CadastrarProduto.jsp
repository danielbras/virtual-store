<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 11/10/2020
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Virtual Store</title>
</head>
<body>
<a href="ListaProdutos.jsp">Exibir Produtos</a>

<h1>Cadastrar Produto</h1>
<form method="post" action="/ListaProdutos">
    <fieldset>
        <legend>Novo produto</legend><br>

        <label>Nome:</label>
        <input type="text" name="nome"><br>
        <label>Descrição: </label>
        <input type="text" name="descricao"><br><br>
        <label>Preço:</label>
        <input type="text" name="preco"><br>
        <label>Estoque:</label>
        <input type="number" name="estoque"><br>
        <button type="submit" >Sing In</button>
        <br><br>
    </fieldset>
</form>


</body>
</html>
