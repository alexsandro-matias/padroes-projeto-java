package questao07;

/*Crie uma classe NumeroUm que tem um método imprimir() que imprime o número “1” na tela.
Implemente decoradores para colocar parênteses, colchetes e chaves ao redor do número (ex.: “1”).
Combine-os de diversas formas.*/

import java.lang.reflect.ParameterizedType;

public class Questao07 {
    public static void main(String[] args) {

       Simbolo simbolo = new Parenteses();
       Simbolo simbolo2 = new Chaves(simbolo);

    }
}
