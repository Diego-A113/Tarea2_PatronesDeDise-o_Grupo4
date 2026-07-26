package com;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.Patron_Observer.IObserverReserva;
import com.example.ReservaBuilder.Reserva;

public class ObserverTest {
    private Reserva reserva; 
    private ObserverPrueba observer; 
    
    private static class ObserverPrueba implements IObserverReserva { 
        boolean notificado; 
        int cantidadNotificaciones; 
        String ultimoEvento; 
        Reserva ultimaReserva; 
        
        @Override 
        public void actualizar(Reserva reserva, String evento) { 
            notificado = true; 
            cantidadNotificaciones+=1; 
            ultimoEvento = evento; 
            ultimaReserva = reserva; 
        } 
    } 
        
    @BeforeEach 
    void setUp() { 
        reserva = new Reserva(); 
        observer = new ObserverPrueba(); 
    } 
    
    @AfterEach void tearDown() { 
        reserva = null; 
        observer = null; 
    } 
    
    @Test 
    @DisplayName("Agregar un observador debe permitir recibir notificaciones") 
    void testAgregarObservador() { 
        reserva.agregarObservador(observer); 
        reserva.notificarObservadores("Reserva Confirmada"); 
        assertTrue(observer.notificado); 
    } 
    
    @Test 
    @DisplayName("Eliminar un observador evita que reciba notificaciones") 
    void testRemoverObservador() { 
        reserva.agregarObservador(observer); 
        reserva.removerObservador(observer); 
        reserva.notificarObservadores("Reserva Cancelada"); 
        assertFalse(observer.notificado); 
    } 
        
    @Test 
    @DisplayName("La reserva enviada al Observer debe ser la correcta") 
    void testReservaRecibida() { 
        reserva.agregarObservador(observer); 
        reserva.notificarObservadores("Reserva Confirmada"); 
        assertEquals(reserva, observer.ultimaReserva); 
    } 

}
