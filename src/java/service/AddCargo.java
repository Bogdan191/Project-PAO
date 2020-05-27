package service;

import managers.DataBaseConnection;
import model.Cargo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCargo {

    public void addCargoCommand(Cargo c) {
        String sql = "INSERT INTO cargo VALUES(NULL, ?, ?, ?, ?, ?, ?, ?)";

        try(
                Connection con = DataBaseConnection.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ){
            statement.setString(1, c.getSender());
            statement.setString(2, c.getRecipient());
            statement.setString(3, c.getDescrition());
            statement.setString(4, c.getPickUpLocation());
            statement.setString(5, c.getDestination());
            statement.setString(6, c.getWeight());
            statement.setString(7, c.getVolume());
            statement.execute();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static AddCargo getInstance() {
        return SingleTonHolder.INSTANCE;
    }

    private static class SingleTonHolder {
       private static final AddCargo INSTANCE = new AddCargo();
    }
}
