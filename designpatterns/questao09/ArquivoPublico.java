package questao09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArquivoPublico implements ArquivoAberto{
    @Override
    public String lerArquivoDeTexto() {
        try {
            String conteudo = Files.readString(Paths.get("questao09/publico.txt"));
            return "Conteúdo Público: " + conteudo;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}