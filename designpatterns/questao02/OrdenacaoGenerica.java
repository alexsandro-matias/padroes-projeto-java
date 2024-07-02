package questao02;

public abstract class OrdenacaoGenerica implements EstrategiaOrdenacao {

    protected int[] vetorDesordenado;
    protected int[] vetorOrdenado;

    public void preparaVetores(int[] vetorDesordenado) {

//		guarda o vetor desordenado e permite que o getSize() funcione.
        this.vetorDesordenado = vetorDesordenado;

//		cria um novo vetor do tamanho certo (correspondente ao vetor desordenado) 
//		já que o getSize() funciona.
        vetorOrdenado = new int[getSize()];

    }

    public int getSize() {
        return vetorDesordenado.length;
    }

    public int[] ordenacaoVetor(int[] vetorDesordenado) {
        preparaVetores(vetorDesordenado);
        executaEstrategiaOrdenacao();

        return this.vetorOrdenado;

    }

    protected abstract void executaEstrategiaOrdenacao();

}
