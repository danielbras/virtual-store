package Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthServlet", urlPatterns = "/Utils.Authentication")
public class Authentication extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = UsuarioSQL.buscar(email);

        if(email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())) {
            if(usuario.getTipo().equals("Cliente")){
                response.sendRedirect("/ListaProdutos.jsp");
            } else {
                response.sendRedirect("/ListaProdutos.jsp?tipo=Lojista");
            }
        } else {
            response.sendRedirect("/Login.jsp");
        }


    }
}
