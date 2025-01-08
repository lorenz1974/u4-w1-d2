package u4.d2;

// SIM.java
class SIM {
    private String numeroTelefono;
    private double credito;
    private Chiamata[] listaChiamate;
    private int indiceChiamate;

    // Costruttore
    public SIM(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
        this.credito = 0.0;
        this.listaChiamate = new Chiamata[5]; // Array per contenere al massimo 5 chiamate
        this.indiceChiamate = 0;
    }

    public void aggiungiChiamata(int durata, String numeroChiamato) {
        Chiamata nuovaChiamata = new Chiamata(durata, numeroChiamato);
        this.listaChiamate[indiceChiamate] = nuovaChiamata;
        this.indiceChiamate = (indiceChiamate + 1) % listaChiamate.length; // Ciclo circolare
    }

    public void stampaDatiSIM() {
        System.out.println("Numero di telefono: " + numeroTelefono);
        System.out.println("Credito disponibile: " + credito + " euro");
        System.out.println("Ultime 5 chiamate effettuate:");
        int durataTotale = 0;
        for (int i = 0; i < listaChiamate.length; i++) {
            Chiamata chiamata = listaChiamate[i];
            if (chiamata != null) {
                System.out.println("- Durata: " + chiamata.getDurata() + " minuti, Numero chiamato: "
                        + chiamata.getNumeroChiamato());
            }
            durataTotale += chiamata.getDurata();
        }
        System.out.println("Durata totale delle chiamate: " + durataTotale + " minuti");
    }

    public void ricaricaCredito(double importo) {
        if (importo > 0) {
            this.credito += importo;
        }
    }

    public double getCredito() {
        return this.credito;
    }
}

class Chiamata {
    private int durata; // Durata in minuti
    private String numeroChiamato;

    public Chiamata(int durata, String numeroChiamato) {
        this.durata = durata;
        this.numeroChiamato = numeroChiamato;
    }

    public int getDurata() {
        return this.durata;
    }

    public String getNumeroChiamato() {
        return this.numeroChiamato;
    }
}

public class Main2 {
    public static void main(String[] args) {
        // Crea un'istanza di SIM
        SIM miaSIM = new SIM("3331234666");

        // Aggiunge credito
        miaSIM.ricaricaCredito(20.0);

        // Aggiunge chiamate
        miaSIM.aggiungiChiamata(10, "3339876001");
        miaSIM.aggiungiChiamata(5, "3335551002");
        miaSIM.aggiungiChiamata(15, "3336667003");
        miaSIM.aggiungiChiamata(8, "3337771004");
        miaSIM.aggiungiChiamata(12, "3338882005");
        miaSIM.aggiungiChiamata(7, "3339993006"); // Questa sostituisce la chiamata più vecchia

        // Stampa i dati della SIM
        miaSIM.stampaDatiSIM();
    }
}
