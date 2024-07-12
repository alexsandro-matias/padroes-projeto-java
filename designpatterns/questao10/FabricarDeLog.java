package questao10;

import java.util.ArrayList;

public class FabricarDeLog implements GeradorLog {


    public GeradorLog FabricarDeLog(String tipo) {
        if (tipo.equalsIgnoreCase("console")) {

            return new ImpressaoConsole();

        } else if (tipo.equalsIgnoreCase("arquivo")) {
            return new ImpressaoArquivo();

        }

        return null;
    }


    @Override
    public void imprimirLog(ArrayList<Integer> numeros) {

    }
}
