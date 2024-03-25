package atividades.singleton;

class Incremental
{
	// Implementação antes do Singleton
	// private static int count = 0;
	// private int numero;
	//
	// public Incremental() {
	// numero = ++count;
	// }
	//
	// public String toString() {
	// return " Incremental " + numero;
	// }}
	//
	// implementação depois do Singleton
	private static Incremental instance;
	private static int count = 0;
	private int numero;
	
	private Incremental()
	{
		numero = ++count;
	}
	
	public String toString()
	{
		return " Incremental " + numero;
	}
	
	public static Incremental getInstance()
	{
		if (instance == null)
		{
			instance = new Incremental();
			instance.toString();
		}
		return instance;
	}
}