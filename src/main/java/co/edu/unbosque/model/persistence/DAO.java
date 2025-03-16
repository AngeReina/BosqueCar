package co.edu.unbosque.model.persistence;

import java.util.List;

public interface DAO <T, K>  {
    void insertar(T entidad);
    T obtenerID(K id);
    List<T> listar();
    void actualizar(T entidad);
    void eliminar(K id);
}
