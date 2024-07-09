package questao09;

import java.util.Objects;

public class Factory {

    private static String senha = "padroes";

    public static ArquivoAberto createArquivo(String senhaDigitada)
    {
        if (Objects.equals(senhaDigitada, senha)) {

            return new ArquivoConfidencial();


        }
        return  new ArquivoPublico();

    }
}
