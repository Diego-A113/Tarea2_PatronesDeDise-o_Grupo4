package com.example.observer;

import com.example.reservabuilder.Reserva;

public class NotificacionEmail implements IObserverReserva {
    private String email;

    public NotificacionEmail(String email) {
        this.email = email;
    }

    @Override
    public void actualizar(Reserva reserva, String evento) {
        System.out.println("Enviando correo a " + email + " sobre el evento: " + evento + " para la reserva: " + reserva);
    }

}
