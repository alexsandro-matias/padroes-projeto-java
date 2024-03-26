package atividades.abstractmethod;

public class StringInvertida extends StringGenerica {

	public StringInvertida(String texto) {
		super(texto);
	}

	@Override
	public String tranformarString() {
		String stringTranformada = new StringBuilder(this.textoInicial).reverse().toString();
		return stringTranformada;
	}

}
