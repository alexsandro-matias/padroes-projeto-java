package questao09;
/*
Crie dois arquivos texto em um diretório qualquer:
publico.txt
Estas são informações públicas sobre
qualquer coisa. Todo mundo pode ver
este arquivo.

confidencial.txt
Estas são informações confidenciais, o
que significa que você provavelmente
sabe a palavra secreta!


Usando o padrão Factory Method, crie duas provedoras de informação: uma que retorna informações
públicas e outra que retorna informações confidenciais. Utilize o provedor confidencial se o
usuário informar a senha “designpatterns” como parâmetro para o programa, que deve recuperar
a informação e exibi-la na tela.
*/

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String senha = "padroes";

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite a senha secreta");
        String senhaDigitada = leitura.nextLine();

        Factory.createArquivo(senhaDigitada);



        leitura.close();

    }
}
