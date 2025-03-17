package co.edu.unbosque.model.entities;

import java.time.LocalDate;

public class Cotizacion {
    private int idCotizacion;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fecha;
    private String estado;

    public Cotizacion(int idCotizacion, Cliente cliente, Vehiculo vehiculo, LocalDate fecha, String estado) {
        this.idCotizacion = idCotizacion;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdCotizacion() { return idCotizacion; }
    public void setIdCotizacion(int idCotizacion) { this.idCotizacion = idCotizacion; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public int getIdCliente() {
        return (cliente != null) ? cliente.getCedula() : 0; // Retorna el ID si el cliente existe, sino 0
    }

    public int getIdVehiculo() {
        return (vehiculo != null) ? vehiculo.getIdVehiculo() : 0; // Retorna el ID si el vehículo existe, sino 0
    }
}


