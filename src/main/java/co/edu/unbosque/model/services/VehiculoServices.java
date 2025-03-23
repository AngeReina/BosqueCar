package co.edu.unbosque.model.services;

import co.edu.unbosque.model.entities.Vehiculo;
import co.edu.unbosque.model.entities.VehiculoCarga;
import co.edu.unbosque.model.entities.VehiculoFamiliar;
import co.edu.unbosque.model.entities.VehiculoUtilitario;
import co.edu.unbosque.model.persistence.VehiculoDAO;
import co.edu.unbosque.model.persistence.VehiculoCargaDAOImpl;
import co.edu.unbosque.model.persistence.VehiculoFamiliarDAOImpl;
import co.edu.unbosque.model.persistence.VehiculoUtilitarioDAOImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class VehiculoServices {

    private final VehiculoDAO<VehiculoCarga> vehiculoCargaDAO;
    private final VehiculoDAO<VehiculoFamiliar> vehiculoFamiliarDAO;
    private final VehiculoDAO<VehiculoUtilitario> vehiculoUtilitarioDAO;

    public VehiculoServices(Connection conexion) {
        this.vehiculoCargaDAO = new VehiculoCargaDAOImpl(conexion);
        this.vehiculoFamiliarDAO = new VehiculoFamiliarDAOImpl(conexion);
        this.vehiculoUtilitarioDAO = new VehiculoUtilitarioDAOImpl(conexion);
    }

    public void insertarVehiculoCarga(VehiculoCarga vehiculo) {
        vehiculoCargaDAO.insertar(vehiculo);
    }

    public VehiculoCarga obtenerVehiculoCargaPorID(Integer id) {
        return vehiculoCargaDAO.obtenerID(id);
    }

    public List<VehiculoCarga> listarVehiculosCarga() {
        return vehiculoCargaDAO.listar();
    }

    public void actualizarVehiculoCarga(VehiculoCarga vehiculo) {
        vehiculoCargaDAO.actualizar(vehiculo);
    }

    public void eliminarVehiculoCarga(Integer id) {
        vehiculoCargaDAO.eliminar(id);
    }

    public void insertarVehiculoFamiliar(VehiculoFamiliar vehiculo) {
        vehiculoFamiliarDAO.insertar(vehiculo);
    }

    public VehiculoFamiliar obtenerVehiculoFamiliarPorID(Integer id) {
        return vehiculoFamiliarDAO.obtenerID(id);
    }

    public List<VehiculoFamiliar> listarVehiculosFamiliares() {
        return vehiculoFamiliarDAO.listar();
    }

    public void actualizarVehiculoFamiliar(VehiculoFamiliar vehiculo) {
        vehiculoFamiliarDAO.actualizar(vehiculo);
    }

    public void eliminarVehiculoFamiliar(Integer id) {
        vehiculoFamiliarDAO.eliminar(id);
    }

    public void insertarVehiculoUtilitario(VehiculoUtilitario vehiculo) {
        vehiculoUtilitarioDAO.insertar(vehiculo);
    }

    public VehiculoUtilitario obtenerVehiculoUtilitarioPorID(Integer id) {
        return vehiculoUtilitarioDAO.obtenerID(id);
    }

    public List<VehiculoUtilitario> listarVehiculosUtilitarios() {
        return vehiculoUtilitarioDAO.listar();
    }

    public void actualizarVehiculoUtilitario(VehiculoUtilitario vehiculo) {
        vehiculoUtilitarioDAO.actualizar(vehiculo);
    }

    public void eliminarVehiculoUtilitario(Integer id) {
        vehiculoUtilitarioDAO.eliminar(id);
    }

    public List<Vehiculo> buscarPorMarca(String marca) {
        List<Vehiculo> resultado = new ArrayList<>();
        resultado.addAll(vehiculoCargaDAO.buscarPorMarca(marca));
        resultado.addAll(vehiculoFamiliarDAO.buscarPorMarca(marca));
        resultado.addAll(vehiculoUtilitarioDAO.buscarPorMarca(marca));
        return resultado;
    }
}
