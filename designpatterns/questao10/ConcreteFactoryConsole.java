package questao10;

import java.util.ArrayList;

public class ConcreteFactoryConsole implements InterfaceArquivoLog {


    @Override
    public void imprimirLog() {

        ArrayList<Integer> conjuntoDeNumeros = InterfaceArquivoLog.criarConjuntoDeNumeros();

        for (Integer conjuntoDeNumero : conjuntoDeNumeros) {
            System.out.println(conjuntoDeNumero);
        }

    }
}
