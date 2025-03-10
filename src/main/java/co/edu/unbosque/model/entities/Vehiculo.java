package co.edu.unbosque.model.entities;

public abstract class Vehiculo {
    protected int idVehiculo;
    protected String marca;
    protected String modelo;
    protected int anio;
    protected double precio;
    protected double kilometraje;
    protected String estado;
    protected String disponibilidad;

    public Vehiculo(int idVehiculo, String marca, String modelo, int anio, double precio, double kilometraje, String estado, String disponibilidad) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.estado = estado;
        this.disponibilidad = disponibilidad;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
    public int getIdVehiculo() {
        return idVehiculo;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getMarca() {
        return marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getModelo() {
        return modelo;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public int getAnio() {
        return anio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getPrecio() {
        return precio;
    }
    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }
    public double getKilometraje() {
        return kilometraje;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getEstado() {
        return estado;
    }
    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public String getDisponibilidad() {
        return disponibilidad;
    }
    public abstract void mostrarDetalles();
}
