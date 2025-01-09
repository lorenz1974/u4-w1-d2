package u4.d2;

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