package questao07;

public class Texto implements TextoGenerico {

  private String texto;

    public void setTexto(String texto) {
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
