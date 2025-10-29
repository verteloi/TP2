package stationnement;

import java.time.LocalDateTime;

public class Transaction {
    private String placeStationnement;

    private String typePaiement = "inconnu";
    private double montant;

    public Transaction(String placeStationnement) {
        this.placeStationnement = placeStationnement;
    }

    public void setHeureFin(LocalDateTime heureFin) {

    }

    public String getPlaceStationnement() {
        return placeStationnement;
    }

    public void setPlaceStationnement(String placeStationnement) {
        this.placeStationnement = placeStationnement;
    }

    public String getTypePaiement() {
        return typePaiement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void ajouter25() {
        this.montant += 25;
        if (typePaiement == "inconnu")
            typePaiement = "comptant";
    }

    public void ajouter100() {
        this.montant += 100;
        if (typePaiement == "inconnu")
            typePaiement = "comptant";
    }

    public void ajouter200() {
        this.montant += 200;
        if (typePaiement == "inconnu")
            typePaiement = "comptant";
    }

    public void carteAjouter25() {
        this.montant += 25;
        if (typePaiement == "inconnu")
            typePaiement = "carte";
    }

    public void carteRetirer25() {
        this.montant -= 25;
        if (typePaiement == "inconnu")
            typePaiement = "carte";
    }
}
