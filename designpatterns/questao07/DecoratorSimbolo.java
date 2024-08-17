package questao07;

public abstract class DecoratorSimbolo implements FormatacaoTexto {

    protected String simboloAntes, simboloDepois;
    protected FormatacaoTexto formatacaoTexto;

    protected DecoratorSimbolo(FormatacaoTexto formatacaoTexto) {
        this.formatacaoTexto = formatacaoTexto;
    }

    public String toString(String texto) {
        return simboloAntes + texto + simboloDepois;
    }
}
