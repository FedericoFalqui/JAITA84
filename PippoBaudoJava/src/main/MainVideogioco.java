package main;

import java.util.Scanner;

import dao.DaoVideogioco;
import entities.Videogioco;
import interfaces.IDao;

public class MainVideogioco
{

	public static void main(String[] args)
	{
		String nomeDb = "videogiochi";
		IDao d = new DaoVideogioco(nomeDb, "root", "root");

		Scanner tastiera = new Scanner(System.in);
		int scelta = 0;
		String testo = "";
		String nome1 = "";
		String nome2 = "";

		do
		{
			System.out.println("1) Stampa elenco videogiochi" 									+ 
					"\n2) Create" 																+
					"\n3) Update" 																+
					"\n4) Delete" 																+
					"\n5) Aggiungi tu un videogioco" 											+
					"\n6) Aggiorna la caratteristica che preferisci di un videogioco" 			+
					"\n7) Aggiungi videogiochi da file txt" 									+
					"\n8) Scopri quali giochi random puoi acquistare con un tot di budget"		+
					"\n9) Mostra tutti i giochi per una console a tua scelta"					+
					"\n10) Mostra tutti i giochi per un genere a tua scelta"					+
					"\n11) Mostra i giochi per un titolo a tua scelta"							+
					"\n12) Compara i voti di due titoli e trova il migliore"					+
					"\n13) Trova il miglior risultato in base al nome da te inserito" 			+
					"\n14) Cancella in base all'id a tua scelta" 								+
					"\n15) Verifica se il gioco è scontato" 									+
					"\n16) Carrello" 															+
					"\n0)  Esci");
			scelta = Integer.parseInt(tastiera.nextLine());

			switch(scelta)
			{
			case 1:
				System.out.println("Elenco:\n" + d.stampaElenco());
				break;

			case 2:
				Videogioco videogioco = new Videogioco("Fortnite", "Nintendo Switch", "Platformer", 2020, "Nintendo", 9.0, 57.99);
				d.create(videogioco);
				break;

			case 3:
				Videogioco update = new Videogioco(6, "Fortnite", "Nintendo DS", "Platformer", 2020, "Valve", 9.0, 37.99);
				d.update(update);
				break;

			case 4:
				d.delete(23);
				break;

			case 5:
				d.createUtente();
				break;

			case 6:
				System.out.println("Inserisci l'id del gioco che vuoi modificare");
				int sceltaId = Integer.parseInt(tastiera.nextLine());
				System.out.println("Cosa vuoi modificare?");
				String scelta2 = tastiera.nextLine();
				d.update(sceltaId, scelta2);
				break;

			case 7:
				d.insertGames();
				break;

			case 8:
				System.out.println(d.affordable());
				break;

			case 9:
				System.out.println("Inserisci la console");
				testo = tastiera.nextLine();
				System.out.println(d.trovaPerConsole(testo));
				break;

			case 10:
				System.out.println("Inserisci il genere");
				testo = tastiera.nextLine();
				System.out.println(d.trovaPerGenere(testo));
				break;

			case 11:
				System.out.println("Inserisci il nome del gioco che stai cercando");
				testo = tastiera.nextLine();
				System.out.println(d.trovaPerNome(testo));
				break;

			case 12:
				System.out.println("Inserisci il nome del gioco che dev'essere comparato");
				nome1 = tastiera.nextLine();
				System.out.println("Inserisci il nome del gioco con cui lo vuoi comparare");
				nome2 = tastiera.nextLine();
				System.out.println(d.compara(nome1, nome2));
				break;

			case 13:
				System.out.println("Inserisci il gioco da cercare e troveremo l'affinità migliore");
				nome1 = tastiera.nextLine();
				System.out.println(d.contacaratteri(nome1));
				break;
				
			case 14:
				System.out.println("Inserisci l'id del gioco che desideri cancellare");
				int sceltaId2 = Integer.parseInt(tastiera.nextLine());
				d.delete(sceltaId2);
				break;

			case 15:

				System.out.println("Inserisci il titolo del gioco e saprai se è scontato");
				String titolo = tastiera.nextLine();
				System.out.println(d.scontoGiochi(titolo));

				break;
				
			case 16:

				System.out.println(d.carrellodellaspesa2());

				break;

			case 0:
				System.out.println("OK, ciao");
				break;

			default:
				System.out.println("Errore");
				break;
			}

		}while(scelta != 0);

	}
}
