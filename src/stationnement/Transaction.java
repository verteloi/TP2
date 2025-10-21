package stationnement;

import java.time.LocalDateTime;

public class Transaction {
    private String placeStationnement;
    private LocalDateTime heureDebut;
    private LocalDateTime heureFin;
    private double montant;

    public Transaction(String placeStationnement, int duree, double montant) {
        this.placeStationnement = placeStationnement;
        this.montant = montant;
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

}
