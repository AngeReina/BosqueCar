package co.edu.unbosque.model;

public class VehiculoDTO {
    private int idVehiculo;
    private String marca;
    private String modelo;
    private int anio;
    private double precio;
    private double kilometraje;
    private String estado;
    private String disponibilidad;

    public int getIdVehiculo() {
        return idVehiculo;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public int getAnio() {
        return anio;
    }
    public double getPrecio() {
        return precio;
    }
    public double getKilometraje() {
        return kilometraje;
    }
    public String getEstado() {
        return estado;
    }
    public String getDisponibilidad() {
        return disponibilidad;
    }
}
