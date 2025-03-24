package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.entities.Vehiculo;
import co.edu.unbosque.model.entities.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAOImpl implements VehiculoDAO {

    private Connection conexion;

    public VehiculoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(Vehiculo vehiculo) {
        String sql = "INSERT INTO vehiculo (placa, marca, modelo, anio, precio, kilometraje, estado, disponibilidad, id_categoria, capacidad_carga, tipo_combustible, traccion, capacidad_pasajeros, sistema_seguridad, confort, tamano_maletero, equipamiento_especial) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, vehiculo.getPlaca());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setString(3, vehiculo.getModelo());
            stmt.setInt(4, vehiculo.getAnio());
            stmt.setDouble(5, vehiculo.getPrecio());
            stmt.setInt(6, vehiculo.getKilometraje());
            stmt.setString(7, vehiculo.getEstado().name());
            stmt.setString(8, vehiculo.getDisponibilidad().name());
            stmt.setInt(9, vehiculo.getCategoria().getIdCategoria());
            stmt.setObject(10, vehiculo.getCapacidadCarga());
            stmt.setString(11, vehiculo.getTipoCombustible());
            stmt.setString(12, vehiculo.getTraccion());
            stmt.setObject(13, vehiculo.getCapacidadPasajeros());
            stmt.setString(14, vehiculo.getSistemaSeguridad());
            stmt.setString(15, vehiculo.getConfort());
            stmt.setObject(16, vehiculo.getTamanoMaletero());
            stmt.setString(17, vehiculo.getEquipamientoEspecial());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar vehículo", e);
        }
    }

    @Override
    public Vehiculo obtenerID(Integer id) {
        String sql = "SELECT * FROM vehiculo WHERE id_vehiculo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Categoria categoria = new Categoria(rs.getInt("id_categoria"), "Desconocida"); // Asigna una categoría por defecto
                return new Vehiculo(
                        rs.getInt("id_vehiculo"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getDouble("precio"),
                        rs.getInt("kilometraje"),
                        Vehiculo.Estado.valueOf(rs.getString("estado")),
                        Vehiculo.Disponibilidad.valueOf(rs.getString("disponibilidad")),
                        categoria,
                        rs.getDouble("capacidad_carga"),
                        rs.getString("tipo_combustible"),
                        rs.getString("traccion"),
                        rs.getInt("capacidad_pasajeros"),
                        rs.getString("sistema_seguridad"),
                        rs.getString("confort"),
                        rs.getDouble("tamano_maletero"),
                        rs.getString("equipamiento_especial")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vehiculo> listar() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM vehiculo";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Categoria categoria = new Categoria(rs.getInt("id_categoria"), "Desconocida"); // Asigna una categoría por defecto
                vehiculos.add(new Vehiculo(
                        rs.getInt("id_vehiculo"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getDouble("precio"),
                        rs.getInt("kilometraje"),
                        Vehiculo.Estado.valueOf(rs.getString("estado")),
                        Vehiculo.Disponibilidad.valueOf(rs.getString("disponibilidad")),
                        categoria,
                        rs.getDouble("capacidad_carga"),
                        rs.getString("tipo_combustible"),
                        rs.getString("traccion"),
                        rs.getInt("capacidad_pasajeros"),
                        rs.getString("sistema_seguridad"),
                        rs.getString("confort"),
                        rs.getDouble("tamano_maletero"),
                        rs.getString("equipamiento_especial")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }

    @Override
    public void actualizar(Vehiculo vehiculo) {
        String sql = "UPDATE vehiculo SET placa = ?, marca = ?, modelo = ?, anio = ?, precio = ?, kilometraje = ?, estado = ?, disponibilidad = ?, id_categoria = ?, capacidad_carga = ?, tipo_combustible = ?, traccion = ?, capacidad_pasajeros = ?, sistema_seguridad = ?, confort = ?, tamano_maletero = ?, equipamiento_especial = ? WHERE id_vehiculo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, vehiculo.getPlaca());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setString(3, vehiculo.getModelo());
            stmt.setInt(4, vehiculo.getAnio());
            stmt.setDouble(5, vehiculo.getPrecio());
            stmt.setInt(6, vehiculo.getKilometraje());
            stmt.setString(7, vehiculo.getEstado().name());
            stmt.setString(8, vehiculo.getDisponibilidad().name());
            stmt.setInt(9, vehiculo.getCategoria().getIdCategoria());
            stmt.setObject(10, vehiculo.getCapacidadCarga());
            stmt.setString(11, vehiculo.getTipoCombustible());
            stmt.setString(12, vehiculo.getTraccion());
            stmt.setObject(13, vehiculo.getCapacidadPasajeros());
            stmt.setString(14, vehiculo.getSistemaSeguridad());
            stmt.setString(15, vehiculo.getConfort());
            stmt.setObject(16, vehiculo.getTamanoMaletero());
            stmt.setString(17, vehiculo.getEquipamientoEspecial());
            stmt.setInt(18, vehiculo.getIdVehiculo());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar vehículo", e);
        }
    }

    @Override
    public void eliminar(Integer id) {
        String sql = "DELETE FROM vehiculo WHERE id_vehiculo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar vehículo", e);
        }
    }

    @Override
    public List<Vehiculo> buscarPorMarca(String marca) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM vehiculo WHERE marca = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, marca);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria(rs.getInt("id_categoria"), "Desconocida"); // Asigna una categoría por defecto
                vehiculos.add(new Vehiculo(
                        rs.getInt("id_vehiculo"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getDouble("precio"),
                        rs.getInt("kilometraje"),
                        Vehiculo.Estado.valueOf(rs.getString("estado")),
                        Vehiculo.Disponibilidad.valueOf(rs.getString("disponibilidad")),
                        categoria,
                        rs.getDouble("capacidad_carga"),
                        rs.getString("tipo_combustible"),
                        rs.getString("traccion"),
                        rs.getInt("capacidad_pasajeros"),
                        rs.getString("sistema_seguridad"),
                        rs.getString("confort"),
                        rs.getDouble("tamano_maletero"),
                        rs.getString("equipamiento_especial")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }
}
