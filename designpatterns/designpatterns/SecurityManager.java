package designpatterns;




public class Word implements Documento {
    @Override
    public void imprimir() {
        System.out.println("Imprimindo Word...");
    }
}

public class HTML implements Documento {
    @Override
    public void imprimir() {
        System.out.println("Imprimindo HTML...");
    }
}

public class FabricaDocumentos {
    public Documento criarDocumento(String tipo) {
        if (tipo.equals("pdf")) {
            return new PDF();
        } else if (tipo.equals("word")) {
            return new Word();
        } else if (tipo.equals("html")) {
            return new HTML();
        } else {
            throw new IllegalArgumentException("Tipo de documento inválido");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FabricaDocumentos fabrica = new FabricaDocumentos();
        Documento documento = fabrica.criarDocumento("pdf");
        documento.imprimir();
    }
}