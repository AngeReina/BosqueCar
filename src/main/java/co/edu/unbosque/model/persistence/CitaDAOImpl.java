package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.CitaDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAOImpl implements CitaDAO {

    private Connection conexion;

    public CitaDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(CitaDTO cita) {
        String sql = "INSERT INTO cita (cedula, id_vehiculo, fecha, motivo, estado) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, cita.getCedula());
            stmt.setInt(2, cita.getIdVehiculo());
            stmt.setTimestamp(3, Timestamp.valueOf(cita.getFecha()));
            stmt.setString(4, cita.getMotivo());
            stmt.setString(5, cita.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CitaDTO obtenerID(Integer id) {
        String sql = "SELECT * FROM cita WHERE id_cita = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new CitaDTO(
                        rs.getInt("id_cita"),
                        rs.getInt("cedula"),
                        rs.getInt("id_vehiculo"),
                        rs.getTimestamp("fecha").toLocalDateTime(),
                        rs.getString("motivo"),
                        rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<CitaDTO> listar() {
        List<CitaDTO> citas = new ArrayList<>();
        String sql = "SELECT * FROM cita";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                citas.add(new CitaDTO(
                        rs.getInt("id_cita"),
                        rs.getInt("cedula"),
                        rs.getInt("id_vehiculo"),
                        rs.getTimestamp("fecha").toLocalDateTime(),
                        rs.getString("motivo"),
                        rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citas;
    }

    @Override
    public void eliminar(Integer id) {
        String sql = "DELETE FROM cita WHERE id_cita = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CitaDTO> obtenerCitaPorCliente(int cedula) {
        List<CitaDTO> citas = new ArrayList<>();
        String sql = "SELECT * FROM cita WHERE cedula = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cedula);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                citas.add(new CitaDTO(
                        rs.getInt("id_cita"),
                        rs.getInt("cedula"),
                        rs.getInt("id_vehiculo"),
                        rs.getTimestamp("fecha").toLocalDateTime(),
                        rs.getString("motivo"),
                        rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return citas;
    }

    @Override
    public void actualizar(CitaDTO cita) {
        String sql = "UPDATE cita SET cedula=?, id_vehiculo=?, fecha=?, motivo=?, estado=? WHERE id_cita=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cita.getCedula());
            stmt.setInt(2, cita.getIdVehiculo());
            stmt.setTimestamp(3, Timestamp.valueOf(cita.getFecha()));
            stmt.setString(4, cita.getMotivo());
            stmt.setString(5, cita.getEstado());
            stmt.setInt(6, cita.getIdCita());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}