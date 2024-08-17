package questao07;

public class DecoratorParenteses extends DecoratorSimbolo {

    public DecoratorParenteses(TextoGenerico textoGenerico) {
        super(textoGenerico);
        this.simboloAntes = "( ";
        this.simboloDepois = " )";
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
