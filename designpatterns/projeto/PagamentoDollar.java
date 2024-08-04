package projeto;

import projeto.servicos.PagamentoStrategy;

public class PagamentoDollar implements PagamentoStrategy {
    @Override
    public void executarPagamento(double valorPagamento) {
        System.out.println("Pagamento em DOllar");

    }
}
