package questao10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Teste {
    public static void main(String[] args) {
        // Verifica se o nome do arquivo foi passado como argumento
        if (args.length != 1) {
            System.out.println("Uso: java LerArquivo <caminho_do_arquivo>");
            return;
        }

        String caminhoArquivo = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            // Lê e imprime o conteúdo do arquivo linha por linha
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
