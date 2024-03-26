package atividades.abstractmethod;

public abstract class StringGenerica {
	protected String textoInicial;

	public StringGenerica(String textoInicial) {
		this.textoInicial = textoInicial;
	}

	public abstract String tranformarString();

}
