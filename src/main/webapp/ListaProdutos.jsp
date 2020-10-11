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
    <a href="Login.jsp" <%s.invalidate();%>>Sair</a>
    <h1 align="center">Lista Produtos</h1>
    <%out.println(s.getId());%>

</body>
</html>
