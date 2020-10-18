package Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "FinalizaCarrinhoServlet", urlPatterns = {"/FinalizaCarrinhoServlet"})
public class FinalizaCarrinhoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double valorTotal = 0.0;

        HttpSession s = request.getSession(false);
        Carrinho c = (Carrinho) s.getAttribute("carrinho");

        for (Produto p : c.getProdutos()) {
            valorTotal += p.getPreco() * p.getQuantidade();
        }
    }
}
