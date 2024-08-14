package projeto;

import projeto.servicos.PagamentoStrategy;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/****
 * Coisas necessárias:
 * 1. TODO - cotação do Dollar
 * 2. TODO - Criar um builder para o computador
 */

public class App {
    public static void main(String[] args) {

        String csvFile = "designpatterns/projeto/json-projeto.csv"; // Substitua pelo caminho do seu arquivo

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] é um array de strings, onde cada elemento representa uma coluna
                String id = nextLine[0];
                String descricao = nextLine[1];
                String valor = nextLine[2];

                // Faça algo com os dados, por exemplo, imprimir na tela
                System.out.println("Id: " + id + ", Descrição: " + descricao + ", Valor: " + valor);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();

        }
    }
}
