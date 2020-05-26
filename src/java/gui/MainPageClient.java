package gui;

import model.Client;

import java.awt.Component;
import javax.swing.*;

public class MainPageClient extends JFrame {
    private JPanel panel;
    private JButton biletCalatorButton;
    private JButton biletColetButton;
    private JButton sediiButton;
    private JButton contactButton;
    private JButton istoricComenziButton;
    private JButton anulareBiletButton;
    private JButton soferiButton;
    private JButton ruteButton;
    private JLabel despreNoiLabel;
    private JButton CUMPARABILETButton;
    private JButton EXEPDIERECOLETButton;
    private JButton istoricComeziButton;
    private JPanel panel1;
    private JLabel usernameLabel;
    private String username;
    public MainPageClient() {



        add(panel1);
        this.setSize(500, 600);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo((Component)null);


    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        this.usernameLabel.setText("Esti logat ca " + username);
    }


}
