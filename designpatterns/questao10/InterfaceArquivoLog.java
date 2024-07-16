package questao10;

import java.util.ArrayList;

public interface InterfaceArquivoLog {

    ArrayList<Integer> conjuntoDeNumeros = new ArrayList<>();

    static ArrayList<Integer> criarConjuntoDeNumeros() {
        for (int i = 1; i <= 11; i++) {
            conjuntoDeNumeros.add(i);
        }
        return conjuntoDeNumeros;

    }





    void imprimirLog();
}
