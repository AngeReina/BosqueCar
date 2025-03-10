package co.edu.unbosque.model.entities;

public class VehiculoFamiliar extends Vehiculo{

    private int capacidadPasajeros;
    private String sistemaSeguridad;
    private String confort;

    public VehiculoFamiliar(int idVehiculo, String marca, String modelo, int anio, double precio, double kilometraje, String estado, String disponibilidad, int capacidadPasajeros, String sistemaSeguridad, String confort) {
        super(idVehiculo, marca, modelo, anio, precio, kilometraje, estado, disponibilidad);
        this.capacidadPasajeros = capacidadPasajeros;
        this.sistemaSeguridad = sistemaSeguridad;
        this.confort = confort;
    }
    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }
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

    @Override
    public void mostrarDetalles() {
        System.out.println("Vehículo Familiar: " + marca + " " + modelo + " - " + anio);
        System.out.println("Capacidad: " + capacidadPasajeros + " pasajeros, Seguridad: " + sistemaSeguridad + ", Confort: " + confort);
    }
}
