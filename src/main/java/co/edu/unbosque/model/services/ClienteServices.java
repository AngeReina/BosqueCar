package co.edu.unbosque.model.services;

import co.edu.unbosque.model.ClienteDTO;
import co.edu.unbosque.model.ClienteMapper;
import co.edu.unbosque.model.entities.Cliente;
import co.edu.unbosque.model.persistence.ClienteDAO;
import co.edu.unbosque.model.persistence.ClienteDAOImpl;

import java.sql.Connection;
import java.util.List;

public class ClienteServices {
    private ClienteDAO clienteDAO;
    private ClienteMapper clienteMapper;

    public ClienteServices(Connection conexion) {
        this.clienteDAO = new ClienteDAOImpl(conexion);
        this.clienteMapper = new ClienteMapper();
    }
    public void registrarCliente(ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        clienteDAO.insertar(cliente);
    }
    public ClienteDTO obtenerCliente(String cedula){
        Cliente cliente = clienteDAO.obtenerID(Integer.valueOf(cedula));
        return (cliente != null) ? clienteMapper.toDTO(cliente) : null;
    }
    public List<ClienteDTO> listarCliente(){
        return clienteDAO.listar().stream().map(clienteMapper::toDTO).toList();
    }
    public void actualizarCliente(ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        clienteDAO.actualizar(cliente);
    }
    public void eliminarCliente(String cedula) {
        clienteDAO.eliminar(Integer.valueOf(cedula));
    }
}
