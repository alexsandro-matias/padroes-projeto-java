package exemplos.abstractmethod;

public class Main {
    public static void main(String[] args) {
        FabricaDocumentos fabrica = new FabricaDocumentos();
        Documento documento = fabrica.criarDocumento("Word");
        documento.imprimir();
    }
}