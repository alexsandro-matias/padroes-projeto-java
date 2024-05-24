package questao02;

import java.util.Random;

public interface EstrategiaOrdenacao
{
	public int[] ordenacaoVetor(int[] vetorDesordenado);
	
	Random random = new Random();
	
	public default void imprimeVetor(int[] vetor)
	{
		for (int i = 0; i < vetor.length; i++)
		{
			System.out.print(vetor[i] + " , ");
		}
	}
	
	public default long calculaTempoDeExecucao(int[] vetorDesordenado)
	{
		long intervalo, inicio, fim;
		inicio = System.nanoTime();
		int[] resultado;
		resultado = ordenacaoVetor(vetorDesordenado);
		fim = System.nanoTime();
		intervalo = fim - inicio;
		imprimeVetor(resultado);
		return intervalo;
	}
	
	public default int[] criaVetorAleatorio(int tamanho)
	{
		int[] vetorRetornado = new int[tamanho];
		for (int i = 0; i < vetorRetornado.length; i++)
		{
			vetorRetornado[i] = random.nextInt(100) + 1;
		}
		return vetorRetornado;
	}
}
