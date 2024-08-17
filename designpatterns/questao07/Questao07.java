package questao07;

/*Crie uma classe NumeroUm que tem um método imprimir() que imprime o número “1” na tela.
Implemente decoradores para colocar parênteses, colchetes e chaves ao redor do número (ex.: “1”).
Combine-os de diversas formas.*/

public class Questao07 {
    public static void main(String[] args) {

        FormatacaoTexto primeiro = new Chaves();
        String a = primeiro.toString("A");
        System.out.println(a);

        primeiro = new Parenteses();

        String b = primeiro.toString("b");
        System.out.println(b);


    }
}
