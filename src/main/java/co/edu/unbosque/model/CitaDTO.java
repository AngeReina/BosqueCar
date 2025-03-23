package co.edu.unbosque.model;

import java.time.LocalDate;

public class CitaDTO {
    private int idCita;
    private int cedula;
    private LocalDate fecha;
    private String motivo;
    private String estado;

    public CitaDTO(int idCita, int cedula, LocalDate fecha, String motivo, String estado) {
        this.idCita = idCita;
        this.cedula = cedula;
        this.fecha = fecha;
        this.motivo = motivo;
        this.estado = estado;
    }

    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }

    public int getCedula() { return cedula; }
    public void setIdCliente(int idCliente) { this.cedula = idCliente; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}

