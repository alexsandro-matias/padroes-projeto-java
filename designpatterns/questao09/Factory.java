package questao09;

public class Factory {

    private static final String senha = "padroes";

    private ArquivoAberto tipoAberturaArquivo;

    public static ArquivoAberto createArquivo(String senhaDigitada) {


        if (senha.equals(senhaDigitada)) {
            return new ArquivoConfidencial();
        }

        return new ArquivoPublico();

    }
}
