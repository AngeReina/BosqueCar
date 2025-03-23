package co.edu.unbosque.model;

public class VehiculoFamiliarDTO  extends  VehiculoDTO {

    private int capacidadPasajeros;
    private String sistemaSeguridad;
    private String confort;

    public VehiculoFamiliarDTO(int idVehiculo, String marca, String modelo, int anio, double precio, double kilometraje, String estado, String disponibilidad) {
        super(idVehiculo, marca, modelo, anio, precio, kilometraje, estado, disponibilidad);
    }
    public int getCapacidadPasajeros() { return capacidadPasajeros; }
    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }
    public String getSistemaSeguridad() {
        return sistemaSeguridad;
    }
    public void setSistemaSeguridad(String sistemaSeguridad) {
        this.sistemaSeguridad = sistemaSeguridad;
    }
    public String getConfort() {
        return confort;
    }
    public void setConfort(String confort) {
        this.confort = confort;
    }
}
