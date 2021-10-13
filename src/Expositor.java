import exceptions.*;

import java.util.Vector;

public class Expositor
{
	private Check verificador = new Check();
	
	public void printarTimeline(String usuario, Vector<Tweet> timeline, RepositorioVector repositorio) throws PIException, PDException
	{
		if(verificador.check2(repositorio, usuario)){
			System.out.println("Esta � a timeline de " + usuario + "\n");
			for(Tweet tweet : timeline){
				
				System.out.println("Usu�rio: " + tweet.getUsuario());
				System.out.println("Mensagem: " + tweet.getMensagem() + "\n");
		    }
		}	
	}
	public void printarTweets(String usuario, Vector<Tweet> timeline, RepositorioVector repositorio) throws PIException, PDException
	{
		if(verificador.check2(repositorio, usuario)){
			System.out.println("Estes s�o os tweets de " + usuario + "\n");
			for(Tweet tweet : timeline)
			{
				System.out.println("Usu�rio: " + tweet.getUsuario());
				System.out.println("Mensagem: " + tweet.getMensagem() + "\n");
			}
		}
	}
	public void printarUsuarios(Vector<Perfil> usuarios, MyTwitter myTwitter) throws PIException, PDException
	{
		if(usuarios.size()!=0)
		{
			System.out.println("O MyTwitter atualmente conta com " + usuarios.size() + " usu�rios.");
			System.out.print("Sendo eles: \n");
			for(Perfil perfil : usuarios)
			{
				System.out.println("Usu�rio: " + perfil.getUsuario());
				System.out.println("Ativo? " + perfil.isAtivo());
				System.out.println("N�mero de seguidores: " + Integer.toString(myTwitter.numeroSeguidores(perfil.getUsuario())) + "\n");
			}
		}
		else
		{
			System.out.println("O MyTwitter atualmente n�o possui usu�rios.");
		}
	}
	public void printarSeguidores(String usuario, Vector<Perfil> seguidores, RepositorioVector repositorio) throws PDException, PIException
	{
		if(verificador.check2(repositorio, usuario)){
			System.out.println("Os seguidores de " + usuario +" s�o: ");
			for(Perfil perfil : seguidores)
			{
				if(verificador.check2(repositorio, perfil.getUsuario()))
				{
					System.out.println("Usu�rio: " + perfil.getUsuario());
				}
			}
	    }
	}
	public void printarSeguidos(String usuario, Vector<Perfil> seguidos, RepositorioVector repositorio) throws PIException, PDException
	{
		if(verificador.check2(repositorio, usuario)){
			System.out.println("O usu�rio " + usuario + " segue: ");
			for(Perfil perfil : seguidos)
			{
				if(verificador.check2(repositorio, perfil.getUsuario()))
				{
					System.out.println("Usu�rio: " + perfil.getUsuario());
				}
			}
		}
	}
	
}
