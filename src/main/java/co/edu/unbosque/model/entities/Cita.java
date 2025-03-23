package co.edu.unbosque.model.entities;

import co.edu.unbosque.model.entities.Cliente;

import java.time.LocalDate;

public class Cita {
    private int idCita;
    private Cliente cliente;
    private LocalDate fecha;
    private String motivo;
    private String estado;

    public Cita(int idCita, Cliente cliente, LocalDate fecha, String motivo, String estado) {
        this.idCita = idCita;
        this.cliente = cliente;
        this.fecha = fecha;
        this.motivo = motivo;
        this.estado = estado;
    }

    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public int getCedula() {
        return (cliente != null) ? cliente.getCedula() : 0; // Evita errores si cliente es null
    }
}
