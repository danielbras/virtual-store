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
        String nomeProduto = request.getParameter("nome");
        String comando = request.getParameter("command");

        ServletContext context = request.getServletContext();
        HttpSession session = (HttpSession) context.getAttribute("sessao");

        Produto produto = ProdutoSQL.buscar(nomeProduto);

        String user = (String) session.getAttribute("usuario");

        response.getWriter().println(user);

//        String user = (String) session.getAttribute("usuario");
//
//        response.getWriter().println(user);
//
//        if(comando.equals("add")) {
//            session.setAttribute("nome", produto.getNome());
//            session.setAttribute("descricao", produto.getDescricao());
//            session.setAttribute("preco", produto.getPreco());
//        } else if(comando.equals("remove")) {
//
//        }
//
//        RequestDispatcher encaminhar = request.getRequestDispatcher("/ListaProdutos.jsp");
//        encaminhar.forward(request, response);
    }
}
