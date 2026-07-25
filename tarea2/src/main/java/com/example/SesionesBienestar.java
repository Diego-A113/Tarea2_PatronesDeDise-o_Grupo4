package com.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.reservabuilder.EstadoReserva;

public class SesionesBienestar implements IServicio {

    private double precioBase;
    private String nombre = "Sesiones de Bienestar";

    private Map<LocalDate, EstadoReserva> historialEstados = new HashMap<>();

    public SesionesBienestar(double precioBase) {
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

        return estado == null || estado == EstadoReserva.CANCELADO;
    }

    @Override
    public double calcularPrecio() {
        return precioBase;
    }

    @Override
    public String obtenerDescripcion() {
        return "Sesiones de bienestar para mascota";
    }

    @Override
    public String getNombre() {
        return nombre;
    }

}
