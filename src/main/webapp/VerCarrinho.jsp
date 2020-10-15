<%@ page import="Utils.Carrinho" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Utils.Produto" %><%--
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
    <h1>Lista Carrinho</h1>
    <%
        Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
        for (Produto p: carrinho.getProdutos()) {
            out.println(p.getNome() + "" + p.getDescricao() + "" + p.getPreco());
        }
    %>
<%--    <%= (( Carrinho) session.getAttribute("carrinho")).getProdutos().size()%>--%>
</body>
</html>
