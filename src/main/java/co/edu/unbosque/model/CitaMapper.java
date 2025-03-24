package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.Cita;
import co.edu.unbosque.model.entities.Cliente;
import co.edu.unbosque.model.entities.Vehiculo;
import co.edu.unbosque.model.CitaDTO;

public class CitaMapper implements DataMapper<Cita, CitaDTO> {

    @Override
    public CitaDTO toDTO(Cita cita) {
        return new CitaDTO(
                cita.getIdCita(),
                cita.getCliente().getCedula(),
                cita.getVehiculo().getIdVehiculo(),
                cita.getFecha(),
                cita.getMotivo(),
                cita.getEstado()
        );
    }

    @Override
    public Cita toEntity(CitaDTO dto) {
        Cliente cliente = new Cliente(dto.getCedula(), "", "", "");
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setIdVehiculo(dto.getIdVehiculo());

        return new Cita(
                dto.getIdCita(),
                cliente,
                vehiculo,
                dto.getFecha(),
                dto.getMotivo(),
                dto.getEstado()
        );
    }
}