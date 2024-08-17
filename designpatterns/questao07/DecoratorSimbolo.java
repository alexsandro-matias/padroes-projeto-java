package questao07;

public abstract class DecoratorSimbolo implements TextoGenerico {

    protected String simboloAntes, simboloDepois;
    protected TextoGenerico textoGenerico;
    protected Texto texto;

    protected DecoratorSimbolo(TextoGenerico textoGenerico) {
        this.textoGenerico = textoGenerico;
    }

    public String toString() {
        return simboloAntes + texto.getTexto() + simboloDepois;
    }
}
