package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.entities.Cliente;

import java.util.List;

public interface ClienteDAO  extends DAO<Cliente, Integer>{
    List<Cliente> buscarPorNombre(String nombre);
}
