package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.TamanoMascota;
import com.example.Patron_Builder_Mascota.Mascota;
import com.example.Patron_Builder_Mascota.MascotaBuilder;

public class MascotaBuilderTest {
    private MascotaBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new MascotaBuilder();
    }

    @AfterEach
    void tearDown() {
        builder = null;
    }

    @Test
    @DisplayName("Debe construir una mascota correctamente")
    void crearMascotaCorrectamente() {

        Mascota mascota = builder
                .setId(1)
                .setNombre("Max")
                .setEspecie("Perro")
                .setRaza("Golden Retriever")
                .setTamano(TamanoMascota.GRANDE)
                .setEdad(3)
                .agregarNecesidadEspecial("Medicamento diario")
                .agregarPreferenciasTrato("No convivir con gatos")
                .build();

        assertNotNull(mascota);
        assertEquals(1, mascota.getId());
        assertEquals("Max", mascota.getNombre());
        assertEquals("Perro", mascota.getEspecie());
        assertEquals("Golden Retriever", mascota.getRaza());
        assertEquals(TamanoMascota.GRANDE, mascota.getTamano());
        assertEquals(3, mascota.getEdad());

        assertEquals(1, mascota.getNecesidadesEspeciales().size());
        assertEquals(1, mascota.getPreferenciasTrato().size());
    }

    @Test
    @DisplayName("No debe permitir edad negativa")
    void noDebePermitirEdadNegativa() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> builder.setEdad(-5));

        assertEquals("La edad de la mascota no puede ser negativa.",exception.getMessage());
    }

    @Test
    @DisplayName("No debe permitir registrar una mascota sin nombre")
    void noDebePermitirMascotaSinNombre() {IllegalStateException exception = assertThrows(IllegalStateException.class,() -> builder.setEspecie("Perro").build());

        assertEquals("No se puede registrar una mascota sin nombre.",exception.getMessage());
    }

    @Test
    @DisplayName("No debe permitir registrar una mascota sin especie")
    void noDebePermitirMascotaSinEspecie() {

        IllegalStateException exception = assertThrows(IllegalStateException.class,() -> builder.setNombre("Max").build());

        assertEquals("Debe especificar la especie de la mascota (ej. Perro, Gato).",exception.getMessage());
    }

    @Test
    @DisplayName("El Builder debe reiniciarse después del build")
    void builderDebeReiniciarse() {

        Mascota mascota1 = builder.setNombre("Max").setEspecie("Perro").build();

        Mascota mascota2 = builder.setNombre("Luna").setEspecie("Gato").build();

        assertNotEquals(mascota1.getNombre(), mascota2.getNombre());
        assertEquals("Luna", mascota2.getNombre());
    }
}
