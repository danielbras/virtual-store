package Utils;

import Utils.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoSQL {
    private static final String INSERIR = "INSERT INTO produtos (\"Nome\", \"Descricao\", \"Preco\", \"Estoque\") VALUES (?, ?, ?, ?)";
    private static final String ATUALIZAR = "UPDATE produtos SET \"Estoque\" = ? WHERE \"Nome\" = ?";
    private static final String BUSCAR = "SELECT * FROM produtos WHERE \"Nome\"= ?";
    private static final String LISTAR = "SELECT * FROM produtos";

    public static boolean inserir(@org.jetbrains.annotations.NotNull Produto p){
        try {
            Connection con = ConnectDatabase.getConnection();
            PreparedStatement instruction = con.prepareStatement(INSERIR);
            instruction.setString(1, p.getNome());
            instruction.setString(2, p.getDescricao());
            instruction.setDouble(3, p.getPreco());
            instruction.setInt(4, p.getEstoque());
            instruction.execute();
            con.close();
            System.out.println("Produto cadastrado com sucesso!!");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto no banco de dados " + e.getMessage());
            return false;
        }
    }

    public static void atualizar(String nome, int estoque){
        try {
            Connection con = ConnectDatabase.getConnection();
            PreparedStatement instruction = con.prepareStatement(ATUALIZAR);
            instruction.setInt(1, estoque);
            instruction.setString(2, nome);
            instruction.execute();
            con.close();
            System.out.println("O produto: "+ nome +" foi alterado com sucesso!");
        } catch (SQLException e){
            System.out.println("Erro ao atualizar estoque de produto no banco de dados " + e.getMessage());
        }
    }

    public static ArrayList<Produto> listar(){
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        try {
            Connection con = ConnectDatabase.getConnection();
            PreparedStatement instruction = con.prepareStatement(LISTAR);
            ResultSet res = instruction.executeQuery();
            while (res.next()) {
                Produto p = new Produto(res.getString("Nome"),res.getString("Descricao"), res.getDouble("Preco"), res.getInt("Estoque"));
                listaProdutos.add(p);
            }
            con.close();
            System.out.println("Listagem de produtos realizada!");
        } catch (SQLException e) {
            System.out.println("Erro ao emitir a listagem de produtos no banco banco de dados " + e.getMessage());
            }
        return listaProdutos;
    }

    public static Produto  buscar(String nome){
        Produto produto = null;
        try {
            Connection con = ConnectDatabase.getConnection();
            PreparedStatement instruction = con.prepareStatement(BUSCAR);
            instruction.setString(1, nome);
            ResultSet res = instruction.executeQuery();
            while (res.next()) {
                produto = new Produto(res.getString("Nome"),res.getString("Descricao"), res.getDouble("Preco"), res.getInt("Estoque"));

            }
            con.close();
            System.out.println("A busca pelo produto foi realizada!");
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto no banco banco de dados " + e.getMessage());
            }
        return produto;
    }
}
