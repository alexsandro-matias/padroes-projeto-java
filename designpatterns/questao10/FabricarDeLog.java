package questao10;

public class FabricarDeLog {




    public GeradorLog FabricarDeLog(String tipo) {
        if (tipo.equalsIgnoreCase("console")) {

            return new ImpressaoConsole();

        }
    }


}
