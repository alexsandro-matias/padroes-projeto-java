package designpatterns;

public class Word implements Documento {
    @Override
    public void imprimir() {
        System.out.println("Imprimindo Word...");
    }
}