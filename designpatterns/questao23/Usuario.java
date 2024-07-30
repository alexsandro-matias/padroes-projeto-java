package questao23;

public class Usuario {
    private String nome;
    private Endereco enderecoUsuario;

    public Usuario(String nome, Endereco enderecoUsuario) {
        this.nome = nome;
        this.enderecoUsuario = enderecoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", enderecoUsuario=" + enderecoUsuario +
                '}';
    }
}
