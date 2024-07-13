package questao10;

public abstract class FabricaDeLog {


    public InterfaceGeradorLog FabricarDeLog(String tipo) {
        if (tipo.equalsIgnoreCase("console")) {

            return new ConcretaImpressaoPeloConsole();

        } else if (tipo.equalsIgnoreCase("arquivo")) {
            return new ConcretaImpressaoPeloArquivo();

        }

        return null;
    }


}
