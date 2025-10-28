package stationnement;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GUITP2 {
    private JPanel panel1;
    private JLabel labelLogo;
    private JPanel panelNumeros;
    private JPanel panelOperations;
    private JPanel panelComptant;
    private JTextArea champMessage;
    private JButton bouton25;
    private JButton bouton100;
    private JButton bouton200;
    private JPanel panelCredit;

    private JTextArea zoneRecu;
    private JButton boutonRapport;
    private JFormattedTextField champNumeroCarte;
    private JFormattedTextField champDateExp;
    private JButton boutonValiderDateExp;
    private JPanel panelControles;
    private JButton boutonMax;
    private JButton boutonPlus;
    private JButton boutonMoins;
    private JButton boutonOK;
    private JButton boutonAnnuler;
    private JPanel panelRecu;
    private JPanel panelGauche;
    private JPanel panelDroite;
    private JPanel panelMessages;

    private EcouteurNumero ecouteurNumero;
    private EcouteurCarteCredit ecouteurCarteCredit;
    private EcouteurMonnaie ecouteurMonnaie;
    private EcouteurControles ecouteurControles;
    private EcouteurEntree ecouteurEntree;

    // variables utiles pour vous
    String place =""; //place de stationnement choisie
    Borne b; // borne à créer dans le constructeur

    //formatage
    public GUITP2() throws ParseException {

        labelLogo.setIcon(new ImageIcon("logo.png"));
        boutonValiderDateExp.setMargin(new Insets(10,0, 10, 0));
        //Création des écouteurs
        ecouteurNumero = new EcouteurNumero();
        ecouteurCarteCredit = new EcouteurCarteCredit();
        ecouteurMonnaie = new EcouteurMonnaie();
        ecouteurControles = new EcouteurControles();
        ecouteurEntree = new EcouteurEntree();

        // panelNumeros avec la grille
        GridBagLayout gl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        FlowLayout f = new FlowLayout(FlowLayout.CENTER);
        panelOperations.setLayout(f);

        panelNumeros.setLayout(gl);
        c.fill = GridBagConstraints.BOTH;
        c.weightx =1;
        c.weighty=1;
        for ( int i = 0; i <15 ; i++) {
            JButton temp = new JButton();
            temp.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
            temp.setForeground(new Color(0,174,239));
            temp.addActionListener(ecouteurNumero);
            if  ( i ==0 )
                temp.setText("A");
            else if ( i ==1 )
                temp.setText("B");
            else if ( i==2 )
               temp.setText("G");
            else if (i==3) {
                c.gridwidth = GridBagConstraints.REMAINDER; //end row
                temp.setText("SQ");
            }
            else if (i<=6) {
                c.weightx=1;
                c.gridwidth = 1;
                temp.setText(String.valueOf(i-4));
            } else if (i==7) {
                c.gridwidth = GridBagConstraints.REMAINDER; //end row
                temp.setText(String.valueOf(i-4));
            } else if (i<=10) {
                c.weightx=1;
                c.gridwidth = 1;
                temp.setText(String.valueOf(i-4));
            } else if (i==11) {
                c.gridwidth = GridBagConstraints.REMAINDER; //end row
                temp.setText(String.valueOf(i-4));
            } else if (i<=13) {
                c.weightx=1;
                c.gridwidth = 1;
                temp.setText(String.valueOf(i-4));
            } else {
                c.gridwidth = GridBagConstraints.REMAINDER; //end row
                temp.setText("entrée");
                temp.removeActionListener(ecouteurNumero);
                temp.addActionListener(ecouteurEntree);
            }
            gl.setConstraints(temp, c );
            panelNumeros.add( temp);
        }

        // inscrire les sources à l'écouteur
        bouton25.addActionListener(ecouteurMonnaie);
        bouton100.addActionListener(ecouteurMonnaie);
        bouton200.addActionListener(ecouteurMonnaie);

        boutonMax.addActionListener(ecouteurCarteCredit);
        boutonPlus.addActionListener(ecouteurCarteCredit);
        boutonMoins.addActionListener(ecouteurCarteCredit);
        boutonValiderDateExp.addActionListener(ecouteurCarteCredit);
        boutonOK.addActionListener(ecouteurControles);
        boutonAnnuler.addActionListener(ecouteurControles);
        boutonRapport.addActionListener(ecouteurControles);

        b = new Borne();

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        try {
            champNumeroCarte = new JFormattedTextField(new MaskFormatter("#### #### #### ####"));
            champDateExp = new JFormattedTextField(new MaskFormatter("##/##"));
        }
        catch ( ParseException pe) {
            pe.printStackTrace();
        }
    }
    private void $$$setupUI$$$() {
        createUIComponents();
    }
    private class EcouteurNumero implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            //lettre ou chiffre du bouton qu'on a cliqué dessus
           String lettreChiffre = ((JButton)e.getSource()).getText();
           boutonNumeroLettre_actionPerformed( lettreChiffre);
        }
    }

    private class EcouteurEntree implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boutonEntree_actionPerformed();
        }
    }

    private class EcouteurMonnaie implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ( e.getSource() == bouton25)
                bouton25_actionPerformed();
            else if ( e.getSource()==bouton100)
                bouton100_actionPerformed();
            else if ( e.getSource() == bouton200)
                bouton200_actionPerformed();
        }
    }

    private class EcouteurCarteCredit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

             if ( e.getSource() == boutonPlus)
                boutonPlus_actionPerformed();
             else if ( e.getSource() == boutonMoins)
                 boutonMoins_actionPerformed();
            else if (e.getSource() == boutonMax)
                boutonMax_actionPerformed();
            else if ( e.getSource() == boutonValiderDateExp)
                boutonValiderDateExp_actionPerformed();
        }
    }

    private class EcouteurControles implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ( e.getSource() == boutonOK)
                boutonOK_actionPerformed();
            else if ( e.getSource() == boutonRapport)
                boutonRapport_actionPerformed();
            else if ( e.getSource() == boutonAnnuler)
                boutonAnnuler_actionPerformed();
        }
    }

    public void boutonNumeroLettre_actionPerformed(String lettreChiffre) {
        // 2. À compléter, afficher la place choisie dans le champMessage
        // à partir de la lettre ou du chiffre cliqué en paramètre
        if (b.getTransactionCourante() == null) {
            place += lettreChiffre;
            champMessage.setText(place);
        }
    }

    private void boutonEntree_actionPerformed() {

        if (b.getTransactionCourante() == null) {
            if (b.validerPlace(place)) {
                if (b.verifierHeure(place)) {
                    Transaction t = new Transaction(place);
                    b.setTransactionCourante(t);
                    champMessage.setText("borne valide !");
                } else {
                    champMessage.setText("Heures non-payante !");
                    place = "";
                }
            } else {
                champMessage.setText("Borne invalide ! Veuillez Réessayer.");
                place = "";
            }
        }
    }

    private void bouton25_actionPerformed() {
        b.verifierHeure(place);
        if (b.getTransactionCourante() != null) {
            b.getTransactionCourante().ajouter25();
            champMessage.setText("Vous avez mis " + b.getTransactionCourante().getMontant() + " cents, donc " + b.calculerMinutes(b.getTransactionCourante().getMontant(),place) + " minutes");
        }
    }

    private void bouton100_actionPerformed() {
        if (b.getTransactionCourante() != null) {
            b.getTransactionCourante().ajouter100();
            champMessage.setText("Vous avez mis " + b.getTransactionCourante().getMontant() + " cents, donc " + b.calculerMinutes(b.getTransactionCourante().getMontant(),place) + " minutes");
        }
    }

    private void bouton200_actionPerformed() {
        if (b.getTransactionCourante() != null) {
            b.getTransactionCourante().ajouter200();
            champMessage.setText("Vous avez mis " + b.getTransactionCourante().getMontant() + " cents, donc " + b.calculerMinutes(b.getTransactionCourante().getMontant(),place) + " minutes");
        }
    }

    private void boutonValiderDateExp_actionPerformed(){
        //7. à coder
        YearMonth dateExpirtation = YearMonth.of(2023, 12);
    }

    private void boutonPlus_actionPerformed() {
        if (b.getTransactionCourante() != null) {
            if (b.tempsMaximum(b.calculerMinutes(b.getTransactionCourante().getMontant(), place)))
                b.getTransactionCourante().carteAjouter25();
            champMessage.setText("Vous avez mis " + b.getTransactionCourante().getMontant() + " cents donc " + b.calculerMinutes(b.getTransactionCourante().getMontant(),place) + " minutes");
        }
    }

    private void boutonMoins_actionPerformed(){
        if (b.getTransactionCourante() != null) {
            b.getTransactionCourante().carteRetirer25();
            champMessage.setText("Vous avez mis " + b.getTransactionCourante().getMontant() + " cents donc " + b.calculerMinutes(b.getTransactionCourante().getMontant(),place) + " minutes");
        }
    }

    private void boutonMax_actionPerformed() {
        if (b.getTransactionCourante() != null) {
            b.getTransactionCourante().setMontant(b.ajouterMaximum(b.getTransactionCourante().getMontant(), place));
            champMessage.setText("Vous avez mis " + b.getTransactionCourante().getMontant() + " cents donc " + b.calculerMinutes(b.getTransactionCourante().getMontant(),place) + " minutes");
        }
    }

    private void boutonOK_actionPerformed() {
        // verifier l'utilisateur paye carte ou comptant
        // si carte -> verifier si solde est assez grand
        //      si oui faire la transaction et retirer montant au solde
        //      si non envoyer un message
        // ajouter le montant a la banque

        if (b.getTransactionCourante().getTypePaiement().equals("carte")) {

        } else {
            b.terminerTransaction();
            zoneRecu.setText("Vous avez retiré : " + b.getBanque());
        }


        // mettre la transaction courante a null

    }

    private void boutonAnnuler_actionPerformed() {
        if (b.getTransactionCourante() != null) {
            b.setTransactionCourante(null);
            champMessage.setText("Vous avez annulé la transaction !");
        }
    }

    private void boutonRapport_actionPerformed() {
        if (b.getTransactionCourante() != null) {
            place = "";
            champMessage.setText("Vous avez retiré " + b.genererRapport(b.getBanque()) + " cents de la banque");
            b.setBanque(0);
        }
    }

    public static void main(String[] args) {
        try {
            JFrame frame = new JFrame("GUITP2");
            frame.setContentPane(new GUITP2().panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(930, 815);
            //frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            System.out.println ( new GregorianCalendar(2021, 11, 5).get(Calendar.DAY_OF_WEEK));
        }
        catch ( Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
