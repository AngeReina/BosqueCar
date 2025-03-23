package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.VehiculoDTO;
import co.edu.unbosque.model.VehiculoFamiliarDTO;
import co.edu.unbosque.model.entities.VehiculoFamiliar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class VehiculoFamiliarDAOImpl implements VehiculoDAO<VehiculoFamiliar> {

    private final Connection conexion;

    public VehiculoFamiliarDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(VehiculoFamiliar vehiculo) {
        String sql = "INSERT INTO vehiculo_familiar (marca, modelo, anio, precio, kilometraje, estado, disponibilidad, capacidadPasajeros, sistemaSeguridad, confort) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getModelo());
            stmt.setInt(3, vehiculo.getAnio());
            stmt.setDouble(4, vehiculo.getPrecio());
            stmt.setDouble(5, vehiculo.getKilometraje());
            stmt.setString(6, vehiculo.getEstado());
            stmt.setString(7, vehiculo.getDisponibilidad());
            stmt.setInt(8, vehiculo.getCapacidadPasajeros());
            stmt.setString(9, vehiculo.getSistemaSeguridad());
            stmt.setString(10, vehiculo.getConfort());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar vehículo familiar", e);
        }
    }

    @Override
    public VehiculoFamiliar obtenerID(Integer id) {
        String sql = "SELECT * FROM vehiculo_familiar WHERE idVehiculo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new VehiculoFamiliar(
                        rs.getInt("idVehiculo"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getDouble("precio"),
                        rs.getDouble("kilometraje"),
                        rs.getString("estado"),
                        rs.getString("disponibilidad"),
                        rs.getInt("capacidadPasajeros"),
                        rs.getString("sistemaSeguridad"),
                        rs.getString("confort")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener vehículo familiar por ID", e);
        }
        return null;
    }

    @Override
    public List<VehiculoFamiliar> listar() {
        List<VehiculoFamiliar> lista = new ArrayList<>();
        String sql = "SELECT * FROM vehiculo_familiar";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new VehiculoFamiliar(
                        rs.getInt("idVehiculo"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getDouble("precio"),
                        rs.getDouble("kilometraje"),
                        rs.getString("estado"),
                        rs.getString("disponibilidad"),
                        rs.getInt("capacidadPasajeros"),
                        rs.getString("sistemaSeguridad"),
                        rs.getString("confort")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar vehículos familiares", e);
        }
        return lista;
    }

    @Override
    public void actualizar(VehiculoFamiliar vehiculo) {
        String sql = "UPDATE vehiculo_familiar SET marca=?, modelo=?, anio=?, precio=?, kilometraje=?, estado=?, disponibilidad=?, capacidadPasajeros=?, sistemaSeguridad=?, confort=? WHERE idVehiculo=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getModelo());
            stmt.setInt(3, vehiculo.getAnio());
            stmt.setDouble(4, vehiculo.getPrecio());
            stmt.setDouble(5, vehiculo.getKilometraje());
            stmt.setString(6, vehiculo.getEstado());
            stmt.setString(7, vehiculo.getDisponibilidad());
            stmt.setInt(8, vehiculo.getCapacidadPasajeros());
            stmt.setString(9, vehiculo.getSistemaSeguridad());
            stmt.setString(10, vehiculo.getConfort());
            stmt.setInt(11, vehiculo.getIdVehiculo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar vehículo familiar", e);
        }
    }

    @Override
    public void eliminar(Integer id) {
        String sql = "DELETE FROM vehiculo_familiar WHERE idVehiculo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar vehículo familiar", e);
        }
    }

    @Override
    public List<VehiculoFamiliar> buscarPorMarca(String marca) {
        List<VehiculoFamiliar> lista = new ArrayList<>();
        String sql = "SELECT * FROM vehiculo_familiar WHERE marca LIKE ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, "%" + marca + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new VehiculoFamiliar(
                        rs.getInt("idVehiculo"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getDouble("precio"),
                        rs.getDouble("kilometraje"),
                        rs.getString("estado"),
                        rs.getString("disponibilidad"),
                        rs.getInt("capacidadPasajeros"),
                        rs.getString("sistemaSeguridad"),
                        rs.getString("confort")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar vehículos familiares por marca", e);
        }
        return lista;
    }
}