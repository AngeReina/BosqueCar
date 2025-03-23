package co.edu.unbosque.model.services;

import co.edu.unbosque.model.CitaDTO;
import co.edu.unbosque.model.persistence.CitaDAO;
import co.edu.unbosque.model.persistence.CitaDAOImpl;

import java.sql.Connection;
import java.util.List;

public class CitaServices {

    private final CitaDAO citaDAO;

    public CitaServices(Connection conexion) {
        this.citaDAO = new CitaDAOImpl(conexion);
    }

    public void insertarCita(CitaDTO cita) {
        citaDAO.insertar(cita);
    }

    public CitaDTO obtenerCitaPorID(int idCita) {
        return citaDAO.obtenerID(idCita);
    }

    public List<CitaDTO> listarCitas() {
        return citaDAO.listar();
    }

    public void actualizarCita(CitaDTO cita) {
        citaDAO.actualizar(cita);
    }

    public void eliminarCita(int idCita) {
        citaDAO.eliminar(idCita);
    }

    public List<CitaDTO> obtenerCitasPorCliente(int idCliente) {
        return citaDAO.obtenerCitaPorCliente(idCliente);
    }
}
