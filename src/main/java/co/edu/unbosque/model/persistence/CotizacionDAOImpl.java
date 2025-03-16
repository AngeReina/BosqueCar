package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.CotizacionDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CotizacionDAOImpl implements CotizacionDAO {

    private Connection conexion;

    public CotizacionDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(CotizacionDTO cotizacion) {
        String sql ="INSERT INTO cotizacion (idCliente, idVehiculo, fecha, estadp) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, cotizacion.getIdCliente());
            stmt.setInt(2, cotizacion.getIdVehiculo());
            stmt.setDate(3, Date.valueOf(cotizacion.getFecha()));
            stmt.setString(4, cotizacion.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CotizacionDTO obtenerID(Integer id) {
        String sql ="SELECT * FROM cotizacion WHERE idCotizacion = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new CotizacionDTO(
                        rs.getInt("idCotizacion"),
                        rs.getInt("idCliente"),
                        rs.getInt("idVehiculo"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<CotizacionDTO> listar() {
        List<CotizacionDTO> cotizaciones = new ArrayList<>();
        String sql ="SELECT * FROM cotizacion";
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cotizaciones.add(new CotizacionDTO(
                        rs.getInt("idCotizacion"),
                        rs.getInt("idCliente"),
                        rs.getInt("idVehiculo"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;
        return cotizaciones;
    }

    @Override
    public void actualizar(CotizacionDTO cotizacion) {
        String sql = "UPDATE cotizacion SET idCliente =?, idVehiculo =?, fecha =?, estado =? WHERE idCotizacion =?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cotizacion.getIdCliente());
            stmt.setInt(2, cotizacion.getIdVehiculo());
            stmt.setDate(3, Date.valueOf(cotizacion.getFecha()));
            stmt.setString(4, cotizacion.getEstado());
            stmt.setInt(5, cotizacion.getIdCotizacion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void eliminar(Integer id) {
        String sql = "DELETE FROM cotizacion WHERE idCotizacion = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CotizacionDTO> obtenerPorEstado(String estado) {
        List<CotizacionDTO> cotizaciones = new ArrayList<>();
        String sql ="SELECT * FROM cotizacion WHERE estado = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setString(1, estado);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cotizaciones.add(new CotizacionDTO(
                        rs.getInt("idCotizacion"),
                        rs.getInt("idCliente"),
                        rs.getInt("idVehiculo"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cotizaciones;
    }
}
