import exceptions.*;
import java.util.Vector;

public class RepositorioVector implements IRepositorioUsuario
{
	private Vector<Perfil> vectorPerfis;
	
	public RepositorioVector()
	{
		vectorPerfis = new Vector<Perfil>();
	}
	public void cadastrar(Perfil usuario) throws UJCException
	{
		try
		{
			if(vectorPerfis.size() == 0)
			{
				vectorPerfis.add(usuario);
			}
			else
			{
				Perfil perfil = buscar(usuario.getUsuario());
				if(perfil == null)
				{
					vectorPerfis.add(usuario);
				}
				else
				{
					throw new UJCException(usuario.getUsuario());
				}
			}
		}
		catch(UJCException ujce)
		{
			System.out.println(ujce.getMessage());
		}
		
	}

	public Perfil buscar(String usuario)
	{
		for(Perfil perfil : vectorPerfis)
		{
			if(perfil.getUsuario().equals(usuario))
			{
				return perfil;
			}
		}
		return null;
	}
	
	public void atualizar(Perfil usuario) throws UNCException
	{
		Perfil perfil = buscar(usuario.getUsuario());
		if(perfil == null)
		{
			throw new UNCException();
		}
	}

	public Vector<Perfil> usuarios()
	{
		return vectorPerfis;
	}
}
