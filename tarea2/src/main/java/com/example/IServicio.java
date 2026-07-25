package com.example;

import java.time.LocalDate;

import com.reservabuilder.EstadoReserva;

public interface IServicio {

    public void cambiarEstadoPorFecha(LocalDate fecha, EstadoReserva nuevoEstado);

    public double calcularPrecio();

    public boolean verificarDisponibilidad(LocalDate fecha);

    public String obtenerDescripcion();

    public String getNombre();
}
