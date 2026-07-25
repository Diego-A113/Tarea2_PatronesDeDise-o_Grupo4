package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.TamanoMascota;
import com.example.Patron_Builder_Mascota.Mascota;
import com.example.Patron_Builder_Mascota.MascotaBuilder;

/** * Pruebas unitarias para la clase Mascota
 * Verifica que los métodos de la mascota funcionen correctamente.*/ 
public class MascotaTest {
    private Mascota mascota;

    @BeforeEach
    void setUp() {

        mascota = new MascotaBuilder().setId(1).setNombre("Max").setEspecie("Perro").setRaza("Golden Retriever").setTamano(TamanoMascota.GRANDE).setEdad(3).build();
    }

    @Test
    @DisplayName("Debe actualizar el perfil de la mascota")
    void actualizarPerfil() {

        mascota.actualizarPerfil("Rocky",TamanoMascota.MEDIANO,5);

        assertEquals("Rocky", mascota.getNombre());
        assertEquals(TamanoMascota.MEDIANO, mascota.getTamano());
        assertEquals(5, mascota.getEdad());
    }

    @Test
    @DisplayName("Debe agregar una necesidad especial")
    void agregarNecesidadEspecial() {

        mascota.agregarNecesidadEspecial("Dieta especial");

        assertEquals(1, mascota.getNecesidadesEspeciales().size());

        assertTrue(mascota.getNecesidadesEspeciales().contains("Dieta especial"));
    }

    @Test
    @DisplayName("Debe agregar una preferencia de trato")
    void agregarPreferenciaTrato() {

        mascota.agregarPreferenciaTrato("Paseo diario");

        assertEquals(1, mascota.getPreferenciasTrato().size());

        assertTrue(mascota.getPreferenciasTrato().contains("Paseo diario"));
    }

    @Test
    @DisplayName("No debe agregar una necesidad especial vacía")
    void noAgregarNecesidadVacia() {

        mascota.agregarNecesidadEspecial("");

        assertTrue(mascota.getNecesidadesEspeciales().isEmpty());
    }

    @Test
    @DisplayName("No debe agregar una preferencia de trato vacía")
    void noAgregarPreferenciaVacia() {

        mascota.agregarPreferenciaTrato("");

        assertTrue(mascota.getPreferenciasTrato().isEmpty());
    }

    @Test
    @DisplayName("Debe ignorar nombre vacío al actualizar el perfil")
    void actualizarPerfilNombreVacio() {

        mascota.actualizarPerfil("",TamanoMascota.GRANDE,3);

        assertEquals("Max", mascota.getNombre());
    }

    @Test
    @DisplayName("No debe permitir edad negativa al actualizar el perfil")
    void actualizarPerfilEdadNegativa() {

        mascota.actualizarPerfil("Max",TamanoMascota.GRANDE,-2);
        assertEquals(3, mascota.getEdad());
    }
}
