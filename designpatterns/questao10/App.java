package questao10;

// Escreva um programa que conte até 10 e envie os números para uma ferramenta
// de log. Esta
// ferramenta de log deve ser construída por uma fábrica. Utilize Factory Method
// para permitir a escolha entre dois tipos de log: em arquivo (log.txt) ou diretamente no
// console. A escolha deve
// ser por um parâmetro passado ao programa (“arquivo” ou “console”).
// public class App
public class App {
    public static void main(String[] args) {

        int opcao = ShowMenu.menu();

        ArquivoDelogFactory.gerarObjetoConcreto(opcao).imprimirLog();


    }


}


