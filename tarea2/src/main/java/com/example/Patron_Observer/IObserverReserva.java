package com.example.Patron_Observer;

import com.example.reservabuilder.Reserva;

public interface IObserverReserva {
    public void actualizar(Reserva reserva, String evento);
}
