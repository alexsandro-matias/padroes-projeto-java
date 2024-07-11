package questao10;

public interface GeradorLog {
    static int[] contaAte10() {
        int[] numeros = new int[11];

        for (int i = 1; i <= 11; i++) {
            numeros[i] = i;
        }
        return numeros;
    }


    String imprimirLog();
}
