package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.*;
import co.edu.unbosque.model.CotizacionDTO;

public class CotizacionMapper implements DataMapper<Cotizacion, CotizacionDTO> {

    @Override
    public CotizacionDTO toDTO(Cotizacion cotizacion) {
        return new CotizacionDTO(
                cotizacion.getIdCotizacion(),
                cotizacion.getCliente().getCedula(),
                cotizacion.getVehiculo().getIdVehiculo(),
                cotizacion.getFecha(),
                cotizacion.getEstado()
        );
    }

    @Override
    public Cotizacion toEntity(CotizacionDTO dto) {
        Cliente cliente = new Cliente(dto.getCedula(), "","", "correo@desconocido.com");
        Categoria categoria = new Categoria(1, "Desconocida"); // Asigna una categoría por defecto

        Vehiculo vehiculo = new Vehiculo(
                dto.getIdVehiculo(),
                null,
                "MarcaDesconocida",
                "ModeloDesconocido",
                2000, // Año por defecto
                0.0,
                0,
                Vehiculo.Estado.NUEVO,
                Vehiculo.Disponibilidad.DISPONIBLE,
                categoria,
                null, // Capacidad de carga por defecto
                null, // Tipo de combustible por defecto
                null, // Tracción por defecto
                null, // Capacidad de pasajeros por defecto
                null, // Sistema de seguridad por defecto
                null, // Confort por defecto
                null, // Tamaño del maletero por defecto
                null  // Equipamiento especial por defecto
        );

        return new Cotizacion(
                dto.getIdCotizacion(),
                cliente,
                vehiculo,
                dto.getFecha(),
                dto.getEstado()
        );
    }
}