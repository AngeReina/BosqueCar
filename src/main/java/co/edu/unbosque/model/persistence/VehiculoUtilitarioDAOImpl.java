package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.entities.VehiculoUtilitario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoUtilitarioDAOImpl implements VehiculoDAO<VehiculoUtilitario> {

    private final Connection conexion;

    public VehiculoUtilitarioDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(VehiculoUtilitario vehiculo) {
        String sql = "INSERT INTO vehiculo_utilitario (marca, modelo, anio, precio, kilometraje, estado, disponibilidad, tamanoMaletero, equipamientoEspecial) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getModelo());
            stmt.setInt(3, vehiculo.getAnio());
            stmt.setDouble(4, vehiculo.getPrecio());
            stmt.setDouble(5, vehiculo.getKilometraje());
            stmt.setString(6, vehiculo.getEstado());
            stmt.setString(7, vehiculo.getDisponibilidad());
            stmt.setDouble(8, vehiculo.getTamanoMaletero());
            stmt.setString(9, vehiculo.getEquipamientoEspecial());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar vehículo utilitario", e);
        }
    }

    @Override
    public VehiculoUtilitario obtenerID(Integer id) {
        String sql = "SELECT * FROM vehiculo_utilitario WHERE idVehiculo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new VehiculoUtilitario(
                        rs.getInt("idVehiculo"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getDouble("precio"),
                        rs.getDouble("kilometraje"),
                        rs.getString("estado"),
                        rs.getString("disponibilidad"),
                        rs.getDouble("tamanoMaletero"),
                        rs.getString("equipamientoEspecial")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener vehículo utilitario por ID", e);
        }
        return null;
    }

    @Override
    public List<VehiculoUtilitario> listar() {
        List<VehiculoUtilitario> lista = new ArrayList<>();
        String sql = "SELECT * FROM vehiculo_utilitario";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new VehiculoUtilitario(
                        rs.getInt("idVehiculo"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getDouble("precio"),
                        rs.getDouble("kilometraje"),
                        rs.getString("estado"),
                        rs.getString("disponibilidad"),
                        rs.getDouble("tamanoMaletero"),
                        rs.getString("equipamientoEspecial")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar vehículos utilitarios", e);
        }
        return lista;
    }

    @Override
    public void actualizar(VehiculoUtilitario vehiculo) {
        String sql = "UPDATE vehiculo_utilitario SET marca=?, modelo=?, anio=?, precio=?, kilometraje=?, estado=?, disponibilidad=?, tamanoMaletero=?, equipamientoEspecial=? WHERE idVehiculo=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getModelo());
            stmt.setInt(3, vehiculo.getAnio());
            stmt.setDouble(4, vehiculo.getPrecio());
            stmt.setDouble(5, vehiculo.getKilometraje());
            stmt.setString(6, vehiculo.getEstado());
            stmt.setString(7, vehiculo.getDisponibilidad());
            stmt.setDouble(8, vehiculo.getTamanoMaletero());
            stmt.setString(9, vehiculo.getEquipamientoEspecial());
            stmt.setInt(10, vehiculo.getIdVehiculo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar vehículo utilitario", e);
        }
    }

    @Override
    public void eliminar(Integer id) {
        String sql = "DELETE FROM vehiculo_utilitario WHERE idVehiculo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar vehículo utilitario", e);
        }
    }

    @Override
    public List<VehiculoUtilitario> buscarPorMarca(String marca) {
        List<VehiculoUtilitario> lista = new ArrayList<>();
        String sql = "SELECT * FROM vehiculo_utilitario WHERE marca LIKE ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, "%" + marca + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new VehiculoUtilitario(
                        rs.getInt("idVehiculo"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getDouble("precio"),
                        rs.getDouble("kilometraje"),
                        rs.getString("estado"),
                        rs.getString("disponibilidad"),
                        rs.getDouble("tamanoMaletero"),
                        rs.getString("equipamientoEspecial")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar vehículos utilitarios por marca", e);
        }
        return lista;
    }
}