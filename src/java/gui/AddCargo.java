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

        addCargoButton.addActionListener((ev) -> { // buton care inregistreaza comanda actuala
            addCargo();
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setVisible(true);
    }

    public void addCargo(){ // functia care se apeleaza la apasarea butonului 'addCargoButton'

        service.AddCargo serviceAdd = new service.AddCargo(); /// obiect de tip serviciu care adauga in baza de date 'cargo'
                                                                // un obiect de tip 'Cargo'

        String sender = senderField.getText();
        String recipient = recipientField.getText();
        String description = descriptionField.getText();
        String pickUpLocation = pickUpLocationField.getText();
        String destination = destinationField.getText();
        String weight = weightField.getText();
        String volume = volumeField.getText();
        boolean corect = false;
        while(!corect) { /// cat timp datele nu sunt corecte, incearca din nou sa completezi

           if(sender != null && recipient != null && pickUpLocation != null && destination != null && weight != null && volume != null) {
               ///daca toate campurile sunt completate, atunci inseamna ca input ul este corect si inregistreaza cererea
               corect = true;
               JOptionPane.showMessageDialog(null, "Inregistrare cu succes");
               Cargo c = new Cargo(username, sender, recipient, description, pickUpLocation, destination, weight, volume);
               serviceAdd.addCargoCommand(c); /// functia din serviciu care inregistreaza in baza de date
               MainPageClient m = new MainPageClient(); /// se revine la pagina initiala
               this.dispose();
               m.setUsername(username); /// propagarea username-ului, ca sa nu fie pierdut
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

