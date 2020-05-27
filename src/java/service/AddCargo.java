package service;

import model.Cargo;
import repositories.CargosRepository;

public class AddCargo {
    CargosRepository dbcargosrepository;
    CargosRepository filecargosrepository;
    public AddCargo(){
        dbcargosrepository = CargosRepository.build(CargosRepository.Type.DB);
        filecargosrepository = CargosRepository.build(CargosRepository.Type.FILE);
    }

    public void addCargoCommand(Cargo c) {
        dbcargosrepository.addCargoCommand(c);
        filecargosrepository.addCargoCommand(c);
    }

    public static AddCargo getInstance() {
        return SingleTonHolder.INSTANCE;
    }

    private static class SingleTonHolder {
       private static final AddCargo INSTANCE = new AddCargo();
    }
}
