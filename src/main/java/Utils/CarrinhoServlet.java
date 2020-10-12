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

@WebServlet(name = "VerCarrinhoServlet", urlPatterns = {"/Carrinho"})
public class CarrinhoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String comando = request.getParameter("command");

        ServletContext context = request.getServletContext();
        HttpSession s = (HttpSession) context.getAttribute("session");

        Produto produto = ProdutoSQL.buscar(nome);
        s.setAttribute("nome", produto.getNome());
        s.setAttribute("descricao", produto.getDescricao());
        s.setAttribute("preco", produto.getPreco());
//        to do inserir quantidade na sessão
//        if(comando.equals("add")) {

//        } else if(comando.equals("remove")) {
//
//        }
//
        RequestDispatcher encaminhar = request.getRequestDispatcher("/ListaProdutos.jsp");
        encaminhar.forward(request, response);
    }
}
