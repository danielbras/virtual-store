package Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "VerCarrinhoServlet", urlPatterns = {"/Carrinho"})
public class CarrinhoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String comando = request.getParameter("command");

        Produto produto = ProdutoSQL.buscar(nome);

        if(comando.equals("add")) {
            Carrinho carrinho = new Carrinho();
            carrinho.addProduto(produto);
        } else if(comando.equals("remove")) {
            ServletContext context = getServletContext();
            ArrayList<Produto> produtos = (ArrayList<Produto>) context.getAttribute("carrinho");
            Carrinho carrinho = new Carrinho(produtos);
            carrinho.removeProduto(produto.getNome());
        }

        RequestDispatcher encaminhar = request.getRequestDispatcher("/ListaProdutos.jsp");
        encaminhar.forward(request, response);
    }
}
