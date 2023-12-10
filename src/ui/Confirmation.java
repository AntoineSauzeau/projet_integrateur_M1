package ui;

import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;


import Controler.Controler;

import javax.swing.JLabel;
import javax.swing.JButton;


public class Confirmation extends JDialog {

    public Confirmation(JFrame parent, String title, String message) {
        super(parent, title, true);
        setLocationRelativeTo(parent);

        message = "<html><body><p style='width: 200px;'>" + message + "</p></body></html>";
        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        messageLabel.setHorizontalAlignment(JLabel.CENTER);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(messageLabel, BorderLayout.CENTER);

        JButton button = new JButton("Retour à l'accueil");
        contentPane.add(button, BorderLayout.SOUTH);
        button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               fonctionClose();
           }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fonctionClose();
            }
        });


        setPreferredSize(new Dimension(300, 150));
        pack();
    }

    public void fonctionClose() {
        setVisible(false);
        Controler.getInstance().goBack();
    }


}
