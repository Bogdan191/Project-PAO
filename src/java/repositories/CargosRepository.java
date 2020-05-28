package repositories;

import model.Cargo;

import java.io.IOException;
import java.lang.reflect.Type;

public interface CargosRepository { //contract intre cele 2 tipuri de 'CorgosRepository' si servicii

    void addCargoCommand(Cargo c);
    Cargo[] getCargos();

    static CargosRepository build(Type type) {
        switch(type){
            case DB: return new DBCargosRepository();
            case FILE: return new FileCargosRepository();
            case ARRAY: return new ArrayCargosRepository();
        }
        throw new RuntimeException("No such type");
    }
    enum Type{
        DB, FILE, ARRAY
    }




}
