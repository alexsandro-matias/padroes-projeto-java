package projeto;

import projeto.servicos.CotacaoDollar;
import projeto.servicos.PagamentoStrategy;

public class PagamentoReal implements PagamentoStrategy {


    @Override
    public void executarPagamento(double valorPagamento) {
//        double cotacao = new CotacaoDollar().retornaCotacaoDeRealParaDollar();
        System.out.println("Pagamento em Real");


    }
}
