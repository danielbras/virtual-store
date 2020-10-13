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
import java.util.List;

@WebServlet(name = "VerCarrinhoServlet", urlPatterns = {"/CarrinhoServlet"})
public class CarrinhoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String comando = request.getParameter("command");

        Produto produto = ProdutoSQL.buscar(nome);
        HttpSession session = request.getSession();
        Carrinho c = (Carrinho) session.getAttribute("carrinho");
        if(c == null) {
            c = new Carrinho();
        }

        if(comando.equals("add")) {
            c.addProduto(produto);
        } else if(comando.equals("remove")) {
            c.removeProduto(produto.getNome());
        }

        session.setAttribute("carrinho", c);

        RequestDispatcher encaminhar = request.getRequestDispatcher("/ListaProdutos.jsp");
        encaminhar.forward(request, response);
    }
}
