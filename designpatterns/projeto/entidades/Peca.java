package projeto.entidades;

public abstract class Peca {


    private double valor;


    private long id;
    private String marca;
    private String descricao;
    private String tipo;
    // enum ??????


    abstract long getValor();

    abstract String getDescricao();

//    abstract String getMarca();
}
