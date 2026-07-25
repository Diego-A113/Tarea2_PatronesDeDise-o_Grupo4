package com.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.reservabuilder.EstadoReserva;

public class Paseo implements IServicio {

    private double precioBase;
    private String nombre = "Paseo";

    private Map<LocalDate, EstadoReserva> historialEstados = new HashMap<>();

    public Paseo(double precioBase) {
        this.precioBase = precioBase;
    }

    @Override
    public void cambiarEstadoPorFecha(LocalDate fecha, EstadoReserva nuevoEstado) {
        if (fecha != null && nuevoEstado != null) {
            this.historialEstados.put(fecha, nuevoEstado);
        }
    }

    @Override
    public boolean verificarDisponibilidad(LocalDate fecha) {
        if (fecha == null) return false;

        EstadoReserva estado = this.historialEstados.get(fecha);

        // Está disponible si nunca se ha agendado en esa fecha (null) 
        // o si una reserva previa en ese día fue cancelada (cupo liberado)
        return estado == null || estado == EstadoReserva.CANCELADO;
    }

    @Override
    public double calcularPrecio() {
        return precioBase;
    }

    @Override
    public String obtenerDescripcion() {
        return "Paseo para mascota";
    }

    @Override
    public String getNombre() {
        return nombre;
    }

}
