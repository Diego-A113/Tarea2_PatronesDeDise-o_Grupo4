package com.example;

import java.util.List;

public class Usuario {

    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private List<Reserva> reservas;
    private List<Mascota> mascotas;

    public void registrarMascota(Mascota mascota) {
        if (mascota == null) {
            return;
        }

        if (!this.mascotas.contains(mascota)) {
            this.mascotas.add(mascota);
            System.out.println("Mascota '" + mascota.getNombre() + "' registrada con éxito para el usuario " + this.nombre);
        } else {
            System.out.println("La mascota ya se encuentra registrada.");
        }
    }

    public void crearReserva(Reserva reserva) {
        if (reserva == null) {
            return;
        }

        if (!this.reservas.contains(reserva)) {
            this.reservas.add(reserva);
            System.out.println("Reserva ID: " + reserva.getId() + " añadida al historial del usuario.");
        }
    }

    public void cancelarReserva(Reserva reserva) {
        if (reserva == null) {
            return;
        }

        if (this.reservas.contains(reserva)) {
            reserva.cancelar();
            System.out.println("La reserva ha sido cancelada desde la cuenta del usuario.");
        } else {
            System.out.println("Error: Esta reserva no pertenece a este usuario.");
        }
    }

    public void reportarIncidente(String descripcionIncidente) {
        if (descripcionIncidente == null || descripcionIncidente.trim().isEmpty()) {
            System.out.println("El reporte no puede estar vacío.");
            return;
        }

        System.out.println("Incidente reportado por " + this.nombre + ": " + descripcionIncidente);
    }

    public List<Reserva> consultarReservas() {
        return this.reservas;
    }

    public List<Mascota> getMascotas() {
        return this.mascotas;
    }

    public String getNombre() {
        return nombre;
    }
}
