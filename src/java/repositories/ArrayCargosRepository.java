package repositories;

import model.Cargo;

public class ArrayCargosRepository implements  CargosRepository{
    private Cargo[] cargos = new Cargo[10];
    private int nrCargo;

    @Override
    public void addCargoCommand(Cargo c) {
        try{
            cargos[nrCargo] = c;
            nrCargo++;
        } catch(Exception e) {
            System.out.println("Array full!");
        }
    }

    @Override
    public Cargo[] getCargos(){
        return cargos;
    }

}
