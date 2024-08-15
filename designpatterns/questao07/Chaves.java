package questao07;

public class Chaves extends DecoratorSimbolo{
    public Chaves() {
        super(simbolo);
    }


    public String toString(String texto) {
        return "{ " + caracter + " }";
    }
}
