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
            if (p.getNome().equals(nome)){
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
        boolean flag = false;
        Produto produto = this.getProduto(p.getNome());

        if(produto == null) {
            flag = true;
            p.incrementaQuantidade();
            produtos.add(p);
        }
        if(!flag){
            produto.incrementaQuantidade();
        }
//
//        if(!this.produtos.isEmpty()) {
//            for (Produto produto : this.produtos) {
//                if (p.getNome().equals(produto.getNome())) {
//                    flag = true;
//                    produto.incrementaQuantidade();
//                }
//            }
//        }
////        Adiciona se o produto ainda não estiver no carrinho
//        if(!flag){
//            p.incrementaQuantidade();
//            produtos.add(p);
//        }
    }
}
