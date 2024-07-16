package questao10;

public class ArquivoDelogFactory {

    public static InterfaceArquivoLog gerarObjetoConcreto(Integer opcao) {
        if (opcao == 1) {
            return new ConcreteFactoryConsole();
        } else if (opcao == 2) {
            return new ConcreteFactoryArquivo();
        } else {
            System.out.println("Opção inválida");
            return null;
        }
    }
}

