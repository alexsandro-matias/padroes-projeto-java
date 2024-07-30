package projeto;

import projeto.servicos.PagamentoStrategy;

/****
 * Coisas necessárias:
 * 1. TODO - cotação do Dollar
 * 2. TODO - Criar um builder para o computador
 */

public class App {
    public static void main(String[] args) {

        Carrinho carrinho = new Carrinho();
        PagamentoStrategy dollar = new PagamentoDollar();
        carrinho.pagar(dollar, 10);

    }
}
