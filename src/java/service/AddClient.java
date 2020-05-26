package service;

import managers.DataBaseConnection;
import model.Client;
import model.User;
import repositories.UserRepository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AddClient {

    UserRepository userRepository;
    public AddClient(){
        userRepository = new UserRepository();
    }

    public boolean existingUsername(String username){

        User c = userRepository.findClientByUsername(username);

        return c!=null;

    }

    public void addClient(Client c) {

        JOptionPane.showMessageDialog(null, "Inregistrare cu succes!");

        String sql = "INSERT INTO clients VALUES(NULL, ?, ?, ?, ?, ?)";

        try(
                Connection con = DataBaseConnection.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ){

            statement.setString(1, c.getUsername());
            statement.setString(2, c.getPassword());
            statement.setString(3, c.getName());
            statement.setString(4, c.getPhoneNumber());
            statement.setInt(5, c.getBonusPoints());

            statement.execute();


        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private final static AddClient getInstance() {
        return SingleTonHolder.INSTANCE;
    }

    private static class SingleTonHolder {
        private final static AddClient INSTANCE = new AddClient();
    }
}
