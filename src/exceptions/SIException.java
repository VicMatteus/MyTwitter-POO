package exceptions;

public class SIException extends Exception
{
	
	public SIException()
	{
		super("Seguidor Inválido. Não é permitido seguir a si mesmo!");
	}
}
