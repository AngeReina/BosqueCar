package co.edu.unbosque.model;

import java.time.LocalDate;

public class CotizacionDTO {
    private int idCotizacion;
    private int idCliente;
    private int idVehiculo;
    private LocalDate fecha;
    private String estado;

    public CotizacionDTO(int idCotizacion, int idCliente, int idVehiculo, LocalDate fecha, String estado) {
        this.idCotizacion = idCotizacion;
        this.idCliente = idCliente;
        this.idVehiculo = idVehiculo;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdCotizacion() { return idCotizacion; }
    public void setIdCotizacion(int idCotizacion) { this.idCotizacion = idCotizacion; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdVehiculo() { return idVehiculo; }
    public void setIdVehiculo(int idVehiculo) { this.idVehiculo = idVehiculo; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
