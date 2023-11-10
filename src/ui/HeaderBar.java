package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseEvent;

public class HeaderBar extends JPanel {

    ImageIcon iconHome;
    ImageIcon iconExit;
    ImageIcon iconAccount;
    JLabel labelHome;
    JLabel labelExit;
    JLabel labelAccount;

    public HeaderBar(MainPage parent){

        loadIcons();

        labelHome = new JLabel(iconHome);
        labelHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Home icon clicked!");
                parent.loadDefaultMenu();
                parent.revalidate();
                parent.repaint();
            }
        });
        labelHome.setPreferredSize(new Dimension(32, 32));
        labelExit = new JLabel(iconExit);
        labelExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Exit icon clicked!");
                //TODO décharger la page actuelle puis charger ConnectionPage
            }
        });
        labelAccount = new JLabel(iconAccount);
        labelAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.loadAccountPage();
                //TODO décharger la page actuelle puis charger AccountPage
                // seulement si connecté en sub
            }
        });
        JPanel panelLeftIcons = new JPanel();
        panelLeftIcons.setLayout(new BoxLayout(panelLeftIcons, BoxLayout.X_AXIS));
        panelLeftIcons.add(labelHome);
        panelLeftIcons.add(labelExit);

        JPanel panelRightIcons = new JPanel();
        panelRightIcons.setLayout(new BoxLayout(panelRightIcons, BoxLayout.X_AXIS));
        panelRightIcons.add(labelAccount);

        setLayout(new BorderLayout());
        add(panelLeftIcons, BorderLayout.LINE_START);
        add(panelRightIcons, BorderLayout.LINE_END);
    }

    public void loadIcons(){
        try {
            iconHome = new ImageIcon(ImageIO.read(new File("assets/img/home.png")));
            iconExit = new ImageIcon(ImageIO.read(new File("assets/img/logout.png")));
            iconAccount = new ImageIcon(ImageIO.read(new File("assets/img/account.png")));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
