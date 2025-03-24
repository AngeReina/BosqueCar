package co.edu.unbosque.model;

import java.time.LocalDateTime;

public class CitaDTO {
    private int idCita;
    private int cedula;
    private int idVehiculo;
    private LocalDateTime fecha;
    private String motivo;
    private String estado;

    // Constructor
    public CitaDTO(int idCita, int cedula, int idVehiculo, LocalDateTime fecha, String motivo, String estado) {
        this.idCita = idCita;
        this.cedula = cedula;
        this.idVehiculo = idVehiculo;
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

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
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