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
        String sql = "INSERT INTO cita (idCliente, fecha, motivo, estado) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setInt(1, cita.getCedula());
            stmt.setDate(2, Date.valueOf(cita.getFecha()));
            stmt.setString(3, cita.getMotivo());
            stmt.setString(4, cita.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CitaDTO obtenerID(Integer id) {
        String sql = "SELECT * FROM cita WHERE idCliente = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new CitaDTO(
                        rs.getInt("idCita"),
                        rs.getInt("idCliente"),
                        rs.getDate("fecha").toLocalDate(),
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
             ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                citas.add(new CitaDTO(
                        rs.getInt("idCita"),
                        rs.getInt("idCliente"),
                        rs.getDate("fecha").toLocalDate(),
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
    public void eliminar(Integer cedula) {
        String sql = "DELETE FROM cita WHERE cedula = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cedula);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CitaDTO> obtenerCitaPorCliente(int idCliente) {
        List<CitaDTO> citas = new ArrayList<>();
        String sql = "SELECT * FROM cita WHERE idCliente = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                citas.add(new CitaDTO(
                        rs.getInt("idCita"),
                        rs.getInt("idCliente"),
                        rs.getDate("fecha").toLocalDate(),
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
        String sql = "UPDATE cita SET idCliente=?, fecha=?, motivo=?, estado=? WHERE idCita=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setInt(1, cita.getCedula());
            stmt.setDate(2, Date.valueOf(cita.getFecha()));
            stmt.setString(3, cita.getMotivo());
            stmt.setString(4, cita.getEstado());
            stmt.setInt(5, cita.getIdCita());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
