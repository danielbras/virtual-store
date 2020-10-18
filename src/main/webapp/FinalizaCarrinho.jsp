<%@ page import="Utils.Carrinho" %>
<%@ page import="Utils.Produto" %><%--
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
    <h1>Finaliza Compra</h1>
    <div>
        <%for (Produto p : c.getProdutos()){ %>
            <%subtotal = p.getQuantidade() * p.getPreco();%>
            <p><%out.println(p.getNome());%></p>
        <%}%>
        <p><%out.println(subtotal);%></p>
    </div>
</body>
</html>
