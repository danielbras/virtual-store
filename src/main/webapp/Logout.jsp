<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 13/10/2020
  Time: 11:35
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
        s.invalidate();

        response.sendRedirect("/Login.jsp");
    %>
</body>
</html>
