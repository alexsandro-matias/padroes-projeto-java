package questao07;

public class Chaves extends DecoratorSimbolo{

    public Chaves(FormatacaoTexto simbolo) {
        super(simbolo);

    }

    protected Chaves() {
        this();
        this.simboloAntes = "{ ";
        this.simboloDepois = " }";
    }

    public String toString(String texto) {
        return super.toString(texto);
    }
}
