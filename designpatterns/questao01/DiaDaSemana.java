package questao01;

import java.util.Calendar;

public enum DiaDaSemana implements DiaDaSemanaStrategy {
        DOMINGO {
            @Override
            public int retonarDiaDaSemana(String diaDaSemanaDigitado) {
                return Calendar.SUNDAY;
            }
        },

    SEGUNDA {
        @Override
        public int retonarDiaDaSemana(String diaDaSemanaDigitado) {
            return Calendar.MONDAY;
        }
    },
//
//    TERCA {
//        @Override
//        public int imprimirDiaDaSemana() {
//            return Calendar.TUESDAY;
//        }
//    },
//
//    QUARTA {
//        @Override
//        public int imprimirDiaDaSemana() {
//            return Calendar.WEDNESDAY;
//        }
//    },
//
//    QUINTA {
//        @Override
//        public int imprimirDiaDaSemana() {
//            return Calendar.THURSDAY;
//        }
//    },
//
//    SEXTA {
//        @Override
//        public int imprimirDiaDaSemana() {
//            return Calendar.FRIDAY;
//        }
//    },
//
//    SABADO {
//        @Override
//        public int imprimirDiaDaSemana() {
//            return Calendar.SATURDAY;
//        }
//    };


}
