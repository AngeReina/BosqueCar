package co.edu.unbosque.model;

import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.entities.Administrador;

public class AdministradorMapper implements DataMapper<Administrador, AdministradorDTO> {

    @Override
    public AdministradorDTO toDTO(Administrador administrador) {
        return new AdministradorDTO(
                administrador.getIdAdmin(),
                administrador.getNombre(),
                administrador.getEmail()
        );
    }

    @Override
    public Administrador toEntity(AdministradorDTO dto) {
        return new Administrador(
                dto.getIdAdmin(),
                dto.getNombre(),
                dto.getEmail()
        );
    }
}
