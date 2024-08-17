package questao07;

public class Parenteses extends DecoratorSimbolo {

    public Parenteses(FormatacaoTexto formatador) {
        super(formatador);
        this.simboloAntes = "( ";
        this.simboloDepois = " )";
    }

    @Override
    public String toString(String texto) {
        return super.toString(texto);
    }
}
