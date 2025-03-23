package co.edu.unbosque.model.services;

import co.edu.unbosque.model.CotizacionDTO;
import co.edu.unbosque.model.persistence.CotizacionDAO;
import co.edu.unbosque.model.persistence.CotizacionDAOImpl;

import java.sql.Connection;
import java.util.List;

public class CotizacionServices {

    private final CotizacionDAO cotizacionDAO;

    public CotizacionServices(Connection conexion) {
        this.cotizacionDAO = new CotizacionDAOImpl(conexion);
    }

    public void insertarCotizacion(CotizacionDTO cotizacion) {
        cotizacionDAO.insertar(cotizacion);
    }

    public CotizacionDTO obtenerCotizacionPorID(int idCotizacion) {
        return cotizacionDAO.obtenerID(idCotizacion);
    }

    public List<CotizacionDTO> listarCotizaciones() {
        return cotizacionDAO.listar();
    }

    public void actualizarCotizacion(CotizacionDTO cotizacion) {
        cotizacionDAO.actualizar(cotizacion);
    }

    public void eliminarCotizacion(int idCotizacion) {
        cotizacionDAO.eliminar(idCotizacion);
    }

    public List<CotizacionDTO> obtenerCotizacionesPorEstado(String estado) {
        return cotizacionDAO.obtenerPorEstado(estado);
    }
}