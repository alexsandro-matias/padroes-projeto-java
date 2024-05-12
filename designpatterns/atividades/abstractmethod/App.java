package atividades.abstractmethod;

public class App {

	public static void main(String[] args) {

		// Tentando um String pura
		// String stringTeste = "matias"; //ok funciona
//		StringInvertida texto = new StringInvertida(stringTeste);

		StringGenerica texto = new StringInvertida("alexsandro");
		System.out.println(texto.tranformarString());

		texto = new StringMinuscula("MATIAS");
		System.out.println(texto.tranformarString());

		texto = new StringMaiuscula("matias");
		System.out.println(texto.tranformarString());

	}
}
