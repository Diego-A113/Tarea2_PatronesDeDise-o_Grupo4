package com.recurrenciastrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RecurrenciaDiariaStrategyTest {

    private IRecurrenciaStrategy estrategia;
    private LocalDate inicio;
    private LocalDate fin;

    @BeforeEach
    public void setUp() {
        estrategia = new RecurrenciaDiariaStrategy();
        inicio = LocalDate.of(2026, 8, 1);
        fin = LocalDate.of(2026, 8, 5);
    }

    @Test
    public void calculoDiarioValido() {
        List<LocalDate> fechas = estrategia.calcularFechas(inicio, fin);
        
        // Del 1 al 5 de agosto hay exactamente 5 días
        assertEquals(5, fechas.size());
        assertEquals(LocalDate.of(2026, 8, 1), fechas.get(0));
        assertEquals(LocalDate.of(2026, 8, 5), fechas.get(4));
    }

    @Test
    public void calculoUnSoloDia() {
        List<LocalDate> fechas = estrategia.calcularFechas(inicio, inicio);
        
        assertEquals(1, fechas.size());
        assertEquals(inicio, fechas.get(0));
    }

    @Test
    public void rangoInvalidoDevuelveListaVacia() {
        List<LocalDate> fechas = estrategia.calcularFechas(fin, inicio);
        assertTrue(fechas.isEmpty());
    }

    @Test
    public void fechasNulasDevuelvenListaVacia() {
        List<LocalDate> fechasConInicioNulo = estrategia.calcularFechas(null, fin);
        List<LocalDate> fechasConFinNulo = estrategia.calcularFechas(inicio, null);
        
        assertTrue(fechasConInicioNulo.isEmpty());
        assertTrue(fechasConFinNulo.isEmpty());
    }
}