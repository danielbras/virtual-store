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
        if(this.produtos.contains(p)){
            int index = this.produtos.indexOf(p);
            Produto produto = this.produtos.get(index);
            produto.incrementaQuantidade();
        } else {
            p.incrementaQuantidade();
            this.produtos.add(p);
        }

    }
}
