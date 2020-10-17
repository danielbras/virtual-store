package Utils;

public class Produto {
    private double preco;
    private String nome;
    private String descricao;
    private int estoque;

    public Produto(String nome, String descricao, double preco, int estoque) {
        super();
        this.preco = preco;
        this.nome = nome;
        this.descricao = descricao;
        this.estoque = estoque;
    }

    public Produto() {

    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void incrementaEstoque() {
        this.estoque++;
    }

    public void diminuiEstoque() {
        this.estoque--;
    }
}
