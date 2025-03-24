package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.Vehiculo;
import co.edu.unbosque.model.entities.Categoria;

public class VehiculoMapper implements DataMapper<Vehiculo, VehiculoDTO> {

    @Override
    public VehiculoDTO toDTO(Vehiculo vehiculo) {
        return new VehiculoDTO(
                vehiculo.getIdVehiculo(),
                vehiculo.getPlaca(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getAnio(),
                vehiculo.getPrecio(),
                vehiculo.getKilometraje(),
                vehiculo.getEstado(),
                vehiculo.getDisponibilidad(),
                vehiculo.getCategoria().getIdCategoria(),
                vehiculo.getCapacidadCarga(),
                vehiculo.getTipoCombustible(),
                vehiculo.getTraccion(),
                vehiculo.getCapacidadPasajeros(),
                vehiculo.getSistemaSeguridad(),
                vehiculo.getConfort(),
                vehiculo.getTamanoMaletero(),
                vehiculo.getEquipamientoEspecial()
        );
    }

    @Override
    public Vehiculo toEntity(VehiculoDTO dto) {
        Categoria categoria = new Categoria(dto.getIdCategoria(), "Desconocida"); // Asigna una categoría por defecto
        return new Vehiculo(
                dto.getIdVehiculo(),
                dto.getPlaca(),
                dto.getMarca(),
                dto.getModelo(),
                dto.getAnio(),
                dto.getPrecio(),
                dto.getKilometraje(),
                Vehiculo.Estado.valueOf(dto.getEstado().name()),
                Vehiculo.Disponibilidad.valueOf(dto.getDisponibilidad().name()),
                categoria,
                dto.getCapacidadCarga(),
                dto.getTipoCombustible(),
                dto.getTraccion(),
                dto.getCapacidadPasajeros(),
                dto.getSistemaSeguridad(),
                dto.getConfort(),
                dto.getTamanoMaletero(),
                dto.getEquipamientoEspecial()
        );
    }
}