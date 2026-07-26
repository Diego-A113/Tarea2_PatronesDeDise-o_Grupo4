package com;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.EstadoDisponibilidad;
import com.example.Guarderia;
import com.example.IServicio;
import com.example.Patron_Decorator.DecoradorBano;

public class DecoradorBanoTest {

    private IServicio servicioBase;

    @BeforeEach
    void setUp() {
        servicioBase = new Guarderia(15.0);
    }

    @Test
    @DisplayName("Debe sumar su costo extra al precio del servicio envuelto")
    void sumaCostoExtra() {
        IServicio servicioDecorado = new DecoradorBano(servicioBase, 5.0);
        assertEquals(20.0, servicioDecorado.calcularPrecio());
    }

    @Test
    @DisplayName("Debe agregar su descripción a la del servicio envuelto")
    void agregaDescripcion() {
        IServicio servicioDecorado = new DecoradorBano(servicioBase, 5.0);
        assertEquals("Guarderia de mascota + Baño", servicioDecorado.obtenerDescripcion());
    }

    @Test
    @DisplayName("getNombre() debe delegarse al servicio envuelto sin cambiar por decorar")
    void getNombreSeDelega() {
        IServicio servicioDecorado = new DecoradorBano(servicioBase, 5.0);
        assertEquals("Guarderia", servicioDecorado.getNombre());
    }

    @Test
    @DisplayName("verificarDisponibilidad() debe delegarse al servicio envuelto")
    void verificarDisponibilidadSeDelega() {
        IServicio servicioDecorado = new DecoradorBano(servicioBase, 5.0);
        LocalDate fecha = LocalDate.of(2026, 8, 1);
        assertTrue(servicioDecorado.verificarDisponibilidad(fecha));
    }

    @Test
    @DisplayName("cambiarEstadoPorFecha() a través del decorador debe reflejarse en el servicio base")
    void cambiarEstadoPorFechaSeDelega() {
        IServicio servicioDecorado = new DecoradorBano(servicioBase, 5.0);
        LocalDate fecha = LocalDate.of(2026, 8, 1);
        servicioDecorado.cambiarEstadoPorFecha(fecha, EstadoDisponibilidad.OCUPADO);
        assertFalse(servicioDecorado.verificarDisponibilidad(fecha));
        assertFalse(servicioBase.verificarDisponibilidad(fecha));
    }
}