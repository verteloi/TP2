package stationnement;

import java.time.LocalDateTime;

public class Transaction {
    private String placeStationnement;
    private String typePaiement = "inconnu";
    private LocalDateTime heureDebut;
    private LocalDateTime heureFin;
    private double montant;

    public Transaction(String placeStationnement) {
        this.placeStationnement = placeStationnement;
    }

    public LocalDateTime getHeureFin() {
        return heureFin;
    }

    public LocalDateTime getHeureDebut() {
        return heureDebut;
    }

    public String getPlaceStationnement() {
        return placeStationnement;
    }

    public void setPlaceStationnement(String placeStationnement) {
        this.placeStationnement = placeStationnement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void ajouter25() {
        this.montant += 25;
    }

    public void ajouter100() {
        this.montant += 100;
    }

    public void ajouter200() {
        this.montant += 200;
    }
}
