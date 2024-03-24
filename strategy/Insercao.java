package strategy;

public class Insercao extends OrdenacaoGenerica {

	@Override
	protected void executaEstrategiaOrdenacao() {

		for (int i = 1; i < vetorDesordenado.length; i++) {
			int auxiliar = vetorDesordenado[i];
			int j = i;

			while (j >= 0 && vetorOrdenado[j-1] > auxiliar) {
				vetorOrdenado[j] = vetorOrdenado[j-1];
				j = j - 1;
			}

			vetorOrdenado[j] = auxiliar;
		}

	}

}
