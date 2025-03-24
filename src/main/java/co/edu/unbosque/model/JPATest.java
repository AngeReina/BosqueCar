package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class JPATest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BosqueCarPUTest");
        EntityManager em = emf.createEntityManager();

        try {
            mostrarDatos(em);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    private static void mostrarDatos(EntityManager em) {
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        System.out.println("Clientes:");
        for (Cliente c : clientes) {
            System.out.println(c.getCedula() + ": " + c.getNombre() + " " + c.getApellido() + " - " + c.getCorreo());
        }

        List<Vehiculo> vehiculos = em.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class).getResultList();
        System.out.println("Vehículos:");
        for (Vehiculo v : vehiculos) {
            System.out.println(v.getIdVehiculo() + ": " + v.getMarca() + " " + v.getModelo() + " - " + v.getEstado() + " - " + v.getDisponibilidad() + " - " + v.getAnio() + " - " + v.getPrecio() + " - " + v.getKilometraje() + " - " + v.getCapacidadCarga() + " - " + v.getTipoCombustible() + " - " + v.getTraccion() + " - " + v.getCapacidadPasajeros() + " - " + v.getSistemaSeguridad() + " - " + v.getConfort() + " - " + v.getTamanoMaletero() + " - " + v.getEquipamientoEspecial());
        }

        List<Cotizacion> cotizaciones = em.createQuery("SELECT co FROM Cotizacion co", Cotizacion.class).getResultList();
        System.out.println("Cotizaciones:");
        for (Cotizacion co : cotizaciones) {
            System.out.println(co.getIdCotizacion() + ": " + co.getCliente().getNombre() + " " + co.getCliente().getApellido() + " - " + co.getVehiculo().getMarca() + " " + co.getVehiculo().getModelo() + " - " + co.getFecha() + " - " + co.getEstado());
        }

        List<Cita> citas = em.createQuery("SELECT ci FROM Cita ci", Cita.class).getResultList();
        System.out.println("Citas:");
        for (Cita ci : citas) {
            System.out.println(ci.getIdCita() + ": " + ci.getCliente().getNombre() + " " + ci.getCliente().getApellido() + " - " + ci.getVehiculo().getMarca() + " " + ci.getVehiculo().getModelo() + " - " + ci.getFecha() + " - " + ci.getMotivo() + " - " + ci.getEstado());
        }

        List<Administrador> administradores = em.createQuery("SELECT a FROM Administrador a", Administrador.class).getResultList();
        System.out.println("Administradores:");
        for (Administrador a : administradores) {
            System.out.println(a.getIdAdmin() + ": " + a.getNombre() + " - " + a.getEmail());
        }
    }
}