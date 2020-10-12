<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 10/10/2020
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Utils.Produto" %>
<%@ page import="Utils.ProdutoSQL" %>
<html>
<head>
    <title>Virtual Store</title>
</head>
<body>
    <%HttpSession s = request.getSession(); %>
    <%s.setAttribute("SessionID" ,s.getId()); %>
    <%String tipo = request.getParameter("tipo"); %>

    <a href="Login.jsp" <% s.invalidate(); %>>Sair</a>

    <h1 align="center">Lista Produtos</h1>
    <table align="center" border="1">
        <tr>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Preço</th>
            <th>Estoque</th>
            <%if(!tipo.equals("Lojista")) { %>
                <th>Carrinho</th>
            <%} %>
        </tr>
            <%ArrayList<Produto> listaProdutos; %>
            <%listaProdutos = ProdutoSQL.listar(); %>
            <%for (Produto p: listaProdutos) { %>
                <tr>
                    <td><% out.println(p.getNome()); %></td>
                    <td><% out.println(p.getDescricao()); %></td>
                    <td><% out.println(p.getPreco()); %></td>
                    <td><% out.println(p.getEstoque()); %></td>
                    <%if(!tipo.equals("Lojista")) { %>
                        <td><a href="">Adicionar</a></td>
                    <%} %>
                </tr>
            <%} %>
        <tr>
            <td><a href="Carrinho.jsp">Ver Carrinho</a></td>
        </tr>
    </table>
</body>
</html>
