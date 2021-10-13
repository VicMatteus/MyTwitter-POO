import exceptions.*;

import java.util.Scanner;

public class Principal
{
	public static void main(String[] args) throws PIException, MFPException, UJCException, Exception
	{
		RepositorioVector repo = new RepositorioVector();
		Expositor expor = new Expositor();
		MyTwitter tt = new MyTwitter(repo);
		
		Scanner ler = new Scanner(System.in);
		int opcao, auxI;
		Long auxC;
		String auxT, auxM;
		
		do
		{
			System.out.println("Escolha uma das opções a seguir:");
			System.out.println("1 - Criar Perfil");
			System.out.println("2 - Cancelar Pefil");
			System.out.println("3 - Tweetar");
			System.out.println("4 - Timeline");
			System.out.println("5 - Tweets");
			System.out.println("6 - Seguir");
			System.out.println("7 - Número de Seguidores");
			System.out.println("8 - Mostrar Seguidores");
			System.out.println("9 - Mostrar Seguidos");
			System.out.println("0 - SAIR");;
			opcao = ler.nextInt();
			ler.nextLine();
			
			switch (opcao)
				{
					
					case 0:
					{
						continue;
					}
					case 1:
					{
						System.out.println("O perfil a ser criado será:\n1 - Pessoa Física?\n2 - Pessoa Jurídica?");
						auxI = ler.nextInt();
						ler.nextLine();
						if(auxI == 1)
						{
							System.out.println("Informe o nome do usuário que será criado e seu CPF");
							auxT = ler.nextLine();
							auxC = ler.nextLong();
							PessoaFisica cpf = new PessoaFisica(auxT, auxC);
							tt.criarPerfil(cpf);
							break;
						}
						else
						{
							System.out.println("Informe o nome do usuário que será criado e seu CNPJ.");
							auxT = ler.nextLine();
							auxC = ler.nextLong();
							PessoaJuridica cnpj = new PessoaJuridica(auxT, auxC);
							tt.criarPerfil(cnpj);
							break;
						}
					}
					case 2:
					{
						System.out.println("Digite o usuário que terá o perfil cancelado: ");
						auxT = ler.nextLine();
						tt.cancelarPerfil(auxT);
						break;
					}
					case 3:
					{
						System.out.println("Informe o nome do usuário que fará o tweet.");
						auxT = ler.nextLine();
						System.out.println("Agora informe o conteúdo do tweet(Máximo de 140 caractéres).");
						auxM = ler.nextLine();
						tt.tweetar(auxT, auxM);
						break;
					}
					case 4:
					{
						System.out.println("Informe o nome do usuário que exibirá a timeline.");
						auxT = ler.nextLine();
						expor.printarTimeline(auxT, tt.timeline(auxT), repo);
						break;
					}
					case 5:
					{
						System.out.println("Informe o nome do usuário que exibirá os próprios tweets.");
						auxT = ler.nextLine();
						expor.printarTweets(auxT, tt.tweets(auxT), repo);
						break;
					}
					case 6:
					{
						System.out.println("Digite o nome do usuário atual: ");
						auxT = ler.nextLine();
						System.out.println("Digite o nome do usuário a ser seguido: ");
						auxM = ler.nextLine();
						tt.seguir(auxT, auxM);
						break;
					}
					case 7:
					{
						System.out.println("Digite o nome do usuário atual: ");
						auxT = ler.nextLine();
						if(tt.numeroSeguidores(auxT) != -1)
						{
							System.out.println("O númedo de seguidores de " + auxT + " é " + tt.numeroSeguidores(auxT));
						}
						break;
					}
					case 8:
					{
						System.out.println("Digite o nome do usuário atual: ");
						auxT = ler.nextLine();
						expor.printarSeguidores(auxT, tt.seguidores(auxT), repo);
						break;
					}
					case 9:
					{
						System.out.println("Digite o nome do usuário atual: ");
						auxT = ler.nextLine();
						expor.printarSeguidos(auxT, tt.seguidos(auxT), repo);
						break;
					}
					case 10:
					{
						expor.printarUsuarios(tt.usuarios(), tt);
						break;
					}
					default:
					{
						System.out.println("Insira um comando válido!");
						break;
					}
				}
		}
			while (opcao != 0);
		    ler.close();
		}
}