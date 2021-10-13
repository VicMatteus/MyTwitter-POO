import exceptions.*;

import java.util.Vector;

public class Expositor
{
	private Check verificador = new Check();
	
	public void printarTimeline(String usuario, Vector<Tweet> timeline, RepositorioVector repositorio) throws PIException, PDException
	{
		if(verificador.check2(repositorio, usuario)){
			System.out.println("Esta é a timeline de " + usuario + "\n");
			for(Tweet tweet : timeline){
				
				System.out.println("Usuário: " + tweet.getUsuario());
				System.out.println("Mensagem: " + tweet.getMensagem() + "\n");
		    }
		}	
	}
	public void printarTweets(String usuario, Vector<Tweet> timeline, RepositorioVector repositorio) throws PIException, PDException
	{
		if(verificador.check2(repositorio, usuario)){
			System.out.println("Estes são os tweets de " + usuario + "\n");
			for(Tweet tweet : timeline)
			{
				System.out.println("Usuário: " + tweet.getUsuario());
				System.out.println("Mensagem: " + tweet.getMensagem() + "\n");
			}
		}
	}
	public void printarUsuarios(Vector<Perfil> usuarios, MyTwitter myTwitter) throws PIException, PDException
	{
		if(usuarios.size()!=0)
		{
			System.out.println("O MyTwitter atualmente conta com " + usuarios.size() + " usuários.");
			System.out.print("Sendo eles: \n");
			for(Perfil perfil : usuarios)
			{
				System.out.println("Usuário: " + perfil.getUsuario());
				System.out.println("Ativo? " + perfil.isAtivo());
				System.out.println("Número de seguidores: " + Integer.toString(myTwitter.numeroSeguidores(perfil.getUsuario())) + "\n");
			}
		}
		else
		{
			System.out.println("O MyTwitter atualmente não possui usuários.");
		}
	}
	public void printarSeguidores(String usuario, Vector<Perfil> seguidores, RepositorioVector repositorio) throws PDException, PIException
	{
		if(verificador.check2(repositorio, usuario)){
			System.out.println("Os seguidores de " + usuario +" são: ");
			for(Perfil perfil : seguidores)
			{
				if(verificador.check2(repositorio, perfil.getUsuario()))
				{
					System.out.println("Usuário: " + perfil.getUsuario());
				}
			}
	    }
	}
	public void printarSeguidos(String usuario, Vector<Perfil> seguidos, RepositorioVector repositorio) throws PIException, PDException
	{
		if(verificador.check2(repositorio, usuario)){
			System.out.println("O usuário " + usuario + " segue: ");
			for(Perfil perfil : seguidos)
			{
				if(verificador.check2(repositorio, perfil.getUsuario()))
				{
					System.out.println("Usuário: " + perfil.getUsuario());
				}
			}
		}
	}
	
}
