package questao01;

import java.time.DayOfWeek;

public class DiaDaSemana implements DiaDaSemanaStrategy {

    @Override
    public DayOfWeek retonarDiaDaSemana(int dia) {
        return DayOfWeek.of(dia);
    }
}



