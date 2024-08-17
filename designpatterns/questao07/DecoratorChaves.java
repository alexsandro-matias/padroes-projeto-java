package questao07;

public class DecoratorChaves extends DecoratorSimbolo {


    protected DecoratorChaves(TextoGenerico textoGenerico) {
        super(textoGenerico);
        this.simboloAntes = "{ ";
        this.simboloDepois = " }";
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
