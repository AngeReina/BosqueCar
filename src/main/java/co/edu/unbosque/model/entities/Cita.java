package co.edu.unbosque.model.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private int idCita;

    @ManyToOne
    @JoinColumn(name = "cedula", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo vehiculo;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "motivo", nullable = false)
    private String motivo;

    @Column(name = "estado", nullable = false)
    private String estado;

    public Cita() {}

    public Cita(int idCita, Cliente cliente, Vehiculo vehiculo, LocalDateTime fecha, String motivo, String estado) {
        this.idCita = idCita;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.motivo = motivo;
        this.estado = estado;
    }

    // Getters y setters
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}