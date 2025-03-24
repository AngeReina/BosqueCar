package co.edu.unbosque.model;

public class AdministradorDTO {
    private int idAdmin;
    private String nombre;
    private String email;

    public AdministradorDTO() {}

    public AdministradorDTO(int idAdmin, String nombre, String email) {
        this.idAdmin = idAdmin;
        this.nombre = nombre;
        this.email = email;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}