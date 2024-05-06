package exemplos.abstractmethod;

public class FabricaDocumentos
{
	public Documento criarDocumento(String tipo)
	{
		if (tipo.equals("pdf"))
		{
			return new PDF();
		}
		else if (tipo.equals("word"))
		{
			return new Word();
		}
		else if (tipo.equals("html"))
		{
			return new HTML();
		}
		else
		{
			throw new IllegalArgumentException("Tipo de documento inválido");
		}
	}
}
