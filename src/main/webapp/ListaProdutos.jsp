<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 10/10/2020
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>Virtual Store</title>
</head>
<body>
    <%HttpSession s = request.getSession();%>
    <button><%s.invalidate();%>Sair<%response.sendRedirect("/Login.jsp");%></button>
    <h1 align="center">Lista Produtos</h1>

</body>
</html>
