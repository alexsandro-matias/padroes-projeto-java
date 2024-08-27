package projeto.entidades;


import java.util.ArrayList;
import java.util.List;

public class Computador extends Peca {
    private final Gabinete gabinete;
    private final Processador processador;
    private final Memoria memoria;
    private final Hd hd;
    private final Mouse mouse;
    private final Teclado teclado;
    private final Monitor monitor;
    private List<Peca> computadorMontado = new ArrayList<Peca>();


    private Computador(Gabinete gabinete, Processador processador, Memoria memoria, Hd hd,
                       Mouse mouse, Teclado teclado, Monitor monitor) {
        this.gabinete = gabinete;
        this.processador = processador;
        this.memoria = memoria;
        this.hd = hd;
        this.mouse = mouse;
        this.teclado = teclado;
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        return "Computador{" + "gabinete='" + gabinete + '\'' + ", processador='" + processador + '\'' + ", memoria='" + memoria + '\'' + ", hd='" + hd + '\'' + ", mouse='" + mouse + '\'' + ", teclado='" + teclado + '\'' + ", monitor='" + monitor + '\'' + '}';
    }

    @Override
    long getValor() {
        return 0;
    }

    @Override
    String getDescricao() {
        return "";
    }

    @Override
    String getMarca() {
        return "";
    }

    public static class ComputadorBuilder {
        private Gabinete gabinete;
        private Processador processador;
        private Memoria memoria;
        private Hd hd;
        private Mouse mouse;
        private Teclado teclado;
        private Monitor monitor;


        public ComputadorBuilder gabinete(Gabinete gabinete) {
            this.gabinete = gabinete;
            return this;
        }

        public ComputadorBuilder processador(Processador processador) {
            this.processador = processador;
            return this;
        }

        public ComputadorBuilder memoria(Memoria memoria) {
            this.memoria = memoria;
            return this;
        }

        public ComputadorBuilder hd(Hd hd) {
            this.hd = hd;
            return this;
        }

        public ComputadorBuilder mouse(Mouse mouse) {
            this.mouse = mouse;
            return this;
        }

        public ComputadorBuilder teclado(Teclado teclado) {
            this.teclado = teclado;
            return this;
        }




        public Computador build() {
            return new Computador(gabinete, processador, memoria, hd, mouse, teclado, monitor);
        }

        public void adicionarPeca(Peca peca)
        {

        }


    }
}
