package u4.d2;

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
