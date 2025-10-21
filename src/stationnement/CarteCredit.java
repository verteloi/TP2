package stationnement;

import java.time.YearMonth;

import static java.time.YearMonth.now;

public class CarteCredit {
    private String numCarte;
    private YearMonth expiration;
    private double solde;

    public CarteCredit(String numCarte, YearMonth expiration, double solde) {
        this.numCarte = numCarte;
        this.expiration = expiration;
        this.solde = solde;
    }

    public String getNumCarte() {
        return numCarte;
    }

    public void setNumCarte(String numCarte) {
        this.numCarte = numCarte;
    }

    public YearMonth getExpiration() {
        return expiration;
    }

    public void setExpiration(YearMonth expiration) {
        this.expiration = expiration;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
        // METTRE UN RANDOM ICI ENTRE 100 et 500
    }

    public boolean verifierExpiration(YearMonth expiration) {
        if (now().getYear() <= expiration.getYear()) {
            if (now().getMonthValue() <= expiration.getMonthValue()) {
                return true;
            }
        }
        return false;
    }

    public void deduireMontant (double montant) {
        if (montant < this.solde) {
            this.solde -= montant;
        }
    }
}
