package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.CotizacionDTO;

import java.util.List;

public interface CotizacionDAO extends DAO <CotizacionDTO, Integer> {
    List<CotizacionDTO> obtenerPorEstado(String estado);
}
