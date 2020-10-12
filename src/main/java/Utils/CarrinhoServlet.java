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

        Produto produto = ProdutoSQL.buscar(nome);


//        if(comando.equals("add")) {

//        } else if(comando.equals("remove")) {
//
//        }
//
//        RequestDispatcher encaminhar = request.getRequestDispatcher("/ListaProdutos.jsp");
//        encaminhar.forward(request, response);
    }
}
