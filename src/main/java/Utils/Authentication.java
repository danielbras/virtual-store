package Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
            HttpSession session = request.getSession();
            Cookie cookieTipo = new Cookie("tipo", usuario.getTipo());

            response.addCookie(cookieTipo);

            ServletContext context = request.getServletContext();
            context.setAttribute("session", session);

            RequestDispatcher encaminhar = request.getRequestDispatcher("/ListaProdutos.jsp");
            encaminhar.forward(request, response);
        } else {
            response.sendRedirect("/Login.jsp");
        }
    }
}
