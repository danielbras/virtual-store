package Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdicionaProdutoServlet", urlPatterns = {"/AddProduto"})
public class AdicionaProdutoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeProduto = request.getParameter("nome");
        String descricaoProduto = request.getParameter("descricao");
        Double precoProduto = Double.parseDouble(request.getParameter("preco"));
        int estoqueProduto = Integer.parseInt(request.getParameter("estoque"));

        Produto p = new Produto(nomeProduto, descricaoProduto, precoProduto, estoqueProduto);
        ProdutoSQL.inserir(p);
        response.sendRedirect("/CadastrarProduto.jsp");
    }
}
