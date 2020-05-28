package managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection { /// conectarea la baza de date, clasa care este singleton, adica poate exista maxim un obiect de acest tip

    public DataBaseConnection() {

    }

    public Connection createConnection() {
        String url = "jdbc:mysql://localhost:3306/firma_de_transport";
        String username = "root";
        String password = "";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public final static DataBaseConnection getInstance() {
        return DataBaseConnection.SingleTonHolder.INSTANCE;
    }
    private static final class SingleTonHolder{

        private static final  DataBaseConnection INSTANCE = new DataBaseConnection();
    }

}
