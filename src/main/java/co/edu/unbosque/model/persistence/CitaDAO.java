package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.CitaDTO;

import java.util.List;

public interface CitaDAO extends DAO<CitaDTO, Integer> {
    List<CitaDTO> obtenerCitaPorCliente(int idCliente);
}
