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
        if(p.getQuantidade() > 1){
            p.diminuiQuantidade();
            p.incrementaEstoque();
        } else {
            produtos.remove(p);
        }
    }

    public void addProduto (Produto p){
//        Gambiarra para saber a quantidade de um mesmo produto no carrinho
        if(!this.produtos.isEmpty()) {
            for (Produto produto : this.produtos) {
                if (p.getNome().equals(produto.getNome())) {
                    produto.incrementaQuantidade();

                }
            }
        } else {
            p.incrementaQuantidade();
            p.diminuiEstoque();
            this.produtos.add(p);
        }
    }
}
