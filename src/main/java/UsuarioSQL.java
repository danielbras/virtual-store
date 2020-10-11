import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioSQL {
    private static final String INSERT = "INSERT INTO usuarios (\"Nome\", \"Email\", \"Senha\", \"Tipo\") VALUES (?, ?, ?, ? )";
    private static final String SELECT = "SELECT * FROM usuarios WHERE \"Email\" = ?";

    public static void inserir(Object obj) {
        Usuario cli = (Usuario) obj;
        try {
            Connection con = ConnectDatabase.getConnection();
            PreparedStatement instruction = con.prepareStatement(INSERT);
            instruction.setString(1, cli.getNome());
            instruction.setString(2, cli.getEmail());
            instruction.setString(3, cli.getSenha());
            instruction.setString(4, "Cliente");
            instruction.execute();
            con.close();
            System.out.println("Cliente inserido com sucesso!!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente no banco de dados " + e.getMessage());
        }
    }

    public static Usuario buscar(String email){
        Usuario usuario = null;
        try{
            Connection con = ConnectDatabase.getConnection();
            PreparedStatement instruction = con.prepareStatement(SELECT);
            instruction.setString(1, email);
            ResultSet res = instruction.executeQuery();
            while (res.next()) {
                usuario = new Usuario(res.getString("nome"), res.getString("email"), res.getString("senha"), res.getString("tipo"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente no banco de dados " + e.getMessage());
        }

        return usuario;
    }
}
