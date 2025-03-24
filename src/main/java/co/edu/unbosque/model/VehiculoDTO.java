package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.Vehiculo.Estado;
import co.edu.unbosque.model.entities.Vehiculo.Disponibilidad;

public class VehiculoDTO {
    private int idVehiculo;
    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private double precio;
    private int kilometraje;
    private Estado estado;
    private Disponibilidad disponibilidad;
    private int idCategoria;
    private Double capacidadCarga;
    private String tipoCombustible;
    private String traccion;
    private Integer capacidadPasajeros;
    private String sistemaSeguridad;
    private String confort;
    private Double tamanoMaletero;
    private String equipamientoEspecial;

    // Constructor
    public VehiculoDTO(int idVehiculo, String placa, String marca, String modelo, int anio, double precio, int kilometraje, Estado estado, Disponibilidad disponibilidad, int idCategoria, Double capacidadCarga, String tipoCombustible, String traccion, Integer capacidadPasajeros, String sistemaSeguridad, String confort, Double tamanoMaletero, String equipamientoEspecial) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.estado = estado;
        this.disponibilidad = disponibilidad;
        this.idCategoria = idCategoria;
        this.capacidadCarga = capacidadCarga;
        this.tipoCombustible = tipoCombustible;
        this.traccion = traccion;
        this.capacidadPasajeros = capacidadPasajeros;
        this.sistemaSeguridad = sistemaSeguridad;
        this.confort = confort;
        this.tamanoMaletero = tamanoMaletero;
        this.equipamientoEspecial = equipamientoEspecial;
    }

    // Getters y setters
    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(Double capacidadCarga) {
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

    public Integer getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(Integer capacidadPasajeros) {
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

    public Double getTamanoMaletero() {
        return tamanoMaletero;
    }

    public void setTamanoMaletero(Double tamanoMaletero) {
        this.tamanoMaletero = tamanoMaletero;
    }

    public String getEquipamientoEspecial() {
        return equipamientoEspecial;
    }

    public void setEquipamientoEspecial(String equipamientoEspecial) {
        this.equipamientoEspecial = equipamientoEspecial;
    }
}