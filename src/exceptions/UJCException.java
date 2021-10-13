package exceptions;

public class UJCException extends Exception
{	
	private String usuario;
	public UJCException(String usuario)
	{
		super("Usu�rio " + usuario + " j� cadastrado.");
		this.usuario = usuario;
	}
	public String getUsuario()
	{
		return usuario;
	}
}
