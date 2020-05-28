package gui;

import model.Cargo;
import model.Route;
import model.Ticket;
import repositories.CargosRepository;
import repositories.DBCargosRepository;
import repositories.RoutesRepository;
import repositories.TicketsRepository;
import service.DeleteTicket;
import javax.swing.*;

import static repositories.CargosRepository.Type.DB;

public class MainPageClient extends JFrame {

    private JButton contactButton;
    private JButton cancelTicketButton;
    private JButton routesButton;
    private JButton buyTicketButton;
    private JButton cargoSendButton;
    private JButton historyButton;
    private JPanel panel1;
    private JLabel usernameLabel;
    private JTextField codTicketTextField;
    private JLabel codTicketLabel;
    private JButton cancelButton;
    private String username;


    public MainPageClient() {


        add(panel1);
        codTicketLabel.setVisible(false);
        codTicketTextField.setVisible(false);
        cancelButton.setVisible(false);
        this.setSize(1500, 1600);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        RoutesRepository routesRepository = new RoutesRepository();
        TicketsRepository ticketsRepository = new TicketsRepository();
        CargosRepository DBCargosRepository = CargosRepository.build(DB);

        buyTicketButton.addActionListener((ev) -> { // buton pentru cumpararea unui nou bilet
            BuyTicket b = new BuyTicket(); // se deschide o noua fereastra care in care se efectueaza actiunea de cumparare
            this.dispose();
            b.setVisible(true);
            b.setUsername(this.username); // se propaga username-ul din fereastra principala la noua fereastra
        });

        cargoSendButton.addActionListener((ev) -> { // buton pentru expedierea unui colet
            AddCargo b = new AddCargo();
            this.dispose();
            b.setVisible(true);
            b.setUsername(username); // se propaga username-ul catre noua fereastra
        });

        routesButton.addActionListener((ev) -> { // buton care afiseaza rutele disponibile din baza de date

            Route[] routes  = routesRepository.getRoutes();
            StringBuilder message;
            if(routes != null) {

                message = new StringBuilder("Rute:\n");
                for (Route route : routes) {
                    if (route != null)
                        message.append(route.getStartPoint()).append("-").append(route.getDestination()).append("\n");
                }
                JOptionPane.showMessageDialog(null, message.toString());
            }else {
                JOptionPane.showMessageDialog(null, "Nicio ruta inregistrata in baza de date!");
            }
        });

        cancelTicketButton.addActionListener((ev) -> { //afisarea label-ului si butonului care se ocupa cu stergerea biletului
            codTicketLabel.setVisible(true);
            codTicketLabel.setText("");
            codTicketLabel.setText(null);
            codTicketTextField.setVisible(true);
            cancelButton.setVisible(true);
        });

        cancelButton.addActionListener((ev) ->{ // stergerea biletului din baza de date, daca exista,
                                                // cautarea biletului se face dupa codul unic pe care l are fiecare

            String id = codTicketTextField.getText();

            if(id.equals("")) {
                JOptionPane.showMessageDialog(null, "Completeaza casuta cu codul unic al biletului!");

            }else{
                DeleteTicket service = new DeleteTicket(); ///serviciu care sterge din baza de date biletul corespunzator
                service.deleteTicket(id);
                codTicketLabel.setVisible(false);
                codTicketTextField.setVisible(false);
                cancelButton.setVisible(false);
            }

        });

        historyButton.addActionListener((ev) ->{ /// afiseaza toate biletele si toate coletele expediate de user

            Cargo[] c = DBCargosRepository.getCargos();
            Ticket[] t = ticketsRepository.getTickets();
            StringBuilder comands = new StringBuilder("      Comenzile tale, " + username + ".\n   Bilete persoane: \n");

            int i;
            int cnt = 0;
            for(i = 0; i < t.length; i++) {
                if(t[i] != null && t[i].getBuyer().equals(username)) {
                    cnt++;
                    comands.append(cnt).append(". Ruta: ").append(t[i].getRoute()).append("; Pret: ").append(t[i].getPrice()).append(".\n");
                }
            }
            cnt = 0;
            comands.append("\n \n \n    Bilete colete:\n");
            for(i = 0; i < c.length; i++) {
                if(c[i] != null && c[i].getUsername() != null &&c[i].getUsername().equals(username)) {
                    cnt++;
                    comands.append(cnt).append(". Punct ridicare: ").append(c[i].getPickUpLocation()).append("; Destinatie ").append(c[i].getDestination()).append("; Greutate: ").append(c[i].getWeight()).append("; Volum").append(c[i].getVolume()).append("; \n                   ").append("           Descriere livrare: ").append(c[i].getDescrition()).append(".\n");
                }
            }

            JOptionPane.showMessageDialog(null, comands.toString());

        });

        contactButton.addActionListener((ev) ->{ ///afisarea unor date despre aplicatie.
            String msg = "Site: www.dibi-transport.ro \n Sediu central: Bucuresti \n Numar de telefon: 0720200200";
            JOptionPane.showMessageDialog(null, msg);
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
