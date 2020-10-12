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
    <h1>Lista Carrinho</h1>
    <a href="<%RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaProdutos.jsp?tipo=Cliente");%><%dispatcher.forward(request, response);%>">
        Ver Produtos
    </a>
</body>
</html>
