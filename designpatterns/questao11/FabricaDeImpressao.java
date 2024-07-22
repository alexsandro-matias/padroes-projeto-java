package questao11;

public class FabricaDeImpressao {

    protected int opcao;
    protected InterfaceDeImpressaoGenerica impressaoGenerica = criarFormaConcretaDeImpressao();

    private InterfaceDeImpressaoGenerica criarFormaConcretaDeImpressao() {

        if (opcao == 1) {
            return new ImpressaoNaTela();
        } else if (opcao == 2) {
            return new ImpressaoDeUmArquivo();

        }
        return null;
    }


}
