package questao10;

import java.util.Scanner;

public class ShowMenu {

    public static int menu() {
        System.out.println("====================================================================");
        System.out.println("=============== Escolha uma das opções abaixo ======================");
        System.out.println("1 - console".toUpperCase());
        System.out.println("2 - arquivo".toUpperCase());
        System.out.println("====================================================================");
        Scanner leitura = new Scanner(System.in);
        return leitura.nextInt();
    }
}
