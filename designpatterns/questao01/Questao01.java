package questao01;


/**
 * 1. Escreva um programa que exiba uma mensagem
 * diferente para cada dia da semana usando o padrão Strategy.
 **/

import java.time.DayOfWeek;

public class Questao01 {


    public static void main(String[] args) {

        DiaDaSemanaStrategy dia = new DiaDaSemana();
        DayOfWeek diaPesquisado = dia.retonarDiaDaSemana(1);
        System.out.println(diaPesquisado);
    }
}







