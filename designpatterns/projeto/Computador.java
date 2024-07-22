package projeto;




public class Computador {
    private final String gabinete;
    private final String processador;
    private final String memoria;
    private final String hd;
    private final String mouse;
    private final String teclado;
    private final String monitor;


    private Computador(String gabinete, String processador, String memoria, String hd, String mouse, String teclado, String monitor) {
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

    public static class ComputadorBuilder {
        private String gabinete;
        private String processador;
        private String memoria;
        private String hd;
        private String mouse;
        private String teclado;
        private String monitor;
        private long price;


        public ComputadorBuilder gabinete(String gabinete) {
            this.gabinete = gabinete;
            return this;
        }

        public ComputadorBuilder processador(String processador) {
            this.processador = processador;
            return this;
        }

        public ComputadorBuilder memoria(String memoria) {
            this.memoria = memoria;
            return this;
        }

        public ComputadorBuilder hd(String hd) {
            this.hd = hd;
            return this;
        }

        public ComputadorBuilder mouse(String mouse) {
            this.mouse = mouse;
            return this;
        }

        public ComputadorBuilder teclado(String teclado) {
            this.teclado = teclado;
            return this;
        }

        public ComputadorBuilder monitor(Peca peca) {
            this.mouse = monitor;
            this.price += peca.getPrice();
            return this;
        }

        public Computador build() {
            return new Computador(gabinete, processador, memoria, hd, mouse, teclado, monitor);
        }


    }
}
