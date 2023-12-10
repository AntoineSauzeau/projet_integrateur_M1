package ui;

import model.Application;

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

    public HeaderBar(){

        loadIcons();

        labelHome = new JLabel(iconHome);
        labelHome.setPreferredSize(new Dimension(32, 32));

        labelExit = new JLabel(iconExit);

        labelAccount = new JLabel(iconAccount);

        JPanel panelLeftIcons = new JPanel();
        panelLeftIcons.setLayout(new BoxLayout(panelLeftIcons, BoxLayout.X_AXIS));
        panelLeftIcons.setBackground(Color.gray);
        panelLeftIcons.add(labelHome);
        panelLeftIcons.add(labelExit);

        JPanel panelRightIcons = new JPanel();
        panelRightIcons.setLayout(new BoxLayout(panelRightIcons, BoxLayout.X_AXIS));
        panelRightIcons.setBackground(Color.gray);
        panelRightIcons.add(labelAccount);

        setLayout(new BorderLayout());
        add(panelLeftIcons, BorderLayout.LINE_START);
        add(panelRightIcons, BorderLayout.LINE_END);

        setEventHandlers();
    }

    public void setEventHandlers(){
        labelHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Home icon clicked!");
                Application.getInterface().changePage(InterfacePage.MAIN);
            }
        });

        labelExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Exit icon clicked!");
                Application.getInterface().changePage(InterfacePage.CONNECTION);
            }
        });

        labelAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    if(Application.clientIsSubscriber())
                        Application.getInterface().changePage(InterfacePage.ACCOUNT);
            }
        });
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
