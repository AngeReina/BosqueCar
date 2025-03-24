package co.edu.unbosque.model.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cotizacion")
public class Cotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cotizacion")
    private int idCotizacion;

    @ManyToOne
    @JoinColumn(name = "cedula", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo vehiculo;

    @Column(name = "fecha_cotizacion", nullable = false)
    private LocalDate fecha;

    @Column(name = "estado", nullable = false)
    private String estado;

    public Cotizacion() {}

    public Cotizacion(int idCotizacion, Cliente cliente, Vehiculo vehiculo, LocalDate fecha, String estado) {
        this.idCotizacion = idCotizacion;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Getters y setters
    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}