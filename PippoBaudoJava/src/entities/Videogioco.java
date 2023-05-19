package entities;

public class Videogioco {
    private int id;
    private String titolo;
    private String piattaforma;
    private String genere;
    private int annoDiPubblicazione;
    private String sviluppatore;
    private double valutazione;
    private double prezzo;

    public Videogioco(int id, String titolo, String piattaforma, String genere, int annoDiPubblicazione, String sviluppatore, double valutazione, double prezzo) {
        setId(id);
        setTitolo(titolo);
        setPiattaforma(piattaforma);
        setGenere(genere);
        setAnnoDiPubblicazione(annoDiPubblicazione);
        setSviluppatore(sviluppatore);
        setValutazione(valutazione);
        setPrezzo(prezzo);
    }
    
    public Videogioco(String titolo, String piattaforma, String genere, int annoDiPubblicazione, String sviluppatore, double valutazione, double prezzo) 
    {
        setTitolo(titolo);
        setPiattaforma(piattaforma);
        setGenere(genere);
        setAnnoDiPubblicazione(annoDiPubblicazione);
        setSviluppatore(sviluppatore);
        setValutazione(valutazione);
        setPrezzo(prezzo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public String getSviluppatore() {
        return sviluppatore;
    }

    public void setSviluppatore(String sviluppatore) {
        this.sviluppatore = sviluppatore;
    }

    public double getValutazione() {
        return valutazione;
    }

    public void setValutazione(double valutazione) {
        this.valutazione = valutazione;
    }

    
    public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
    public String toString() 
    {
        return "\nid: " + id 
                + "\n titolo: " + titolo 
                + "\n piattaforma: " + piattaforma 
                + "\n genere: " + genere
                + "\n annoDiPubblicazione: " + annoDiPubblicazione 
                + "\n sviluppatore: " + sviluppatore 
                + "\n valutazione: " + valutazione 
                + "\n prezzo: " + prezzo 
                + "\n----------\n";
    }
}


