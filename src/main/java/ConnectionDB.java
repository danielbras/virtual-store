import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "ConnectDB", urlPatterns = "/ConnectDB")
public class ConnectionDB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        try {
            connection = ConnectDatabase.getConnection();
        } catch (SQLException ex) {
            response.getWriter().append("Falha na conexão! Verifique o console de saída");
        }

        if(connection!=null) {
            response.getWriter().append("A conexão com o banco foi realizada!");
             try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            response.getWriter().append("A conexão com o banco falhou!");
        }
    }
}
