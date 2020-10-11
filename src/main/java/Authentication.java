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

@WebServlet(name = "AuthServlet", urlPatterns = "/Authentication")
public class Authentication extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = UsuarioSQL.buscar(email);

        ArrayList<Produto> produtos = ProdutoSQL.listar();

        if(email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())) {
            if(usuario.getTipo() == "Cliente"){
                response.sendRedirect("/ListaProdutos.jsp");
            } else {
                response.sendRedirect("/ListaProdutos.jsp");
            }
        } else {
            response.sendRedirect("/Login.jsp");
        }


    }
}
