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
<form method="post" action="/AddProduto">
    <fieldset>
        <label>Nome:</label><br>
        <input type="text" name="nome"><br>
        <label>Descrição: </label><br>
        <input type="text" name="descricao"><br>
        <label>Preço:</label><br>
        <input type="number" step="0.01" name="preco"><br>
        <label>Estoque:</label><br>
        <input type="number" step="1" name="estoque"><br><br>
        <button type="submit">Cadastrar</button>
        <br><br>
    </fieldset>
</form>


</body>
</html>
