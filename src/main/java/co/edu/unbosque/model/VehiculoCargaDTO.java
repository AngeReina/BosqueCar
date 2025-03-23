package co.edu.unbosque.model;

public class VehiculoCargaDTO extends  VehiculoDTO {

    private double capacidadCarga;
    private String tipoCombustible;
    private String traccion;

    public VehiculoCargaDTO(int idVehiculo, String marca, String modelo, int anio, double precio, double kilometraje, String estado, String disponibilidad, double capacidadCarga, String tipoCombustible, String traccion) {
        super(idVehiculo, marca, modelo, anio, precio, kilometraje, estado, disponibilidad);
        this.capacidadCarga = capacidadCarga;
        this.tipoCombustible = tipoCombustible;
        this.traccion = traccion;
    }
    public double getCapacidadCarga() { return capacidadCarga; }
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
}
