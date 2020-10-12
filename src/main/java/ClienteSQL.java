import Utils.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteSQL {
    public static void inserir(Object obj) {
        Cliente cli = (Cliente) obj;
        try {
            Connection con = ConnectDatabase.getConnection();
            PreparedStatement instruction = con.prepareStatement("INSERT INTO clientes (\"Nome\", \"Email\", \"Senha\") VALUES (?, ?, ? )");
            instruction.setString(1, cli.getNome());
            instruction.setString(2, cli.getEmail());
            instruction.setString(3, cli.getSenha());
            instruction.execute();
            con.close();
            System.out.println("Cliente inserido com sucesso!!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente no banco de dados " + e.getMessage());
        }
    }

    public static Cliente buscar(String email){
        Cliente cliente = null;
        try{
            Connection con = ConnectDatabase.getConnection();
            PreparedStatement instruction = con.prepareStatement("select * from clientes where Email = ?");
            instruction.setString(1, email);
            ResultSet res = instruction.executeQuery();
            while (res.next()) {
                cliente = new Cliente(res.getString("nome"), res.getString("email"), res.getString("senha"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente no banco de dados " + e.getMessage());
        }

        return cliente;
    }
}
