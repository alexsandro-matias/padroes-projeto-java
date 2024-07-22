package projeto;

/****
 * Coisas necessárias:
 * 1. TODO - cotação do Dollar
 * 2. TODO - Criar um builder para o computador
 */

public class App {
    public static void main(String[] args) {

//        Computador pc = new Computador.ComputadorBuilder().gabinete("Topada").memoria("DDR4").build();
//        System.out.println(pc);

        CotacaoDollar cotacao = new CotacaoDollar();
        System.out.println(cotacao.retornaCotacaoDeRealParaDollar());


    }
}
