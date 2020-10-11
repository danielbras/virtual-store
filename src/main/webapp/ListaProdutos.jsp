<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 10/10/2020
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ page import="java.util.List" %>
<%@ page import="Utils.*" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Virtual Store</title>
</head>
<body>
    <%HttpSession s = request.getSession();%>
    <%s.setAttribute("SessionID" ,s.getId());%>
    <a href="Login.jsp" <%s.invalidate();%>>Sair</a>
    <h1 align="center">Lista Produtos</h1>
    <table>
        <tr>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Preço</th>
            <th>Estoque</th>
            <th>Carrinho</th>
            <%ArrayList<Produto> produto;%>
            <%=produto = ProdutoSQL.listar()%>
            <%out.println(produto);%>
<%--        <%for (Produto p : ProdutoSQL.listar()) {%>--%>
<%--            <tr>--%>
<%--                <td><%p.getNome();%></td>--%>
<%--                <td><%p.getDescricao();%></td>--%>
<%--                <td><%p.getPreco();%></td>--%>
<%--                <td><%p.getEstoque();%></td>--%>
<%--                <%if(p.getEstoque() > 0) {%>--%>
<%--                    <td><a href="">Adicionar</a></td>--%>
<%--                <%} else {%>--%>
<%--                    <td>Sem estoque</td>--%>
<%--                <%}%>--%>
<%--            </tr>--%>
<%--        <%}%>--%>
        </tr>
    </table>
</body>
</html>
