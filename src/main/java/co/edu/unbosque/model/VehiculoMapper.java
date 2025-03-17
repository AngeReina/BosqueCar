package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.Vehiculo;
import co.edu.unbosque.model.entities.VehiculoCarga;
import co.edu.unbosque.model.entities.VehiculoFamiliar;
import co.edu.unbosque.model.entities.VehiculoUtilitario;

public class VehiculoMapper implements DataMapper<Vehiculo, VehiculoDTO> {

    @Override
    public VehiculoDTO toDTO(Vehiculo vehiculo) {
        return new VehiculoDTO(
                vehiculo.getIdVehiculo(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getAnio(),
                vehiculo.getPrecio(),
                vehiculo.getKilometraje(),
                vehiculo.getEstado(),
                vehiculo.getDisponibilidad()
                );
    }

    @Override
    public Vehiculo toEntity(VehiculoDTO dto) {
        if (dto instanceof  VehiculoCargaDTO){
            VehiculoCargaDTO cargaDTO = (VehiculoCargaDTO) dto;
            return new VehiculoCarga(
                    cargaDTO.getIdVehiculo(),
                    cargaDTO.getMarca(),
                    cargaDTO.getModelo(),
                    cargaDTO.getAnio(),
                    cargaDTO.getPrecio(),
                    cargaDTO.getKilometraje(),
                    cargaDTO.getEstado(),
                    cargaDTO.getDisponibilidad(),
                    cargaDTO.getCapacidadCarga(),
                    cargaDTO.getTipoCombustible(),
                    cargaDTO.getTraccion()
            );
        } else if( dto instanceof VehiculoFamiliarDTO) {
            VehiculoFamiliarDTO familiarDTO = (VehiculoFamiliarDTO) dto;
            return new VehiculoFamiliar(
                    familiarDTO.getIdVehiculo(),
                    familiarDTO.getMarca(),
                    familiarDTO.getModelo(),
                    familiarDTO.getAnio(),
                    familiarDTO.getPrecio(),
                    familiarDTO.getKilometraje(),
                    familiarDTO.getEstado(),
                    familiarDTO.getDisponibilidad(),
                    familiarDTO.getCapacidadPasajeros(),
                    familiarDTO.getSistemaSeguridad(),
                    familiarDTO.getConfort()
            );
        }else if (dto instanceof VehiculoUtilitarioDTO){
            VehiculoUtilitarioDTO utilitarioDTO = (VehiculoUtilitarioDTO) dto;
            return new VehiculoUtilitario(
                    utilitarioDTO.getIdVehiculo(),
                    utilitarioDTO.getMarca(),
                    utilitarioDTO.getModelo(),
                    utilitarioDTO.getAnio(),
                    utilitarioDTO.getPrecio(),
                    utilitarioDTO.getKilometraje(),
                    utilitarioDTO.getEstado(),
                    utilitarioDTO.getDisponibilidad(),
                    utilitarioDTO.getTamanoMaletero(),
                    utilitarioDTO.getEquipamientoEspecial()
            );
        } else {
            throw new IllegalArgumentException("Tipo de vehículo desconocido");
        }
    }
}
