package stationnement;

public class Borne {
    private Transaction transactionCourante;
    private double banque;

    private static double PRIX_G = 4.25;      // $/h
    private static double PRIX_SQ = 2.25;     // $/h

    public Borne() {
        transactionCourante = null;
        banque = 0;
    }

    public Transaction getTransactionCourante() {
        return transactionCourante;
    }

    public void setTransactionCourante(Transaction transactionCourante) {
        this.transactionCourante = transactionCourante;
    }

    public double getBanque() {
        return banque;
    }

    public void setBanque(double banque) {
        this.banque = banque;
    }

    public double genererRapport(double banque) {
        double montantTotal = banque;
        banque = 0;
        return montantTotal;
    }

    public boolean validerPlace(String borne) {
        String regex = "^(G|SQ)\\d{3}$";
        return borne.matches(regex);
    }

    public String borneType (String borne) {
        String type = String.valueOf(borne.charAt(0));
        if (type == "G") {
            return "G";
        } else return "SQ";
    }

    public double calculerPrix(String zone, int minutes) {
        double prixHeure;
        double cout;

        if (zone.equals("G")) {
            prixHeure = 4.25;
        } else {
            prixHeure = 2.25;
        }

        cout = (minutes / 60.0) * prixHeure;

        return cout;
    }

    public int calculerMinutes(double montant, String place) {
        double minutes = 0;

        if (borneType(place) == "G") {
            minutes = (montant / 425) * 60;
        } else {
            minutes = (montant / 225) * 60;
        }

        //minutes = (int)minutes;
        return (int)minutes;
    }

    public boolean tempsMaximum (int minutes) {
        if (minutes <= 120)
            return true;
        return false;
    }

    public void terminerTransaction() {
        banque+= transactionCourante.getMontant();
    }
}
