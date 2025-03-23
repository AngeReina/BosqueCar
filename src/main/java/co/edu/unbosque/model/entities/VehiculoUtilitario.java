package co.edu.unbosque.model.entities;

public class VehiculoUtilitario extends Vehiculo {

    private double tamanoMaletero;
    private String equipamientoEspecial;

    public VehiculoUtilitario(int idVehiculo, String marca, String modelo, int anio, double precio, double kilometraje, String estado, String disponibilidad, double tamanoMaletero, String equipamientoEspecial) {
        super(idVehiculo, marca, modelo, anio, precio, kilometraje, estado, disponibilidad);
        this.tamanoMaletero = tamanoMaletero;
        this.equipamientoEspecial = equipamientoEspecial;
    }
    public double getTamanoMaletero() {
        return tamanoMaletero;
    }
    public void setTamanoMaletero(double tamanoMaletero) {
        this.tamanoMaletero = tamanoMaletero;
    }
    public String getEquipamientoEspecial() {
        return equipamientoEspecial;
    }
    public void setEquipamientoEspecial(String equipamientoEspecial) {
        this.equipamientoEspecial = equipamientoEspecial;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Vehículo Utilitario: " + marca + " " + modelo + " - " + anio);
        System.out.println("Tamaño de maletero: " + tamanoMaletero + " m³, Equipamiento: " + equipamientoEspecial);
    }
}
