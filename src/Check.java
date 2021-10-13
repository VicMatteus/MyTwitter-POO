import exceptions.*;

public class Check
{
	public boolean check(IRepositorioUsuario repositorio, String usuario) throws PIException, PDException 
	{
		try 
		{		
			if(repositorio.buscar(usuario) == null)
			{
				throw new PIException(usuario);
			}
			else
			{
				if(repositorio.buscar(usuario).isAtivo())
				{
					return true;
				}
				else
				{
					throw new PDException(usuario);
				}
			}
		}
		catch(PIException pie)
		{
			System.out.println(pie.getMessage() + " para o usuário: " + pie.getUsuario());
			return false;
		}
		catch(PDException pde)
		{
			System.out.println(pde.getMessage() + " para o usuário " + pde.getUsuario());
			return false;
		}
	}
	
	public boolean check2(IRepositorioUsuario repositorio, String usuario) 
	{ 			
		if(repositorio.buscar(usuario) == null)
		{
			return false;
		}
		else
		{
			if(repositorio.buscar(usuario).isAtivo())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
		
}
