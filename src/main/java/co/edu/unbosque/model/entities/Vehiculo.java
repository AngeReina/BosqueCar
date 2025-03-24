package co.edu.unbosque.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private int idVehiculo;

    @Column(name = "placa")
    private String placa;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "anio", nullable = false)
    private int anio;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "kilometraje")
    private int kilometraje;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    @Column(name = "disponibilidad", nullable = false)
    private Disponibilidad disponibilidad;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    // Campos adicionales específicos para cada tipo de vehículo
    @Column(name = "capacidad_carga")
    private Double capacidadCarga;

    @Column(name = "tipo_combustible")
    private String tipoCombustible;

    @Column(name = "traccion")
    private String traccion;

    @Column(name = "capacidad_pasajeros")
    private Integer capacidadPasajeros;

    @Column(name = "sistema_seguridad")
    private String sistemaSeguridad;

    @Column(name = "confort")
    private String confort;

    @Column(name = "tamano_maletero")
    private Double tamanoMaletero;

    @Column(name = "equipamiento_especial")
    private String equipamientoEspecial;

    public Vehiculo() {}

    // Constructor general
    public Vehiculo(int idVehiculo, String placa, String marca, String modelo, int anio, double precio, int kilometraje, Estado estado, Disponibilidad disponibilidad, Categoria categoria, Double capacidadCarga, String tipoCombustible, String traccion, Integer capacidadPasajeros, String sistemaSeguridad, String confort, Double tamanoMaletero, String equipamientoEspecial) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.estado = estado;
        this.disponibilidad = disponibilidad;
        this.categoria = categoria;
        this.capacidadCarga = capacidadCarga;
        this.tipoCombustible = tipoCombustible;
        this.traccion = traccion;
        this.capacidadPasajeros = capacidadPasajeros;
        this.sistemaSeguridad = sistemaSeguridad;
        this.confort = confort;
        this.tamanoMaletero = tamanoMaletero;
        this.equipamientoEspecial = equipamientoEspecial;
    }

    // Enum types
    public enum Estado {
        NUEVO, USADO
    }

    public enum Disponibilidad {
        DISPONIBLE, RESERVADO, VENDIDO
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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