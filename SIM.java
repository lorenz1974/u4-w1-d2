package u4.d2;

class SIM {
    private String numeroTelefono;
    private double credito;
    private final Chiamata[] listaChiamate;
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
        for (Chiamata chiamata : listaChiamate) {
            if (chiamata != null) {
                System.out.println("- Durata: " + chiamata.getDurata() + " minuti, Numero chiamato: "
                        + chiamata.getNumeroChiamato());
            }
            durataTotale += chiamata.getDurata();
        }
        System.out.println();
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