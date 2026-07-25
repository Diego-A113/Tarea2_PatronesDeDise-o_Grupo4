package com;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.recurrenciastrategy.IRecurrenciaStrategy;
import com.recurrenciastrategy.RecurrenciaPorEventoStrategy;

public class RecurrenciaPorEventoStrategyTest {

    private IRecurrenciaStrategy estrategia;
    private LocalDate inicioReserva;
    private LocalDate finReserva;

    @BeforeEach
    void setUp() {
        inicioReserva = LocalDate.of(2026, 8, 1);
        finReserva = LocalDate.of(2026, 8, 10);

        List<LocalDate> fechasEvento = List.of(
            LocalDate.of(2026, 8, 2),
            LocalDate.of(2026, 8, 8), 
            LocalDate.of(2026, 9, 15)  
        );
        
        estrategia = new RecurrenciaPorEventoStrategy(fechasEvento);
    }

    @Test
    @DisplayName("Verificar que solo conserve las fechas del evento que caen dentro del rango de la reserva.")
    void filtraFechasFueraDeRango() {
        List<LocalDate> fechas = estrategia.calcularFechas(inicioReserva, finReserva);
        
        assertEquals(2, fechas.size());
        assertEquals(LocalDate.of(2026, 8, 2), fechas.get(0));
        assertEquals(LocalDate.of(2026, 8, 8), fechas.get(1));
    }

    @Test
    @DisplayName("Verificar que devuelva lista vacía si todas las fechas del evento están fuera del rango.")
    void todasLasFechasFueraDeRango() {
        LocalDate inicioDiciembre = LocalDate.of(2026, 12, 1);
        LocalDate finDiciembre = LocalDate.of(2026, 12, 31);
        
        List<LocalDate> fechas = estrategia.calcularFechas(inicioDiciembre, finDiciembre);
        assertTrue(fechas.isEmpty());
    }

    @Test
    @DisplayName("Verificar manejo seguro cuando la lista de fechas de evento inicializada es nula.")
    void listaEventosNulaDevuelveListaVacia() {
        IRecurrenciaStrategy estrategiaNula = new RecurrenciaPorEventoStrategy(null);
        List<LocalDate> fechas = estrategiaNula.calcularFechas(inicioReserva, finReserva);
        
        assertTrue(fechas.isEmpty());
    }
}
