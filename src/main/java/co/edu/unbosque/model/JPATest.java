package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class JPATest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BosqueCarPUTest");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, 1000001);
            if (cliente != null) {
                System.out.println("Cliente leído: " + cliente.getNombre() + " " + cliente.getApellido());
            } else {
                System.out.println("Cliente no encontrado.");
                // Crear un cliente si no existe
                cliente = new Cliente(1000001, "Juan", "Pérez", "juan.perez@example.com");
                em.persist(cliente);
                System.out.println("Cliente creado: " + cliente.getNombre() + " " + cliente.getApellido());
            }

            Vehiculo vehiculo = em.find(Vehiculo.class, 1);
            if (vehiculo != null) {
                System.out.println("Vehículo leído: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
            } else {
                System.out.println("Vehículo no encontrado.");
                // Crear un vehículo si no existe
                Categoria categoria = em.find(Categoria.class, 1);
                vehiculo = new Vehiculo(0, "ABC123", "Toyota", "Hilux", 2022, 85000.00, 15000, Vehiculo.Estado.NUEVO, Vehiculo.Disponibilidad.DISPONIBLE, categoria, 1.5, "Diesel", "4x4", null, null, null, null, null);
                em.persist(vehiculo);
                System.out.println("Vehículo creado: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
            }

            Cotizacion cotizacion = new Cotizacion();
            cotizacion.setCliente(cliente);
            cotizacion.setVehiculo(vehiculo);
            cotizacion.setFecha(LocalDate.now());
            cotizacion.setEstado("Pendiente");

            em.persist(cotizacion);

            Cotizacion cotizacionLeida = em.find(Cotizacion.class, cotizacion.getIdCotizacion());
            if (cotizacionLeida != null) {
                System.out.println("Cotización leída: " + cotizacionLeida.getEstado());
            } else {
                System.out.println("Cotización no encontrada.");
            }

            cotizacionLeida.setEstado("Aprobada");
            em.merge(cotizacionLeida);

            em.remove(cotizacionLeida);

            em.getTransaction().commit();

            mostrarDatos(em);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
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
            System.out.println(co.getIdCotizacion() + ": " + co.getCliente().getNombre() + " - " + co.getVehiculo().getMarca() + " - " + co.getEstado());
        }

        List<Cita> citas = em.createQuery("SELECT ci FROM Cita ci", Cita.class).getResultList();
        System.out.println("Citas:");
        for (Cita ci : citas) {
            System.out.println(ci.getIdCita() + ": " + ci.getCliente().getNombre() + " - " + ci.getVehiculo().getMarca() + " - " + ci.getMotivo() + " - " + ci.getEstado());
        }

        List<Administrador> administradores = em.createQuery("SELECT a FROM Administrador a", Administrador.class).getResultList();
        System.out.println("Administradores:");
        for (Administrador a : administradores) {
            System.out.println(a.getIdAdmin() + ": " + a.getNombre() + " - " + a.getEmail());
        }
    }
}