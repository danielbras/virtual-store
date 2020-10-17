package Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "VerCarrinhoServlet", urlPatterns = {"/CarrinhoServlet"})
public class CarrinhoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String comando = request.getParameter("command");

        Produto p = ProdutoSQL.buscar(nome);

        HttpSession session = request.getSession(false);
        Carrinho c = (Carrinho) session.getAttribute("carrinho");

        if(c == null) {
            ArrayList<Produto> produtos = new ArrayList<>();
            c = new Carrinho(produtos);
        }

        if(comando.equals("add")) {
            if(p.getQuantidade() < p.getEstoque()) {
                c.addProduto(p);
                p.diminuiEstoque();
            }
        } else if(comando.equals("remove")) {
            c.removeProduto(p.getNome());
            RequestDispatcher encaminhar = request.getRequestDispatcher("/VerCarrinho.jsp");
            encaminhar.forward(request, response);
        }

        session.setAttribute("carrinho", c);

        RequestDispatcher encaminhar = request.getRequestDispatcher("/ListaProdutos.jsp");
        encaminhar.forward(request, response);
    }
}
