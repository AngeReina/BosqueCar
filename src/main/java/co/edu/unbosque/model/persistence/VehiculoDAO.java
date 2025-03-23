package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.entities.Vehiculo;

import java.util.List;

public interface VehiculoDAO <T extends Vehiculo> extends DAO<T, Integer> {
    List<T> buscarPorMarca(String marca);
}
