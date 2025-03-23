package co.edu.unbosque.model;

public class ClienteDTO {

    private String nombre;
    private String apellido;
    private int cedula;
    private String correo;

    public ClienteDTO(String nombre, String apellido,int cedula, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public int getCedula() {
        return cedula;
    }
    public String getCorreo() { return correo; }
}
