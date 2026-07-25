package com.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Hospedaje implements IServicio {

    private double precioBase;
    private String nombre = "Hospedaje";

    private Map<LocalDate, EstadoReserva> historialEstados = new HashMap<>();

    @Override
    public void cambiarEstadoPorFecha(LocalDate fecha, EstadoReserva nuevoEstado) {
        this.historialEstados.put(fecha, nuevoEstado);
    }

    @Override
    public boolean verificarDisponibilidad(LocalDate fecha) {
        EstadoReserva estado = this.historialEstados.getOrDefault(fecha, EstadoReserva.DISPONIBLE);

        if (estado == EstadoReserva.DISPONIBLE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double calcularPrecio() {
        return precioBase;
    }

    @Override
    public String obtenerDescripcion() {
        return "Hospedaje para mascotas";
    }

    @Override
    public String getNombre() {
        return nombre;
    }

}
