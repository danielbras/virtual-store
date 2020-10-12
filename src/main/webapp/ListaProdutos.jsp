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
        HttpSession s = request.getSession(false);
        String user = (String) s.getAttribute("usuario");
        String tipo = (String) s.getAttribute("tipo");
    %>

    <a href="Login.jsp <% s.invalidate();%>">Sair</a>
    <%out.println(user +" "+ tipo +" "+ s);%>

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
                <%
                    String nome = p.getNome();
                    String descricao = p.getDescricao();
                    Double preco = p.getPreco();
                    int estoque = p.getEstoque();
                %>
                <tr>
                    <td><% out.println(nome); %></td>
                    <td><% out.println(descricao); %></td>
                    <td><% out.println(preco); %></td>
                    <td><% out.println(estoque); %></td>
                    <%if(tipo.equals("Cliente")) { %>
                        <td>
                            <%if(p.getEstoque() > 0) { %>
                                <%
                                    s.setAttribute("nome", nome);
                                    s.setAttribute("descricao", descricao);
                                    s.setAttribute("preco", preco);
                                    s.setAttribute("quantidade", estoque);
                                %>
                                <a href="/Carrinho?nome=<%=nome%>&&command=add">Adicionar</a>
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
