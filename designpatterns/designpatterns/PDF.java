package designpatterns;

    public class PDF implements Documento {
        @Override
        public void imprimir() {
            System.out.println("Imprimindo PDF...");
        }
    }
