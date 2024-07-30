package projeto;

import projeto.servicos.PagamentoStrategy;

public class Carrinho {

    public void pagar(PagamentoStrategy estrategiaPagamento, double valorPago) {
        estrategiaPagamento.executarPagamento(valorPago);
    }
}
