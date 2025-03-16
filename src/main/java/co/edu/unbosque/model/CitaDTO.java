package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.Cliente;

import java.time.LocalDate;

public class CitaDTO {

    private int idCita;
    private int idCliente;
    private LocalDate fecha;
    private String motivo;
    private String estado;

    public CitaDTO(int idCita, int idCliente, LocalDate fecha, String motivo, String estado) {
    }

    public int getIdCita() {
        return idCita;
    }
    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public void setFecha(LocalDate fecha) {
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
