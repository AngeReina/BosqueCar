package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.*;

public class CotizacionMapper implements DataMapper<Cotizacion, CotizacionDTO>{

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
        Cliente cliente = new Cliente("", "", dto.getCedula(), "correo@desconocido.com");
        Vehiculo vehiculo;

        String tipoVehiculo = obtenerTipoVehiculo(dto.getIdVehiculo());

        if ("Carga".equals(tipoVehiculo)) {
            vehiculo = new VehiculoCarga(
                    dto.getIdVehiculo(),
                    "MarcaDesconocida",
                    "ModeloDesconocido",
                    2000,
                    0.0,
                    0.0,
                    "EstadoDesconocido",
                    "Disponible",
                    500.0,
                    "Diesel",
                    "4x4"
            );
        } else if ("Familiar".equals(tipoVehiculo)) {
            vehiculo = new VehiculoFamiliar(
                    dto.getIdVehiculo(),
                    "MarcaDesconocida",
                    "ModeloDesconocido",
                    2020,
                    15000.0,
                    20000.0,
                    "Buen estado",
                    "Disponible",
                    7,
                    "ABS, Airbags",
                    "Aire acondicionado, GPS"
            );
        } else if ("Utilitario".equals(tipoVehiculo)) {
            vehiculo = new VehiculoUtilitario(
                    dto.getIdVehiculo(),
                    "MarcaDesconocida",
                    "ModeloDesconocido",
                    2015,
                    12000.0,
                    50000.0,
                    "Usado",
                    "No disponible",
                    500.0,
                    "Portaequipaje, Radio Bluetooth"
            );
        } else {
            throw new IllegalArgumentException("Tipo de vehículo desconocido");
        }

        return new Cotizacion(
                dto.getIdCotizacion(),
                cliente,
                vehiculo,
                dto.getFecha(),
                dto.getEstado()
        );
    }
    private String obtenerTipoVehiculo(int idVehiculo) {
        if (idVehiculo % 3 == 0) return "Carga";
        if (idVehiculo % 3 == 1) return "Familiar";
        return "Utilitario";
    }
}
