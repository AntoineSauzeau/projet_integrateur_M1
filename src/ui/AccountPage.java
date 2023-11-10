package ui;
import javax.swing.*;
import java.awt.*;

public class AccountPage extends JPanel{
    //Page avec toute les informations du compte

    private JLabel accountNameLabel;
    private JLabel subCardLabel;
    private JLabel creditsLabel;
    private JLabel numberOfLocationsLabel;
    private JButton AddCreditButton;
    private JButton getHistoryButton;



    public AccountPage() {
        accountNameLabel = new JLabel("Nom du compte");
        subCardLabel = new JLabel("Carte de sub");
        creditsLabel = new JLabel("Solde");
        numberOfLocationsLabel = new JLabel("Nombre de locations");
        AddCreditButton = new JButton("Ajouter des crédits");
        getHistoryButton = new JButton("Historique des locations");

        this.setLayout(new GridLayout(6, 1));
        this.add(accountNameLabel);
        this.add(subCardLabel);
    }
}
