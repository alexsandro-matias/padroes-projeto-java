package atividades.abstractmethod;

public class StringMaiuscula extends StringGenerica {

	public StringMaiuscula(String textoInicial) {
		super(textoInicial);
	}

	@Override
	public String tranformarString() {
		return this.textoInicial.toUpperCase();
	}

}
