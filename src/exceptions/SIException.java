package exceptions;

public class SIException extends Exception
{
	
	public SIException()
	{
		super("Seguidor Inv�lido. N�o � permitido seguir a si mesmo!");
	}
}
