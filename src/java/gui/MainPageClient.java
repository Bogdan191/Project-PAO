package gui;

import model.Client;

import java.awt.Component;
import javax.swing.*;

public class MainPageClient extends JFrame {
    private JPanel panel;
    private JButton contactButton;
    private JButton cancelTicketButton;
    private JButton routesButton;
    private JLabel despreNoiLabel;
    private JButton buyTicketButton;
    private JButton cargoSendButton;
    private JButton historyButton;
    private JPanel panel1;
    private JLabel usernameLabel;
    private JLabel showLabel;
    private String username;
    public MainPageClient() {

        add(panel1);
        this.setSize(1500, 1600);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo((Component)null);

        buyTicketButton.addActionListener((ev) -> {
            BuyTicket b = new BuyTicket();
            this.dispose();
            b.setVisible(true);
            b.setUsername(this.username);
        });

        cargoSendButton.addActionListener((ev) -> {
            AddCargo b = new AddCargo();
            this.dispose();
            b.setVisible(true);
            b.setUsername(username);
        });


    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        this.usernameLabel.setText("Esti logat ca " + username);
    }


}
