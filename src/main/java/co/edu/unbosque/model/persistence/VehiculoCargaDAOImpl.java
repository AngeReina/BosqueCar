package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.entities.VehiculoCarga;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoCargaDAOImpl implements VehiculoDAO<VehiculoCarga> {

    private Connection conexion;

    public VehiculoCargaDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(VehiculoCarga vehiculo) {
        String sql = "INSERT INTO vehiculo_carga (marca, modelo, anio, precio, kilometraje, estado, disponibilidad, capacidadCarga, tipoCombustible, traccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getModelo());
            stmt.setInt(3, vehiculo.getAnio());
            stmt.setDouble(4, vehiculo.getPrecio());
            stmt.setDouble(5, vehiculo.getKilometraje());
            stmt.setString(6, vehiculo.getEstado());
            stmt.setString(7, vehiculo.getDisponibilidad());
            stmt.setDouble(8, vehiculo.getCapacidadCarga());
            stmt.setString(9, vehiculo.getTipoCombustible());
            stmt.setString(10, vehiculo.getTraccion());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar vehículo de carga", e);
        }
    }

    @Override
    public VehiculoCarga obtenerID(Integer id) {
        String sql = "SELECT * FROM vehiculo_carga WHERE idVehiculo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new VehiculoCarga(
                        rs.getInt("idVehiculo"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getDouble("precio"),
                        rs.getDouble("kilometraje"),
                        rs.getString("estado"),
                        rs.getString("disponibilidad"),
                        rs.getDouble("capacidadCarga"),
                        rs.getString("tipoCombustible"),
                        rs.getString("traccion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<VehiculoCarga> listar() {
        List<VehiculoCarga> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM vehiculo_carga";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                vehiculos.add(new VehiculoCarga(
                        rs.getInt("idVehiculo"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getDouble("precio"),
                        rs.getDouble("kilometraje"),
                        rs.getString("estado"),
                        rs.getString("disponibilidad"),
                        rs.getDouble("capacidadCarga"),
                        rs.getString("tipoCombustible"),
                        rs.getString("traccion")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }

    @Override
    public void actualizar(VehiculoCarga vehiculo) {
        String sql = "UPDATE vehiculo_carga SET marca=?, modelo=?, anio=?, precio=?, kilometraje=?, estado=?, disponibilidad=?, capacidadCarga=?, tipoCombustible=?, traccion=? WHERE idVehiculo=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getModelo());
            stmt.setInt(3, vehiculo.getAnio());
            stmt.setDouble(4, vehiculo.getPrecio());
            stmt.setDouble(5, vehiculo.getKilometraje());
            stmt.setString(6, vehiculo.getEstado());
            stmt.setString(7, vehiculo.getDisponibilidad());
            stmt.setDouble(8, vehiculo.getCapacidadCarga());
            stmt.setString(9, vehiculo.getTipoCombustible());
            stmt.setString(10, vehiculo.getTraccion());
            stmt.setInt(11, vehiculo.getIdVehiculo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Integer id) {
        String sql = "DELETE FROM vehiculo_carga WHERE idVehiculo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<VehiculoCarga> buscarPorMarca(String marca) {
        List<VehiculoCarga> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM vehiculo_carga WHERE marca = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, marca);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                vehiculos.add(new VehiculoCarga(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getDouble("precio"),
                        rs.getDouble("kilometraje"),
                        rs.getString("estado"),
                        rs.getString("disponibilidad"),
                        rs.getDouble("capacidadCarga"),
                        rs.getString("tipoCombustible"),
                        rs.getString("traccion")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar vehículos de carga por marca", e);
        }
        return vehiculos;
    }
}