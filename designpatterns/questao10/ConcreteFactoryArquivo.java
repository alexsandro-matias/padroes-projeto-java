package questao10;

import java.io.*;
import java.util.ArrayList;

public class ConcreteFactoryArquivo implements InterfaceArquivoLog {


    @Override
    public void imprimirLog() {

        String nomeArquivo = "log.txt";

        ArrayList<Integer> conjuntoDeNumeros = InterfaceArquivoLog.criarConjuntoDeNumeros();

        boolean temConteudo = true;
        // Cria um StringBuilder para armazenar a contagem
        StringBuilder conteudo = new StringBuilder();

        // Adiciona a contagem ao StringBuilder
        for (int i = 1; i <= conjuntoDeNumeros.size(); i++) {
            conteudo.append(i).append(System.lineSeparator());
        }

        // Salva o conteúdo no arquivo
        try (FileWriter fw = new FileWriter(nomeArquivo); PrintWriter pw = new PrintWriter(fw)) {
            pw.print(conteudo);
            System.out.println("Contagem salva em " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        try {
            FileReader leitorArquivo = new FileReader("log.txt");
            BufferedReader bufferedReader = new BufferedReader(leitorArquivo);
            while (temConteudo) {
                String linha = bufferedReader.readLine();
                if (linha != null) {
                    System.out.println(linha);
                } else {
                    break;
                }
            }
        } catch (IOException e) {

            throw new RuntimeException(e.getMessage());
        }

    }
}
