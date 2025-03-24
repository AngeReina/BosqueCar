package co.edu.unbosque.model.services;

import co.edu.unbosque.model.entities.Vehiculo;
import co.edu.unbosque.model.persistence.VehiculoDAO;
import co.edu.unbosque.model.persistence.VehiculoDAOImpl;

import java.sql.Connection;
import java.util.List;

public class VehiculoServices {

    private final VehiculoDAO vehiculoDAO;

    public VehiculoServices(Connection conexion) {
        this.vehiculoDAO = new VehiculoDAOImpl(conexion);
    }

    public void insertarVehiculo(Vehiculo vehiculo) {
        vehiculoDAO.insertar(vehiculo);
    }

    public Vehiculo obtenerVehiculoPorID(Integer id) {
        return vehiculoDAO.obtenerID(id);
    }

    public List<Vehiculo> listarVehiculos() {
        return vehiculoDAO.listar();
    }

    public void actualizarVehiculo(Vehiculo vehiculo) {
        vehiculoDAO.actualizar(vehiculo);
    }

    public void eliminarVehiculo(Integer id) {
        vehiculoDAO.eliminar(id);
    }

    public List<Vehiculo> buscarPorMarca(String marca) {
        return vehiculoDAO.buscarPorMarca(marca);
    }
}
