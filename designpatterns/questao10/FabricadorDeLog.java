package questao10;

public class FabricadorDeLog
{
	public String tipoDoLog;
	
	public FabricadorDeLog(String tipo)
	{
		tipoDoLog = tipo.toLowerCase();
	}
	
	public FabricadorDeLog criarLog()
	{
		if (this.tipoDoLog.contains("arquivo"))
		{
//			new GeradorArquivo();
		}
		return null;
	}
}
