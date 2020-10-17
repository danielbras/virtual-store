package Utils;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> produtos;

    public Carrinho(ArrayList<Produto> produtos) {
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
        p.diminuiQuantidade();
        produtos.remove(p);
    }

    public void addProduto (Produto p){
        Produto produto = this.getProduto(p.getNome());
        if(produto != null) {
            produto.incrementaQuantidade();
        } else {
            p.incrementaQuantidade();
            produtos.add(p);
        }
    }
}
