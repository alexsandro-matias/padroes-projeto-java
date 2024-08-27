package questao07;

public class Texto implements TextoGenerico {

    private final String texto;

    public Texto(String texto) {
        this.texto = texto;
    }


    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return this.texto;
    }
}
