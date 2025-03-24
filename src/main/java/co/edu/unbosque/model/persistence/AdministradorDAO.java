package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.CitaDTO;

import java.util.List;

public interface AdministradorDAO extends DAO<AdministradorDTO, Integer> {
    AdministradorDTO obtenerPorEmail(String email);
}