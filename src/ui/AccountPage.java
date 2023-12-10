package ui;
import model.Application;
import model.Subscriber;
import sql.Tool.Session;
import sql.data.RentService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import model.Rent;

public class AccountPage extends JPanel{
    //Page avec toute les informations du compte

    private HeaderBar headerBar;
    private JLabel nameValueLabel;
    private JLabel addressValueLabel;
    private JLabel mailValueLabel;
    private JLabel birthdateValueLabel;
    private JLabel subCardValueLabel;
    private JLabel balanceValueLabel;
    private JLabel creditCardValueLabel;
    private ArrayList<JLabel> rentsValueLabel;

    private Font fontDialogBold_25;
    private Font fontDialog_20;


    public AccountPage(){

        createFonts();

        setLayout(new BorderLayout());

        headerBar = new HeaderBar();
        add(headerBar, BorderLayout.PAGE_START);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        add(centerPanel, BorderLayout.CENTER);

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;

        JPanel blankLeftPanel = new JPanel();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.20;
        c.gridheight = 3;
        centerPanel.add(blankLeftPanel, c);

        JPanel personalPanel = createPersonalPanel();
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.6;
        c.gridheight = 1;
        centerPanel.add(personalPanel, c);

        JPanel paymentPanel = createPaymentPanel();
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.6;
        c.gridheight = 1;
        centerPanel.add(paymentPanel, c);

        JPanel historyPanel = createHistoryPanel();
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 0.6;
        c.gridheight = 1;
        centerPanel.add(historyPanel, c);

        JPanel blankRightPanel = new JPanel();
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.20;
        c.gridheight = 3;
        centerPanel.add(blankRightPanel, c);

        Update();
    }

    public void createFonts(){
        fontDialogBold_25 = new Font(Font.DIALOG,  Font.BOLD, 25);
        fontDialog_20 = new Font(Font.DIALOG,  Font.PLAIN, 20);
    }

    JPanel createPersonalPanel(){
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1;

        JLabel personalInformationsLabel = new JLabel("Infos personnelles");
        personalInformationsLabel.setFont(fontDialogBold_25);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 38, 0);
        c.anchor = GridBagConstraints.CENTER;
        p.add(personalInformationsLabel, c);

        //c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0, 0, 10, 20);
        c.anchor = GridBagConstraints.LINE_START;

        JPanel namePanel = new JPanel();
        c.gridy++;
        p.add(namePanel, c);

        JLabel nameLabel = createFieldTitleLabel("Nom :");
        namePanel.add(nameLabel);
        nameValueLabel = createFieldValueLabel("Vincent");
        namePanel.add(nameValueLabel);

        JPanel addressPanel = new JPanel();
        c.gridy++;
        p.add(addressPanel, c);

        JLabel adressLabel = createFieldTitleLabel("Adresse :");
        addressPanel.add(adressLabel);
        addressValueLabel = createFieldValueLabel("10 rue du Chateau");
        addressPanel.add(addressValueLabel);

        JPanel mailPanel = new JPanel();
        c.gridy++;
        p.add(mailPanel, c);

        JLabel mailLabel = createFieldTitleLabel("Mail :");
        mailPanel.add(mailLabel);
        mailValueLabel = createFieldValueLabel("machin@gmail.com");
        mailPanel.add(mailValueLabel);

        JPanel birthdatePanel = new JPanel();
        c.gridy++;
        p.add(birthdatePanel, c);

        JLabel birthdateLabel = createFieldTitleLabel("Date de naissance :");
        birthdatePanel.add(birthdateLabel);
        birthdateValueLabel = createFieldValueLabel("15/11/2002");
        birthdatePanel.add(birthdateValueLabel);

        JPanel subCardPanel = new JPanel();
        c.gridy++;
        p.add(subCardPanel, c);

        JLabel subcardLabel = createFieldTitleLabel("N° carte abonné :");
        subCardPanel.add(subcardLabel);
        subCardValueLabel = createFieldValueLabel("24512965456521");
        subCardPanel.add(subCardValueLabel);

        return p;
    }

    JLabel createFieldTitleLabel(String value){
        JLabel label = new JLabel(value);
        label.setFont(fontDialog_20);
        return label;
    }

    JLabel createFieldValueLabel(String value){
        JLabel label = new JLabel(value);
        label.setFont(fontDialog_20);
        return label;
    }

    JPanel createPaymentPanel(){
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;

        JLabel titleLabel = new JLabel("Infos paiement");
        titleLabel.setFont(fontDialogBold_25);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(55, 0, 38, 0);
        c.anchor = GridBagConstraints.CENTER;
        p.add(titleLabel, c);

        c.insets = new Insets(0, 0, 10, 20);
        c.anchor = GridBagConstraints.LINE_START;

        JPanel balancePanel = new JPanel();
        c.gridy++;
        p.add(balancePanel, c);

        JLabel balanceLabel = createFieldTitleLabel("Solde :");
        balancePanel.add(balanceLabel);
        balanceValueLabel = createFieldValueLabel("23 euros");
        balancePanel.add(balanceValueLabel);

        JPanel creditCardPanel = new JPanel();
        c.gridy++;
        p.add(creditCardPanel, c);

        JLabel creditCardLabel = createFieldTitleLabel("N° carte de crédit :");
        creditCardPanel.add(creditCardLabel);
        creditCardValueLabel = createFieldValueLabel("**** **** **** 5842");
        creditCardPanel.add(creditCardValueLabel);

        return p;
    }

    JPanel createHistoryPanel(){
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;

        JLabel titleLabel = new JLabel("Infos paiement");
        titleLabel.setFont(fontDialogBold_25);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(55, 0, 38, 0);
        c.anchor = GridBagConstraints.CENTER;
        p.add(titleLabel, c);

        c.insets = new Insets(0, 0, 10, 20);
        c.anchor = GridBagConstraints.LINE_START;

        ArrayList<Rent> rents = new ArrayList<>();
        rentsValueLabel = new ArrayList<JLabel>();
        for(int i = 0; i < 5; i++){
            if(i < rents.size()){
                JLabel rentLabel = createFieldValueLabel(rents.get(i).getMovie().getName());
                rentsValueLabel.add(rentLabel);
            }
            else{
                JLabel rentLabel = createFieldValueLabel("Aucune location");
                rentsValueLabel.add(rentLabel);
            }
        }
        for (JLabel label : rentsValueLabel) {
            JPanel rentPanel = new JPanel();
            c.gridy++;
            p.add(rentPanel, c);

            rentPanel.add(label);
        }


        return p;
    }

    

    public void Update(){
        Subscriber sus = Application.getSubcriberConnected();
        nameValueLabel.setText(sus.getName());
        addressValueLabel.setText(sus.getAddress());
        mailValueLabel.setText(sus.getMail());
        birthdateValueLabel.setText(sus.getBirthdate().toString());
        subCardValueLabel.setText(sus.getSubCardNumber().toString());
        balanceValueLabel.setText(sus.getBalance().toString());
        creditCardValueLabel.setText(sus.getCreditCardNumber().toString());
        Session session = new Session(true);
        RentService rdao = new RentService(session);
        ArrayList<Rent> rents = rdao.getClientRents(1);
        for(int i = 0; i < 5; i++){
            if(i < rents.size()){
                rentsValueLabel.get(i).setText(rents.get(i).getMovie().getName());
            }
            else{
                rentsValueLabel.get(i).setText("");
            }
        }
    }
}
