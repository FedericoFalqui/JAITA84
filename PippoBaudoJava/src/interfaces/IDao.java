package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entities.Videogioco;


public interface IDao {

	//CRUD
	//Read
	public List<Videogioco> read();
	//Create
	public void create(Videogioco v);
	//Update
	public void update(Videogioco v);
	//Delete
	public void delete(int id);

	default String stampaElenco() 
	{
		String ris = "";
		for(Videogioco v : read())
		{
			ris += v.toString();
		}
		return ris;
	}

	default String affordable() 
	{
		String stampa = "";
		String ris = "";

		ArrayList<Integer> ids = new ArrayList<Integer>();
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci il tuo budget");
		int i = 0;

		double budget = Double.parseDouble(tastiera.nextLine());
		double iniz = budget;
		do {
			int index = (int) (Math.random() * read().size());
			Videogioco v = read().get(index);

			if (v.getPrezzo() <= budget && !ids.contains(v.getId())) 
			{ 
				stampa += "★" +v.getTitolo() + " -" + v.getPrezzo() + "€\n";
				i++;

				ids.add(v.getId());
				budget -= v.getPrezzo();

			}



		}while (budget >= prezzoMin() && i < read().size()); // && Affordabili.size() < read().size

		ris = "---------------\nSei rimasto con " + String.format("%.2f", budget) + " euro di budget" + "\n";
		//tastiera.close();
		return "Con un budget di " + iniz + "€\nhai potuto acquistare questi " + i + " giochi! \n---------------\n" + stampa + ris;
	}

	default Double prezzoMin() 
	{
		double min = Double.MAX_VALUE;
		for (Videogioco v : read()) 
		{
			if (v.getPrezzo() <= min) 
			{
				min = v.getPrezzo();
			}
		}
		return min;
	}

	default Double prezzoMax() 
	{
		double max = Double.MIN_VALUE;
		for (Videogioco v : read()) 
		{
			if (v.getPrezzo() >= max) 
			{
				max = v.getPrezzo();
			}
		}
		System.out.println(max);
		return max;
	}

	default String trovaPerGenere(String genere) 
	{

		String ris = "";
		for (Videogioco v : read()) 
		{
			if (v.getGenere().toLowerCase().contains(genere.toLowerCase())) 
			{
				ris += v.toString();
			}
		}

		return ris;
	}

	default String trovaPerConsole(String console) 
	{

		String ris = "";
		for (Videogioco v : read()) {
			if (v.getPiattaforma().toLowerCase().contains(console.toLowerCase())) 
			{
				ris += v.toString();
			}
		}

		return ris;
	}

	default String trovaPerNome(String nome)
	{
		String ris = "";
		for (Videogioco v : read()) 
		{
			if (v.getTitolo().toLowerCase().contains(nome.toLowerCase())) 
			{
				ris += v.toString();
			}
		}

		return "Cercavi questo? " + ris;
	}

	default String compara(String nome1, String nome2)
	{
		String ris = "";
		double voto1 = 0;
		double voto2 = 0;
		String temp1 = "";
		String temp2 = "";
		for (Videogioco v : read()) 
		{
			if (v.getTitolo().toLowerCase().contains(nome1.toLowerCase())) 
			{
				ris += v.toString();
				voto1 = v.getValutazione();
				temp1 = v.toString();
			}

			if (v.getTitolo().toLowerCase().contains(nome2.toLowerCase())) 
			{
				ris += v.toString();
				voto2 = v.getValutazione();
				temp2 = v.toString();
			}

			if(voto1 > voto2)
			{
				ris = "Il migliore tra i due è: " + temp1;
			}
			else
			{
				ris = "Il migliore tra i due è: " + temp2;
			}


		}

		return ris;
	}

	default String contacaratteri(String parola1) 
	{

		String ris = "";
		String lettere = "";
		int maxCount = 0;
		int conta = 0;
		String imigliori = "";
		Videogioco maxVideogioco = null;

		for (Videogioco v : read()) 
		{
			String titolo = v.getTitolo().toLowerCase();
			int count = 0;
			int length = Math.min(parola1.length(), titolo.length());
			for (int i = 0; i < length; i++) 
			{
				if (parola1.charAt(i) == titolo.charAt(i)) 
				{
					lettere += parola1.charAt(i);
					count++;
				}
			}

			//		        if(count > conta)
			//		        {
			//		        	System.out.println("Ciao");
			//		        	conta = count;
			//		        	imigliori += v.toString() + "\n" + "Con " + count + " lettere in comune \n";
			//		        	
			//		        }

			if (count > maxCount) 
			{
				maxCount = count;
				maxVideogioco = v;
			}
		}
		ris += "Il videogioco con il maggior numero di lettere in comune con \n\"" + parola1 + "\" è:\n" + maxVideogioco.toString() + "\nCon " + maxCount + " lettere in comune.\n";

		return ris + "\n" + imigliori;
	}

	default String scontoGiochi(String titolo) 
	{
		String ris = "";
		int annoCorrente = 2023, sconto = 10;
		double prezzoScontato;

		for (Videogioco v : read()) 
		{
			if (v.getTitolo().equalsIgnoreCase(titolo)) 
			{
				int annoGioco = v.getAnnoDiPubblicazione();
				if (annoCorrente - annoGioco >= 8) 
				{
					prezzoScontato = v.getPrezzo() - sconto;
					ris = titolo + " e' scontato e costa " + String.format("%.2f", prezzoScontato);
				} 
				else 
				{
					ris = titolo + " non e' scontato";
				}
				break; // Esci dal ciclo una volta trovato il videogioco corrispondente al titolo
			}
		}
		return ris;
	}

	default String carrellodellaspesa()
	{
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci il tuo budget");
		Double budget = Double.parseDouble(tastiera.nextLine());
		String continua = "";

		//String id;
		int id;
		int i = 1;
		String ris = "";
		ArrayList<String> giochis = new ArrayList<String>();
		ArrayList<String> acquistati = new ArrayList<String>();

		for(Videogioco v : read())
		{
			giochis.add((i++) +") " +  v.getTitolo() + " |" + v.getPrezzo() + "€\n");
		}

		do
		{

			System.out.println(giochis);
			System.out.println("Inserisci l'ID del gioco che vuoi comprare");
			//id = tastiera.nextLine();
			id = Integer.parseInt(tastiera.nextLine());


			if (id == giochis.size()+1) {
				acquistati.add(giochis.get(id-2));
				System.out.println("Hai acquistato: "  + giochis.get(id-2));
				System.out.println("Abbiamo rimosso " + giochis.get(id-2));
				giochis.remove(giochis.get(id-2));
			}else {
				acquistati.add(giochis.get(id-1));
				System.out.println("Hai acquistato: "  + giochis.get(id-1));
				System.out.println("Abbiamo rimosso " + giochis.get(id-1));
				giochis.remove(giochis.get(id-1));
			}

			System.out.println("Vuoi comprare un'altro gioco?");
			continua = tastiera.nextLine();
			if(continua.equalsIgnoreCase("no"))
			{
				System.out.println("BREAK");
				//System.out.println("IN POSIZIONE " + id + " c'è " + read().get(id - 1));

				break;
			}

		}while(continua != "No");

		//System.out.println(giochis);

		for(String s : acquistati)
		{
			ris += s;
		}

		return ris;

	}

	default String carrellodellaspesa2()
	{
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci il tuo budget");
		Double budget = Double.parseDouble(tastiera.nextLine());
		String continua = "";

		//String id;
		int id;
		int i = 1;
		String ris = "";
		List<Videogioco> giochi = new ArrayList<>(read());
		List<Videogioco> acquistati = new ArrayList<>();
		List<Videogioco> temp = new ArrayList<>();

		temp = giochi;
		do
		{
			if (budget > prezzoMin()) {
				System.out.println("Lista dei giochi disponibili:");
				System.out.println("Il tuo budget rimanente è: " + budget);
				for (Videogioco v : temp) {
					System.out.println(v.getId() + " | " + v.getTitolo() + " | " + v.getPrezzo());
				}
				System.out.println("Inserisci l'ID del gioco che vuoi comprare");
				//id = tastiera.nextLine();
				id = Integer.parseInt(tastiera.nextLine());

				Iterator<Videogioco> iterator = temp.iterator();
				while (iterator.hasNext()) {
					Videogioco v = iterator.next();

					if (v.getId() == id) {
						if (v.getPrezzo() < budget) {
							acquistati.add(v);
							System.out.println("Hai acquistato: " + v.getTitolo());
							budget -= v.getPrezzo();
							System.out.println("Budget rimanente: " + budget);
							iterator.remove();
							break;
						}else {
							System.out.println("Il tuo budget non ti permette di comprare questo gioco");
							continua = "No";
						}
					}
				}

				System.out.println("Vuoi comprare un'altro gioco?");
				continua = tastiera.nextLine();
				if(continua.equalsIgnoreCase("no"))
				{
					System.out.println("BREAK");
					break;
				}
			} else {
				System.out.println("\nHai finito il budget");
				continua = "No";
			}

		}while(continua != "No");

		for(Videogioco v : acquistati)
		{
			ris += v.getTitolo() + " | " + v.getPrezzo() + "\n";
		}

		return ris;
	}

	void insertGames();
	
	void createUtente();

	void update(int id, String campoDaModificare);

}