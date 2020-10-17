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
        produtos.remove(p);
    }

    public void addProduto (Produto p){
        if(!this.produtos.isEmpty()) {
            for (Produto produto : this.produtos) {
                if (p.getNome().equals(produto.getNome())) {
                    produto.incrementaQuantidade();
                    System.out.println(produto.getQuantidade());
                }
            }
        } else {
            p.incrementaQuantidade();
            this.produtos.add(p);
        }
    }
}
