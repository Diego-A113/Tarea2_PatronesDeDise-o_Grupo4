package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.Guarderia;
import com.example.IServicio;
import com.example.Patron_Decorator.DecoradorMasaje;

public class DecoradorMasajeTest {

    private IServicio servicioBase;

    @BeforeEach
    void setUp() {
        servicioBase = new Guarderia(15.0);
    }

    @Test
    @DisplayName("Debe sumar su costo extra al precio del servicio envuelto")
    void sumaCostoExtra() {
        IServicio servicioDecorado = new DecoradorMasaje(servicioBase, 10.0);
        assertEquals(25.0, servicioDecorado.calcularPrecio());
    }

    @Test
    @DisplayName("Debe agregar su descripción a la del servicio envuelto")
    void agregaDescripcion() {
        IServicio servicioDecorado = new DecoradorMasaje(servicioBase, 10.0);
        assertEquals("Guarderia de mascota + Masaje", servicioDecorado.obtenerDescripcion());
    }
}