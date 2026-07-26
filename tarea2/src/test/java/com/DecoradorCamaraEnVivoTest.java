package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.Guarderia;
import com.example.IServicio;
import com.example.Patron_Decorator.DecoradorBano;
import com.example.Patron_Decorator.DecoradorCamaraEnVivo;
import com.example.Patron_Decorator.DecoradorPeluqueria;

public class DecoradorCamaraEnVivoTest {

    private IServicio servicioBase;

    @BeforeEach
    void setUp() {
        servicioBase = new Guarderia(15.0);
    }

    @Test
    @DisplayName("Debe sumar su costo extra al precio del servicio envuelto")
    void sumaCostoExtra() {
        IServicio servicioDecorado = new DecoradorCamaraEnVivo(servicioBase, 3.5);
        assertEquals(18.5, servicioDecorado.calcularPrecio());
    }

    @Test
    @DisplayName("Debe agregar su descripción a la del servicio envuelto")
    void agregaDescripcion() {
        IServicio servicioDecorado = new DecoradorCamaraEnVivo(servicioBase, 3.5);
        assertEquals("Guarderia de mascota + Cámara en vivo", servicioDecorado.obtenerDescripcion());
    }

    @Test
    @DisplayName("Varios decoradores apilados deben sumar todos los costos extra")
    void multiplesDecoradoresApilados() {
        IServicio servicioDecorado = new DecoradorBano(servicioBase, 5.0);
        servicioDecorado = new DecoradorPeluqueria(servicioDecorado, 8.0);
        servicioDecorado = new DecoradorCamaraEnVivo(servicioDecorado, 3.5);

        assertEquals(31.5, servicioDecorado.calcularPrecio());
        assertEquals(
            "Guarderia de mascota + Baño + Peluquería + Cámara en vivo",
            servicioDecorado.obtenerDescripcion()
        );
    }
}