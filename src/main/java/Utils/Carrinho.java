package Utils;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> produtos;

    public Carrinho(ArrayList<Produto> produtos) {
        super();
        this.produtos = produtos;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProduto (String nome){
        Produto mp = null;
        for (Produto p : produtos){
            if (p.getNome() == nome){
                return p;
            }
        }
        return mp;
    }

    public void removeProduto (String nome){
        Produto p = getProduto(nome);
        produtos.remove(p);
    }

    public int quantidadeProduto (String nome){
        int quantidade = 0;

        for (Produto p : produtos) {
            if(p.getNome().equals(nome)){
                quantidade++;
            }
        }

        return quantidade;
    }
    public void addProduto (Produto p){
        produtos.add(p);
    }
}
