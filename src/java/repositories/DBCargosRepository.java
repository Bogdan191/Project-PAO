package repositories;

import managers.DataBaseConnection;
import model.Cargo;
import model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCargosRepository implements  CargosRepository {

    @Override
    public void addCargoCommand(Cargo c) {
        String sql = "INSERT INTO cargo VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(
                Connection con = DataBaseConnection.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ){
            statement.setString(1, c.getUsername());
            statement.setString(2, c.getSender());
            statement.setString(3, c.getRecipient());
            statement.setString(4, c.getDescrition());
            statement.setString(5, c.getPickUpLocation());
            statement.setString(6, c.getDestination());
            statement.setString(7, c.getWeight());
            statement.setString(8, c.getVolume());
            statement.execute();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cargo[] getCargos() {
        String sql = "SELECT * FROM cargo";
        Cargo[] c = new Cargo[100];
        try(
                Connection con = DataBaseConnection.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ){
            ResultSet set = statement.executeQuery();
            int index = 0;
            while(set.next()) {
                String username = set.getString("username");
                String sender = set.getString("sender");
                String recipient = set.getString("recipient");
                String description = set.getString("description");
                String pickUpLocation = set.getString("pickUpLocation");
                String destination = set.getString("destination");
                String weight = set.getString("weight");
                String volume = set.getString("volume");

                c[index] = new Cargo(username, sender, recipient, description, pickUpLocation, destination, weight, volume);
                index++;
            }
            return c;
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return c;
    }


}
