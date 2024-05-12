package atividades.strategy;

public class Merge extends OrdenacaoGenerica implements EstrategiaOrdenacao
{
	@Override protected void executaEstrategiaOrdenacao()
	{
		int esquerda = 0, medio = 0, direita = 0;
		int n1 = medio - esquerda + 1;
		int n2 = direita - medio;
		/* Cria arrays temporários */
		int L[] = new int[n1];
		int R[] = new int[n2];
		/* Copia os dados para os arrays temporários */
		for (int i = 0; i < n1; ++i) L[i] = vetorDesordenado[esquerda + i];
		for (int j = 0; j < n2; ++j) R[j] = vetorDesordenado[medio + 1 + j];
		/* Mescla os arrays temporários */
		// Índices iniciais do primeiro e segundo subarrays
		int i = 0, j = 0;
		// Índice inicial do subarray mesclado
		int k = esquerda;
		while(i < n1 && j < n2)
		{
			if (L[i] <= R[j])
			{
				vetorDesordenado[k] = L[i];
				i++;
			}
			else
			{
				vetorDesordenado[k] = R[j];
				j++;
			}
			k++;
		}
		/* Copia os elementos restantes de L[], se houver */
		while(i < n1)
		{
			vetorDesordenado[k] = L[i];
			i++;
			k++;
		}
		/* Copia os elementos restantes de R[], se houver */
		while(j < n2)
		{
			vetorDesordenado[k] = R[j];
			j++;
			k++;
		}
	}


}
