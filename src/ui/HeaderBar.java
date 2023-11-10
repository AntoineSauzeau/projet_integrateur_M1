package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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
