package gui;

import model.Route;
import model.Ticket;
import repositories.RoutesRepository;
import service.AddTicket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Random;

public class BuyTicket extends JFrame{
    private JComboBox startBox;
    private JComboBox destinationBox;
    private JButton buyTicketButton;
    private JLabel detailsLabel;
    private JButton showDetailsButton;
    private JPanel mainPanel;
    private String username;

    RoutesRepository routes = new RoutesRepository();
    Route[] start;
    public BuyTicket(){

        add(mainPanel);
        startBox.removeAllItems();
        detailsLabel.setText("");
        start =routes.getRoutes();
        int index = 0;
        for(index = 0; index < start.length; index++){
            if(start[index] != null){
                int i = 0;
                boolean egale = false;
                for(i = 0; i < index && egale == false; i++) {
                    if(start[i].getStartPoint().equals(start[index].getStartPoint())){
                        egale = true;
                    }
                }
                if(egale == false || index == 0)
                    startBox.addItem(start[index].getStartPoint());
            }
        }

        startBox.addActionListener(e -> {
            setDestinationBox(e);
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);

        showDetailsButton.addActionListener((ev) -> {
           showDetails();
        });
        buyTicketButton.addActionListener((ev) -> {
            buyTicket();
        });
    }

    private int showDetails() {
        String startPoint = (String)startBox.getSelectedItem();
        String destination = (String)destinationBox.getSelectedItem();
        int index = 0;
        int pos = 0;
        for(index = 0; index < start.length; index++) {
            if(start[index] != null && startPoint.equals(start[index].getStartPoint()) && destination.equals(start[index].getDestination())){
                JOptionPane.showMessageDialog(null,"Detalii ruta " + "\n" + "Plecare:"  +startPoint + "\nSosire: " + destination +
                        "\nLungime ruta: " + start[index].getLength() + "\nDurata calatorie:" + start[index].getTime()
                        + "\nOpriri pe traseu: " + Arrays.toString(start[index].getStopPoints()) +
                        "\nPret calatorie: " + 0.5 * start[index].getLength() + "de lei\n");
                pos = index;
            }
        }
        return pos;
    }
    private void buyTicket(){

        AddTicket s = new AddTicket();

        int pos = showDetails();
        String route = start[pos].getStartPoint() + "-" + start[pos].getDestination();
        String price = 0.5 * start[pos].getLength() + "de lei";
        Random rand = new Random();
        int random = rand.nextInt((100 - 0) + 1) + 0;
        String routeID = start[pos].getUniqueCode() + random;
        Ticket t = new Ticket(username, routeID, route, price);
        s.addTicket(t);
        MainPageClient n = new MainPageClient();
        this.dispose();
        n.setVisible(true);
        n.setUsername(username);
    }

    public void setDestinationBox(ActionEvent e) {
        if(e.getSource() == startBox) {
            JComboBox cb = (JComboBox)e.getSource();
            String selectedStart = (String)cb.getSelectedItem();
            int count = destinationBox.getItemCount();
                destinationBox.removeAllItems();
            int index = 0;
            for(index = 0; index < start.length; index++) {
                if(start[index] != null && selectedStart.equals(start[index].getStartPoint())) {
                    destinationBox.addItem(start[index].getDestination());
                }
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
