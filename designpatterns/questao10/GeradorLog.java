package questao10;

import java.util.ArrayList;

public interface GeradorLog {
    ArrayList<Integer> numeros = new ArrayList<Integer>();

    public static ArrayList<Integer> criarConjuntoDeNumeros() {
        for (int i = 1; i <= 11; i++) {
            numeros.add(i);
        }
            return numeros;

    }



//    ArrayList<Integer> numeros = new ArrayList<Integer>();

    public void imprimirLog(ArrayList<Integer> numeros);


}

