package repositories;

import managers.DataBaseConnection;
import model.Route;
import model.Ticket;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketsRepository {



    public TicketsRepository(){

    }

    public Ticket[] getTickets() {

        String sql = "SELECT * FROM tickets";
        Ticket[] t = new Ticket[100];
        try(
                Connection con = DataBaseConnection.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ){
            ResultSet set = statement.executeQuery();
            int index = 0;
            while(set.next()) {
                String buyer = set.getString("buyer");
                String routeID = set.getString("routeID");
                String route = set.getString("route");
                String price = set.getString("price");

                t[index] = new Ticket(buyer, routeID, route, price);
                index++;
            }
            return t;

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return t;

    }

    public Ticket findTicketByUniqueID(String ID) {

        Ticket[] t;
        t = this.getTickets();

        for(int i = 0; i < t.length; i++) {
            if(t[i] != null && t[i].getUniqueCode().equals(ID)){
                return t[i];
            }

        }

        return null;

    }

}
