package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.Cliente;
import co.edu.unbosque.model.entities.Vehiculo;

import java.time.LocalDate;

public class CotizacionDTO {

    private int idCotizacion;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fecha;
    private String estado;

    public int getIdCotizacion() {
        return idCotizacion;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public String getEstado() {
        return estado;
    }
}
