package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.Cita;
import co.edu.unbosque.model.entities.Cliente;

public class CitaMapper implements DataMapper<Cita, CitaDTO> {

    @Override
    public CitaDTO toDTO(Cita cita) {
        return new CitaDTO(
                cita.getIdCita(),
                cita.getCliente().getCedula(),
                cita.getFecha(),
                cita.getMotivo(),
                cita.getEstado()
        );
    }

    @Override
    public Cita toEntity(CitaDTO dto) {
        Cliente cliente = new Cliente("", "", dto.getCedula(), "");


        return new Cita(
                dto.getIdCita(),
                cliente,
                dto.getFecha(),
                dto.getMotivo(),
                dto.getEstado()
        );
    }
}
