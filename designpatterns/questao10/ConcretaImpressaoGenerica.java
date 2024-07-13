package questao10;

import java.util.ArrayList;

public abstract class ConcretaImpressaoGenerica implements InterfaceGeradorLog {


    

    protected static ArrayList<Integer> criarConjuntoDeNumeros() {
         ArrayList<Integer>numeros = null;
        for (int i = 1; i <= 11; i++) {
            numeros.add(i);
        }
        return numeros;

    }

    public abstract void imprimirLog();

    


}
