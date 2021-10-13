package exceptions;

public class MFPException extends Exception
{
	
	public MFPException()
	{
		super("Mensagem fora do padrão(Mensagem precisa conter entre 1 e 140 caractéres).");
	}

}
