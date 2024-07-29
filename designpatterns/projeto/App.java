package projeto;

import projeto.servicos.CotacaoDollar;

/****
 * Coisas necessárias:
 * 1. TODO - cotação do Dollar
 * 2. TODO - Criar um builder para o computador
 */

public class App {
    public static void main(String[] args) {

        CotacaoDollar cotacao = new CotacaoDollar();
        System.out.println(cotacao.retornaCotacaoDeRealParaDollar());


    }
}
