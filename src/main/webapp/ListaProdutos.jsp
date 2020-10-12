<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 10/10/2020
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Utils.Produto" %>
<%@ page import="Utils.ProdutoSQL" %>
<html>
<head>
    <title>Virtual Store</title>
</head>
<body>
    <%
        ServletContext context = request.getServletContext();
        HttpSession s = (HttpSession) context.getAttribute("session");
//        String tipo = (String) s.getAttribute("tipo");
        Cookie[] c = request.getCookies();
        String tipo = "Cliente";
        if (c != null) {
            for(int i = 0; i < c.length; i++) {
                if(c[i].getName().equals("tipo")){
                    tipo = c[i].getValue();
                }
            }
        }
    %>
<%--    <% s.invalidate();%>--%>
    <a href="Login.jsp ">Sair</a>
    <%out.println(tipo +" "+ s);%>

    <h1>Lista Produtos</h1>
    <table border="1">
        <tr>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Preço</th>
            <th>Estoque</th>
            <%if(tipo.equals("Cliente")) { %>
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
                    <%if(tipo.equals("Cliente")) { %>
                        <td>
                            <%if(p.getEstoque() > 0) { %>
                                <a href="/Carrinho?nome=<%=p.getNome()%>&&command=add">Adicionar</a>
                            <%} else {
                                out.println("Sem estoque");
                            }%>
                        </td>
                    <%} %>
                </tr>
            <%} %>
    </table>

    <%if(tipo.equals("Cliente")) {%>
        <%if(s != null) { %>
            <a href="Carrinho.jsp">Ver Carrinho</a>
        <%} else {
            response.sendRedirect("/ListaProdutos.jsp");
        }%>
    <%} else {%>
        <a href="CadastrarProduto.jsp">Cadastrar Produto</a>
    <%}%>
</body>
</html>
