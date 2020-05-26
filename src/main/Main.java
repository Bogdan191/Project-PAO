package main;

import gui.LoginFrame;
import gui.MainPageClient;
import model.Bus;
import model.Truck;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Vehicle("Ford Transit", "B 999 XDS", "Ionut", 10, 233122));
        vehicles.add(new Vehicle("Mercedes Sprinter", "B 999 XDT", "Bogdan", 15, 444321));
        vehicles.add(new Vehicle("VW Crafter", "B 999 XDU", "Cristian", 6, 123222));
        vehicles.add(new Bus("B", "asd", "DD", 12, 11231, 45));
        vehicles.add(new Truck("Scania R700", "B 999 XDW", "Toni", 3, 211000, 20, 30));

       for(var i = 0; i <vehicles.size(); i++) {

           var vehicle = vehicles.get(i);
           System.out.println(vehicle.getName());


       }

       new MainPageClient();

    }
}
