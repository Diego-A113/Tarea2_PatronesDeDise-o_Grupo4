package com;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.recurrenciastrategy.IRecurrenciaStrategy;
import com.recurrenciastrategy.RecurrenciaSemanalStrategy;

public class RecurrenciaSemanalStrategyTest {

    private IRecurrenciaStrategy estrategia;
    private LocalDate inicio;
    private LocalDate fin;

    @BeforeEach
    void setUp() {
        Set<DayOfWeek> diasPermitidos = Set.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY);
        estrategia = new RecurrenciaSemanalStrategy(diasPermitidos);
        
        inicio = LocalDate.of(2026, 8, 3);
        fin = LocalDate.of(2026, 8, 14);
    }

    @Test
    @DisplayName("Verificar que extraiga únicamente los días de la semana permitidos.")
    void calculoSemanalValido() {
        List<LocalDate> fechas = estrategia.calcularFechas(inicio, fin);
        
        assertEquals(4, fechas.size());
        assertEquals(LocalDate.of(2026, 8, 3), fechas.get(0));
        assertEquals(LocalDate.of(2026, 8, 5), fechas.get(1)); 
        assertEquals(LocalDate.of(2026, 8, 10), fechas.get(2)); 
        assertEquals(LocalDate.of(2026, 8, 12), fechas.get(3));
    }

    @Test
    @DisplayName("Verificar que devuelva lista vacía si el rango no contiene ninguno de los días permitidos.")
    void sinDiasCoincidentesDevuelveListaVacia() {
        LocalDate martes = LocalDate.of(2026, 8, 4);
        List<LocalDate> fechas = estrategia.calcularFechas(martes, martes);
        
        assertTrue(fechas.isEmpty());
    }

    @Test
    @DisplayName("Verificar manejo seguro cuando el conjunto de días permitidos es nulo.")
    void diasPermitidosNulosDevuelvenListaVacia() {
        IRecurrenciaStrategy estrategiaNula = new RecurrenciaSemanalStrategy(null);
        List<LocalDate> fechas = estrategiaNula.calcularFechas(inicio, fin);
        
        assertTrue(fechas.isEmpty());
    }
}