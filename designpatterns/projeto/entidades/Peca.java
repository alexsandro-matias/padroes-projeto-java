package projeto.entidades;

public abstract class Peca {

    private double valor;
    private long id;
    private String marca;
    private String descricao;


    abstract long getPrice();
}
