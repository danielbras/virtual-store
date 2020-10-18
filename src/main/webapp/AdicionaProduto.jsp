<%@ page import="Utils.Produto" %>
<%@ page import="Utils.ProdutoSQL" %><%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 17/10/2020
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Virtual Store</title>
</head>
<body>
    <%
        String nomeProduto = request.getParameter("nome");
        String descricaoProduto = request.getParameter("descricao");
        Double precoProduto = Double.parseDouble(request.getParameter("preco"));
        int estoqueProduto = Integer.parseInt(request.getParameter("estoque"));

        Produto p = new Produto(nomeProduto, descricaoProduto, precoProduto, estoqueProduto);
        if(ProdutoSQL.inserir(p)){ %>
            <alert>Produto adicionado com sucesso</alert>
        <%}%>
</body>
</html>
