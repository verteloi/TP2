package stationnement;

public class Borne {
    private String transactionCourante;
    private double banque;

    private static double PRIX_G = 4.25;      // $/h
    private static double PRIX_SQ = 2.25;     // $/h

    public Borne(String transactionCourante, double banque) {
        this.transactionCourante = transactionCourante;
        this.banque = banque;
    }

    public String getTransactionCourante() {
        return transactionCourante;
    }

    public void setTransactionCourante(String transactionCourante) {
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

    public boolean validerBorne(String borne) {
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

    public boolean tempsMaximum (int minutes) {
        if (minutes <= 120)
            return true;
        return false;
    }
}
