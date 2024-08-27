package questao07;

/*Crie uma classe NumeroUm que tem um método imprimir() que imprime o número “1” na tela.
Implemente decoradores para colocar parênteses, colchetes e chaves ao redor do número (ex.: “1”).
Combine-os de diversas formas.*/

public class Questao07 {
    public static void main(String[] args) {

        Texto textoDecorado = new Texto("a");

        DecoratorSimbolo outroTextoDecorado = new DecoratorParenteses(textoDecorado);

        System.out.println(outroTextoDecorado);


//
//        TextoGenerico primeiro = new DecoratorChaves();
//        String a = primeiro.toString("A");
//        System.out.println(a);
//
//        DecoratorParenteses segundo = new DecoratorParenteses(primeiro);
//
//        System.out.println(segundo);


    }
}
