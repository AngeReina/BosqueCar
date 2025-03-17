package co.edu.unbosque.model;

public class VehiculoUtilitarioDTO extends VehiculoDTO {

    private double tamanoMaletero;
    private String equipamientoEspecial;

    public VehiculoUtilitarioDTO(int idVehiculo, String marca, String modelo, int anio, double precio, double kilometraje, String estado, String disponibilidad) {
        super(idVehiculo, marca, modelo, anio, precio, kilometraje, estado, disponibilidad);
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
}
