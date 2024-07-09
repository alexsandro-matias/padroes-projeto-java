package questao09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArquivoConfidencial implements ArquivoAberto {
    String conteudo;
    String textoFinal;


    public ArquivoConfidencial() {

        textoFinal = lerArquivoDeTexto();
    }

    @Override
    public String lerArquivoDeTexto() {
        try {
            conteudo = Files.readString(Paths.get("designpatterns/questao09/confidencial.txt"));
            return "Senha confidencial: " + conteudo;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
