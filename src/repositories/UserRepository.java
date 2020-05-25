package repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import managers.DataBaseConnection;
import model.Client;
import model.User;
import model.User;

public class UserRepository {

    public void addUser(Client client) {
        String sql = "INSERT INTO clients VALUES(NULL, ?, ?, ?, ?, ?)";

        try (
                Connection con = DataBaseConnection.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ){
            statement.setString(1, client.getUsername());
            statement.setString(2, client.getPassword());
            statement.setString(3, client.getName());
            statement.setString(4, client.getPhoneNumber());
            statement.setInt(5, client.getBonusPoints());
            statement.execute();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public User findClientByUsername(String username) {
        String sql = "SELECT * FROM clients WHERE username = ?";

        try(
                Connection con = DataBaseConnection.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ){

            statement.setString(1, username);
            ResultSet set = statement.executeQuery();
            set.next();
            String password = set.getString("password");

            return new User(username, password);

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static UserRepository getInstance() {
        return UserRepository.SingleTonHolder.INSTANCE;
    }
    private final static  class SingleTonHolder {
            private static  final UserRepository INSTANCE = new UserRepository();
    }
}
