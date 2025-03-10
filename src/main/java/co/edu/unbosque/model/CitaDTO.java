package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.Cliente;

import java.time.LocalDate;

public class CitaDTO {

    private int idCita;
    private Cliente cliente;
    private LocalDate fecha;
    private String motivo;
    private String estado;

    public int getIdCita() {
        return idCita;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public String getMotivo() {
        return motivo;
    }
    public String getEstado() {
        return estado;
    }
}
