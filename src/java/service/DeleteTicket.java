package service;

import managers.DataBaseConnection;
import repositories.TicketsRepository;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTicket {

    TicketsRepository ticketsRepository;

    public DeleteTicket(){
        ticketsRepository = new TicketsRepository();
    }

    public void deleteTicket(String ID) {

        if (ticketsRepository.findTicketByUniqueID(ID) == null) {
            JOptionPane.showMessageDialog(null, "Nu exista nici un bilet cu acest cod!");
        } else {
            String sql = "DELETE FROM tickets WHERE routeID = ?";

            try (
                    Connection con = DataBaseConnection.getInstance().createConnection();
                    PreparedStatement statement = con.prepareStatement(sql);
            ) {
                statement.setString(1, ID);
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Biletul a fost sters din baza de date!");
            
        }
    }


    public static final DeleteTicket getInstance() {
        return SingleTonHolder.INSTANCE;
    }

    public static final class SingleTonHolder{
        private static final DeleteTicket INSTANCE = new DeleteTicket();
    }
}
