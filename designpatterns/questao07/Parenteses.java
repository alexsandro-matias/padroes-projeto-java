package questao07;

public class Parenteses extends DecoratorSimbolo{


    public Parenteses() {
        super(simbolo);
    }

    @Override
    public String toString(String texto) {
        return "(" + caracter + " )";
    }
}
