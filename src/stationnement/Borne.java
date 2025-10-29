package stationnement;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;

import static java.time.YearMonth.now;

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

    public boolean verifierHeure(String borne) {
        LocalDateTime current = LocalDateTime.now();
        if (borneType(borne).equals("G")) {
            if (current.getDayOfWeek() == DayOfWeek.SUNDAY) {
                return current.getHour() >= 13 && current.getHour() < 18;
            } else if (current.getDayOfWeek() == DayOfWeek.SATURDAY) {
                return current.getHour() >= 9 && current.getHour() < 23;
            }
            else {
                return current.getHour() >= 8 && current.getHour() < 23;
            }
        } else {
            if (current.getDayOfWeek() == DayOfWeek.SUNDAY) {
                return false;
            } else if (current.getDayOfWeek() == DayOfWeek.SATURDAY) {
                return current.getHour() >= 9 && current.getHour() < 18;
            } else {
                return current.getHour() >= 9 && current.getHour() < 21;
            }
        }
    }

    public String borneType (String borne) {
        String type = String.valueOf(borne.charAt(0));
        if (type.equals("G")) {
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

        if (borneType(place).equals("G")) {
            minutes = (montant / 425) * 60;
        } else {
            minutes = (montant / 225) * 60;
        }

        return (int)minutes;
    }

    public boolean tempsMaximum (int minutes) {
        if (minutes < 120)
            return true;
        return false;
    }

    public double ajouterMaximum(double montant, String place) {
        if (borneType(place).equals("G")) {
            montant = 850;
        } else {
            montant = 450;
        }

        return montant;
    }

    public void terminerTransaction() {
        banque+= transactionCourante.getMontant();
    }

//    public boolean verifierExpiration(CarteCredit carte) {
//        if (now().getYear() <= expiration.getYear()) {
//            if (now().getMonthValue() <= expiration.getMonthValue()) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean validerCarte(String dateExp) {
////        YearMonth exp = YearMonth.of(12, 24);
////        CarteCredit c = new CarteCredit(213123, exp)
//
//    }
}
