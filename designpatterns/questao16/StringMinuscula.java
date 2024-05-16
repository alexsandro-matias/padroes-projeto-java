package questao16;

public class StringMinuscula extends StringGenerica {

	public StringMinuscula(String texto) {
		super(texto);
	}

	@Override
	public String tranformarString() {
		return this.textoInicial.toLowerCase();
	}

}
