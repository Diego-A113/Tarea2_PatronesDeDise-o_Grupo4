package com.example.observer;

import com.example.reservabuilder.Reserva;

public interface IObserverReserva {
    public void actualizar(Reserva reserva, String evento);
}
