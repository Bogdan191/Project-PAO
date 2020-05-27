package gui;

import model.Cargo;

import javax.swing.*;

public class AddCargo extends JFrame{
    private JTextField senderField;
    private JTextField recipientField;
    private JTextField descriptionField;
    private JTextField pickUpLocationField;
    private JTextField destinationField;
    private JTextField weightField;
    private JTextField volumeField;
    private JButton addCargoButton;
    private JPanel mainPanel;
    private String username;


    public AddCargo() {
        add(mainPanel);

        addCargoButton.addActionListener((ev) -> {
            addCargo();
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setVisible(true);
    }

    public void addCargo(){

        service.AddCargo serviceAdd = new service.AddCargo();

        String sender = senderField.getText();
        String recipient = recipientField.getText();
        String description = descriptionField.getText();
        String pickUpLocation = pickUpLocationField.getText();
        String destination = destinationField.getText();
        String weight = weightField.getText();
        String volume = volumeField.getText();
        boolean corect = false;
        while(!corect) {

           if(sender != null && recipient != null && pickUpLocation != null && destination != null && weight != null && volume != null) {
               corect = true;
               JOptionPane.showMessageDialog(null, "Inregistrare cu succes");
               Cargo c = new Cargo(username, sender, recipient, description, pickUpLocation, destination, weight, volume);
               serviceAdd.addCargoCommand(c);
               MainPageClient m = new MainPageClient();
               this.dispose();
               m.setUsername(username);
               m.setVisible(true);
           }else {
               JOptionPane.showMessageDialog(null, "Date incorecte");
               break;
           }

        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

