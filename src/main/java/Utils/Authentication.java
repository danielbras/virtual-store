package Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AuthServlet", urlPatterns = "/ListaProdutos")
public class Authentication extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = UsuarioSQL.buscar(email);

        if(email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())) {
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", usuario.getEmail());
            session.setAttribute("tipo", usuario.getTipo());
            RequestDispatcher encaminhar = request.getRequestDispatcher("/ListaProdutos.jsp");
            encaminhar.forward(request, response);

//            response.sendRedirect("/ListaProdutos.jsp?tipo="+usuario.getTipo());
        } else {
            response.sendRedirect("/Login.jsp");
        }


    }
}
