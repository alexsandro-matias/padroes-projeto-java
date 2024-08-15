package questao07;

public abstract class DecoratorSimbolo implements Simbolo {

    protected String caracter;

    public DecoratorSimbolo(Simbolo simbolo) {
        this.caracter = simbolo.toString();
    }


}
