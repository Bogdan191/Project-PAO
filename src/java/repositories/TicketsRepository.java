package repositories;

import managers.DataBaseConnection;
import model.Ticket;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketsRepository {

    public TicketsRepository() {

    }

    public void addTicket(Ticket t) {
        String sql = "INSERT INTO tickets VALUES(NULL, ?, ?, ?, ?)";

        try(
                Connection con = DataBaseConnection.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ){
                statement.setString(1, t.getBuyer());
                statement.setString(2, t.getUniqueCode());
                statement.setString(3, t.getRoute());
                statement.setString(4, t.getPrice());

                statement.execute();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
