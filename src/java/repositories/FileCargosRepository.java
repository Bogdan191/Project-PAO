package repositories;

import managers.DataBaseConnection;
import model.Cargo;
import org.jetbrains.annotations.ApiStatus;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileCargosRepository implements  CargosRepository{

    private final String file = "Cargos";

    @Override
    public void addCargoCommand(Cargo c){
            try{
                String msg = c.getUsername()+ "," + c.getSender() + "," + c.getRecipient()+ "," + c.getDescrition() + "," +
                        c.getPickUpLocation() + "," + c.getDestination()+ "," + c.getWeight() + "," + c.getVolume() + "\n";
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                writer.append(msg);
                writer.close();
            }catch(IOException e) {
                e.printStackTrace();
            }
    }
    @Override
    public Cargo[] getCargos() {

        Path path = Paths.get(file);
        Cargo[] cargos = new Cargo[100];
        try {

           var listCargo = Files.readAllLines(path);
           int index = 0;
            for (String c : listCargo) {
                String [] line  = c.split(",");
                cargos[index] = new Cargo(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7]);
                index++;
            }
            return cargos;
        }catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
