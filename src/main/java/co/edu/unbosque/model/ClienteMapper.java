package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.Cliente;


public class ClienteMapper implements DataMapper<Cliente, ClienteDTO> {

    @Override
    public ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getCedula(),
                cliente.getCorreo()
        );
    }

    @Override
    public Cliente toEntity(ClienteDTO dto) {
        return new Cliente(
                dto.getNombre(),
                dto.getApellido(),
                dto.getCedula(),
                dto.getCorreo()
        );
    }
}
