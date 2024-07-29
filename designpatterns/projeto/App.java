package projeto;

/****
 * Coisas necessárias:
 * 1. TODO - cotação do Dollar
 * 2. TODO - Criar um builder para o computador
 */

public class App {
    public static void main(String[] args) {

        Computador pc = new Computador
                .ComputadorBuilder()
                .hd("SSD de 256GB")
                .mouse("Blitzwolf sem fio")
                .monitor("AOC 16").build();
        System.out.println(pc);



        //        CotacaoDollar cotacao = new CotacaoDollar();
        //        System.out.println(cotacao.retornaCotacaoDeRealParaDollar());


    }
}
