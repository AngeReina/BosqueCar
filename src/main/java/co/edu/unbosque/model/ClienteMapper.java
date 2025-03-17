package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.Cliente;

import javax.xml.crypto.Data;

public class ClienteMapper implements DataMapper<Cliente, ClienteDTO> {

    @Override
    public ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getCedula(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getCorreo()
        );
    }

    @Override
    public Cliente toEntity(ClienteDTO dto) {
        return new Cliente(
                dto.getCedula(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getCorreo()
        );
    }
}
