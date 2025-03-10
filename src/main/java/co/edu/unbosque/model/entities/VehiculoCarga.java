package co.edu.unbosque.model.entities;

public class VehiculoCarga extends Vehiculo{

    private double capacidadCarga;
    private String tipoCombustible;
    private String traccion;

    public VehiculoCarga(int idVehiculo, String marca, String modelo, int anio, double precio, double kilometraje, String estado, String disponibilidad, double capacidadCarga, String tipoCombustible, String traccions) {
        super(idVehiculo, marca, modelo, anio, precio, kilometraje, estado, disponibilidad);
        this.capacidadCarga = capacidadCarga;
        this.tipoCombustible = tipoCombustible;
        this.traccion = traccions;

    }
    public double getCapacidadCarga() {
        return capacidadCarga;
    }
    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    public String getTipoCombustible() {
        return tipoCombustible;
    }
    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
    public String getTraccion() {
        return traccion;
    }
    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Vehículo de carga: " + getMarca() + " " + getModelo() + " - " + getAnio());
        System.out.println("Capacidad de carga: " + capacidadCarga + " toneladas, Combustible: " + tipoCombustible + ", Tracción: " + traccion);
    }
}
