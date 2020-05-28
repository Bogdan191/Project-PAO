package repositories;

import managers.DataBaseConnection;
import model.Route;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoutesRepository {

    Route[] routes = new Route[100];

    public RoutesRepository() {

    }
    public Route[] getRoutes() {

        String sql = "SELECT * FROM routes";

        try(
                Connection con = DataBaseConnection.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ){

            ResultSet set = statement.executeQuery();
            System.out.println(set);
            int index = 0;

            while (set.next()){

                    String uniqueCode = set.getString("uniqueCode");
                    String startPoint = set.getString("startPoint");
                    String destination = set.getString("destination");
                    int length  = set.getInt("length");
                    String time = set.getString("time");
                    String stopPoint1 = set.getString("stopPoint1");
                    String stopPoint2 = set.getString("stopPoint2");
                    String stopPoint3 = set.getString("stopPoint3");
                    String[] stopPoints = {stopPoint1, stopPoint2, stopPoint3};
                    routes[index] = new Route(uniqueCode, startPoint, destination, length, time, stopPoints);
                    index++;

            }
                return routes;

        }catch(SQLException e) {
            System.out.println("Eroare in getRoutes()");

        }

        return  routes;


    }
}
