package questao23;

public class Endereco {
    private final String rua;
    private final String numero;
    private final String bairro;
    private final String municipio;
    private final String uf;

    private Endereco(String rua, String numero, String bairro, String uf, String municipio) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "{" + "rua='" + rua + '\'' + ", numero='" + numero + '\'' + ", bairro='" + bairro + '\'' + ", municipio='" + municipio + '\'' + ", uf='" + uf + '\'' + '}';
    }

    public static class EnderecoBuilder {

        private String rua;
        private String numero;
        private String bairro;
        private String municipio;
        private String uf;

        public EnderecoBuilder rua(String rua) {
            this.rua = rua;
            return this;
        }

        public EnderecoBuilder numero(String numero) {
            this.numero = numero;
            return this;
        }

        public EnderecoBuilder bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public EnderecoBuilder municipio(String municipio) {
            this.municipio = municipio;
            return this;
        }

        public EnderecoBuilder uf(String uf) {
            this.uf = uf;
            return this;
        }


        public Endereco build() {
            return new Endereco(rua, numero, bairro, uf, municipio);
        }


    }
}

