package atividades.singleton;

public class TesteIncremental
{
	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			// Com essa implentação, o valor do toString sempre vai incrementar
			// o valor da
			// variável.
			// Incremental inc = new Incremental();
			// A partir desta implementação o método estático, agora a mesma
			// instância
			// sempre será apontada.
			Incremental inc = Incremental.getInstance();
			System.out.println(inc);
		}
	}
}
