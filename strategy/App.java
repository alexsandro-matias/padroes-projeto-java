package strategy;

public class App {

	public static void main(String[] args) {

		// criar um vetor enorme com 1_000_000 de elementos e medir o tempo de execução
		// de ordenação e depois consertar o bolha ou comparar a implementação padrão da
		// classe Arrays com a minha própria implementação

		// trocar implementação do vetorAleatorio para Random e comparar os tempos.

		EstrategiaOrdenacao estrategia = new Bolha();
		EstrategiaOrdenacao estrategia2 = new Insercao();
//		EstrategiaOrdenacao estrategia3 = new Merge();

		int[] vetor = estrategia.criaVetorAleatorio(5);
//		int[] resultado = estrategia.ordenacaoVetor(vetorQualquer);
		long tempoExecucao = estrategia.calculaTempoDeExecucao(vetor);
		System.out.println("Tempo de execução: " + tempoExecucao);

		long tempoExecucao2 = estrategia2.calculaTempoDeExecucao(vetor);
		System.out.println("Tempo de execução: " + tempoExecucao2);

//		long tempoExecucao3 = estrategia3.calculaTempoDeExecucao(vetor);
//		System.out.println("Tempo de execução: " + tempoExecucao3);

	}

}
