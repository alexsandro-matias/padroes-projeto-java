package projeto;

import projeto.servicos.CotacaoDollar;
import projeto.servicos.PagamentoStrategy;

/****
 * Coisas necessárias:
 * 1. TODO - cotação do Dollar
 * 2. TODO - Criar um builder para o computador
 */

public class App {
    public static void main(String[] args) {

        PagamentoStrategy pagamento = new PagamentoDollar();
        pagamento.executarPagamento(100);




    }
}
