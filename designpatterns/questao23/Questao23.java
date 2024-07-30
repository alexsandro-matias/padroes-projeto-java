package questao23;

/*
Escreva classes para satisfazer os seguintes papéis do padrão Builder:
        • Client: recebe como parâmetros o nome, endereço, telefone e e-mail de uma pessoa, solicita
        ao director que construa informações de contato, recupera a informação do builder e imprime;
        • Director: recebe como parâmetro o builder a ser utilizado e os dados de contato. Manda o
        builder construir o contato;
        • Builder: constrói o contato. Existem três tipos de contato e um builder para cada tipo:
        – ContatoInternet: armazena nome e e-mail;
        – ContatoTelefone: armazena nome e telefone;
        – ContatoCompleto: armazena nome, endereço, telefone e e-mail.
        A classe que representa o papel client deve ter o método main() que irá criar um director e um
        builder de cada tipo. Em seguida, deve pedir ao director que crie um contato de cada tipo e
        imprimi-los (use o toString() da classe que representa a informação de contato).
*/

import java.util.Scanner;

public class Questao23 {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);


        String nomeUsuario, rua, bairro, email, numero;


        System.out.printf("Nome: ");
        nomeUsuario = leitura.nextLine();

        System.out.printf("Rua: ");
        rua = leitura.nextLine();

        System.out.printf("Número: ");
        numero = leitura.nextLine();

        System.out.printf("Bairro: ");
        bairro = leitura.nextLine();

        System.out.printf("Município: ");
        String municipio = leitura.nextLine();

        System.out.printf("UF: ");
        String uf = leitura.nextLine();

        Endereco enderecoDoUsuario = new Endereco.EnderecoBuilder().numero(numero).uf(uf).build();


        Usuario usuario = new Usuario(nomeUsuario, enderecoDoUsuario);

        System.out.println(usuario);


    }
}
