import exceptions.*;

import java.util.Vector;

public class MyTwitter implements ITwitter 
{
	private IRepositorioUsuario repositorio;
	private Check verificador = new Check();
	private Vector<Perfil> usuarios = new Vector<Perfil>();
	
	public MyTwitter(IRepositorioUsuario repositorio)
	{
		this.repositorio = repositorio;
	}
	
	
	public void criarPerfil(Perfil usuario) throws UJCException, PEException
	{

		repositorio.cadastrar(usuario);
		if(verificador.check2(repositorio, usuario.getUsuario()))
		{
			usuarios.add(usuario);
		}
	}

	public void cancelarPerfil(String usuario) throws PIException, PDException
	{
		if(verificador.check(repositorio, usuario))
		{
			repositorio.buscar(usuario).setAtivo(false);
		}
	}

	public void tweetar(String usuario, String mensagem) throws PIException, MFPException, PDException
	{
		try 
		{	
			if(verificador.check(repositorio, usuario))
			{
				if(mensagem.length() >= 1 && mensagem.length() <= 140)
				{
					Tweet tweet = new Tweet();
					tweet.setMensagem(mensagem);
					tweet.setUsuario(usuario);
					
					Perfil blogger = repositorio.buscar(usuario);
					blogger.addTweet(tweet);
					
					for(Perfil perfil : blogger.getSeguidores())
					{
						if(verificador.check(repositorio, perfil.getUsuario()))
						{
							perfil.addTweet(tweet);
						}
					}
				}
				else
				{
					throw new MFPException();
				}
			}
		}	
		 catch(MFPException mfpe)
		{
			 System.out.println(mfpe.getMessage()); 
		}
	}

	public Vector<Tweet> timeline(String usuario) throws PIException, PDException
	{
		Perfil perfil = repositorio.buscar(usuario);
		if(verificador.check(repositorio, usuario))
		{
			return perfil.getTimeline();
		}
		else
		{
			return null;
		}
	}

	public Vector<Tweet> tweets(String usuario) throws PIException, PDException 
	{
		
		if(verificador.check(repositorio, usuario)) {
			
			Vector<Tweet> tweetsDoBlogger = new Vector<Tweet>();
			Perfil perfil = repositorio.buscar(usuario);
			for(Tweet tweet : perfil.getTimeline())
			{
				if(tweet.getUsuario().equals(usuario))
				{
					tweetsDoBlogger.add(tweet);
				}
			}
			return tweetsDoBlogger;
			
		}
		
		return null;
	}

	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException 
	{
		try 
		{		
			if(verificador.check(repositorio, seguidor))
			{
				if(verificador.check(repositorio, seguido))
				{
					Perfil perfSeguidor = repositorio.buscar(seguidor);
					Perfil perfSeguido = repositorio.buscar(seguido);
				
					if(perfSeguidor!=perfSeguido)
					{
						perfSeguidor.addSeguidos(perfSeguido);
						perfSeguido.addSeguidor(perfSeguidor);
					}
					else
					{
						throw new SIException();
					}
				}	
			}
			
		}
		catch(SIException sie)
		{
			System.out.println(sie.getMessage());
		}
	}

	public int numeroSeguidores(String usuario) throws PIException, PDException 
	{
		Vector<Perfil> numSeguidores = new Vector<Perfil>();
		Perfil perfil = repositorio.buscar(usuario);
		if(verificador.check(repositorio, usuario))
		{
			for(Perfil perfSeguidor : perfil.getSeguidores())
			{
				if(verificador.check2(repositorio, perfSeguidor.getUsuario()))
				{
					numSeguidores.add(perfSeguidor);
				}
			}
			return numSeguidores.size();
		}
		else 
		{
			return -1;
		}
	}

	public Vector<Perfil> seguidores(String usuario) throws PIException, PDException 
	{
		Perfil perfil = repositorio.buscar(usuario);
		if(verificador.check(repositorio, usuario))
		{
			return perfil.getSeguidores();
		}
		else
		{
			return null;
		}
	}

	public Vector<Perfil> seguidos(String usuario) throws PIException, PDException 
	{
		Perfil perfil = repositorio.buscar(usuario);
		if(verificador.check(repositorio, usuario))
		{
			return perfil.getSeguidos();
		}
		else
		{
			return null;
		}
	}
	
	public Vector<Perfil> usuarios()
	{
		return usuarios;
	}
}
