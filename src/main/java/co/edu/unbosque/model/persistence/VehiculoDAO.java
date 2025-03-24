package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.entities.Vehiculo;

import java.util.List;

public interface VehiculoDAO extends DAO<Vehiculo, Integer> {
    List<Vehiculo> buscarPorMarca(String marca);
}