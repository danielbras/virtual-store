<%@ page import="Utils.Carrinho" %>
<%@ page import="Utils.Produto" %>
<%@ page import="Utils.ProdutoSQL" %><%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 18/10/2020
  Time: 01:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Virtual Store</title>
</head>
<body>
<%
    HttpSession s = request.getSession(false);
    Carrinho c = (Carrinho) s.getAttribute("carrinho");
    Double subtotal = 0.0;
%>
<h1>Meu carrinho</h1>
<div>
    <%
    Produto produto = null;
    int quantidade = 0;
    for (Produto p : c.getProdutos()) {
        if(p.getQuantidade() <= p.getEstoque()){
            quantidade = p.getEstoque() - p.getQuantidade();
            ProdutoSQL.atualizar(p.getNome(), quantidade);
        }
        subtotal += p.getQuantidade() * p.getPreco();%>
        <h3><%out.println(p.getQuantidade()+" "+p.getNome()+ ": R$ " +p.getPreco()); %></h3>
    <%}%>
    <hr>
    <h3><%out.println("Total: "+subtotal);%></h3>
    <a href="/FinalizaCarrinhoServlet">Finalizar Compra</a>
</div>
</body>
</html>
