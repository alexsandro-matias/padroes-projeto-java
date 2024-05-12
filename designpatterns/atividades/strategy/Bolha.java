package atividades.strategy;

import java.util.Arrays;

public class Bolha extends OrdenacaoGenerica
{
	@Override protected void executaEstrategiaOrdenacao()
	{
		Arrays.sort(this.vetorDesordenado);
		vetorOrdenado = vetorDesordenado;
	}
}