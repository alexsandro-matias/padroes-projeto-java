package projeto;

import projeto.servicos.PagamentoStrategy;

import java.util.ArrayList;

public class Carrinho {


    protected String descricao;
    protected ArrayList<Carrinho> compras; /* NEW */

    protected Carrinho() {

        descricao = "";
        compras = new ArrayList<Carrinho>(); /* NEW */
    }

    public String getDescricao() {

        return descricao;
    }

    public void addCarrinho(Carrinho Carrinho) { /* NEW */

        compras.add(Carrinho);
    }

    public double getPreco() { /* NEW - AO MENOS A IMPLEMENTAÇÃO */

        double preco = 0;
        for (Carrinho c : compras) {
            preco += c.getPreco();
        }
        return preco;
    }

    public void pagar(PagamentoStrategy estrategiaPagamento, double valorPago) {
        estrategiaPagamento.executarPagamento(valorPago);
    }
}
    


