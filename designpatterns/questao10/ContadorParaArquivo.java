package questao10;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContadorParaArquivo {
    public static void main(String[] args) {
        // Nome do arquivo onde a contagem será salva
        String nomeArquivo = "log.txt";

        // Cria um StringBuilder para armazenar a contagem
        StringBuilder conteudo = new StringBuilder();

        // Adiciona a contagem ao StringBuilder
        for (int i = 1; i <= 10; i++) {
            conteudo.append(i).append(System.lineSeparator());
        }

        // Salva o conteúdo no arquivo
        try (FileWriter fw = new FileWriter(nomeArquivo); PrintWriter pw = new PrintWriter(fw)) {
            pw.print(conteudo);
            System.out.println("Contagem salva em " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
