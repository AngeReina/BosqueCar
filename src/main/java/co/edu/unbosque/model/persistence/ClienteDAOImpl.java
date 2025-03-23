package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.entities.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO{

    private Connection conexion;

    public ClienteDAOImpl(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void insertar(Cliente cliente) {
        String sql ="INSERT INTO cliente (nombre,apellido,cedula,correo) VALUES (?,?,?,?)";
        try(PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setInt(3, cliente.getCedula());
            stmt.setString(4, cliente.getCorreo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cliente obtenerID(Integer cedula) {
        String sql ="SELECT * FROM cliente WHERE cedula=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setInt(1,cedula);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new Cliente(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("cedula"),
                        rs.getString("correo")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> cliente  = new ArrayList<>();
        String  sql ="SELECT * FROM cliente";
        try(Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
           while(rs.next()){
               cliente.add(new Cliente(
                       rs.getString("nombre"),
                       rs.getString("apellido"),
                       rs.getInt("cedula"),
                       rs.getString("correo")
               ));
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    @Override
    public void actualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nombre=?, apellido=?, correo=? WHERE cedula=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getCorreo());
            stmt.setInt(4, cliente.getCedula());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void eliminar(Integer id) {
        String sql = "DELETE FROM cliente WHERE cedula=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cliente> buscarPorNombre(String nombre) {
        List<Cliente> cliente = new ArrayList<>();
        String sql ="SELECT * FROM cliente WHERE nombre LIKE ?";
        try(PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setString(1,"%"+nombre+"%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                cliente.add(new Cliente(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("cedula"),
                        rs.getString("correo")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
}
