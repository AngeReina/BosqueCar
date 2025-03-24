package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.AdministradorDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAOImpl implements AdministradorDAO {

    private Connection conexion;

    public AdministradorDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(AdministradorDTO administrador) {
        String sql = "INSERT INTO administrador (nombre, email) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, administrador.getNombre());
            stmt.setString(2, administrador.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AdministradorDTO obtenerID(Integer id) {
        String sql = "SELECT * FROM administrador WHERE id_admin = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new AdministradorDTO(
                        rs.getInt("id_admin"),
                        rs.getString("nombre"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<AdministradorDTO> listar() {
        List<AdministradorDTO> administradores = new ArrayList<>();
        String sql = "SELECT * FROM administrador";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                administradores.add(new AdministradorDTO(
                        rs.getInt("id_admin"),
                        rs.getString("nombre"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return administradores;
    }

    @Override
    public void actualizar(AdministradorDTO administrador) {
        String sql = "UPDATE administrador SET nombre=?, email=? WHERE id_admin=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, administrador.getNombre());
            stmt.setString(2, administrador.getEmail());
            stmt.setInt(3, administrador.getIdAdmin());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Integer id) {
        String sql = "DELETE FROM administrador WHERE id_admin = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public AdministradorDTO obtenerPorEmail(String email) {
        String sql = "SELECT * FROM administrador WHERE email = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new AdministradorDTO(
                        rs.getInt("id_admin"),
                        rs.getString("nombre"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
