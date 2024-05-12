package exemplos.abstractmethod;

public class HTML implements Documento
{
	@Override public void imprimir()
	{
		System.out.println("Imprimindo HTML...");
	}
}