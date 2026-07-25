package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.recurrenciastrategy.IRecurrenciaStrategy;
import com.recurrenciastrategy.RecurrenciaDiariaStrategy;

public class RecurrenciaDiariaStrategyTest {

    private IRecurrenciaStrategy estrategia;
    private LocalDate inicio;
    private LocalDate fin;

    @BeforeEach
    void setUp() {
        estrategia = new RecurrenciaDiariaStrategy();
        inicio = LocalDate.of(2026, 8, 1);
        fin = LocalDate.of(2026, 8, 5);
    }

    @Test
    @DisplayName("Verificar que calcule correctamente los días consecutivos en un rango válido.")
    void calculoDiarioValido() {
        List<LocalDate> fechas = estrategia.calcularFechas(inicio, fin);
        
        // Del 1 al 5 de agosto hay exactamente 5 días
        assertEquals(5, fechas.size());
        assertEquals(LocalDate.of(2026, 8, 1), fechas.get(0));
        assertEquals(LocalDate.of(2026, 8, 5), fechas.get(4));
    }

    @Test
    @DisplayName("Verificar que devuelva un solo día cuando la fecha de inicio y fin son la misma.")
    void calculoUnSoloDia() {
        List<LocalDate> fechas = estrategia.calcularFechas(inicio, inicio);
        
        assertEquals(1, fechas.size());
        assertEquals(inicio, fechas.get(0));
    }

    @Test
    @DisplayName("Verificar que devuelva una lista vacía si la fecha fin es anterior a la fecha inicio.")
    void rangoInvalidoDevuelveListaVacia() {
        List<LocalDate> fechas = estrategia.calcularFechas(fin, inicio);
        assertTrue(fechas.isEmpty());
    }

    @Test
    @DisplayName("Verificar que devuelva una lista vacía si alguna fecha es nula.")
    void fechasNulasDevuelvenListaVacia() {
        List<LocalDate> fechasConInicioNulo = estrategia.calcularFechas(null, fin);
        List<LocalDate> fechasConFinNulo = estrategia.calcularFechas(inicio, null);
        
        assertTrue(fechasConInicioNulo.isEmpty());
        assertTrue(fechasConFinNulo.isEmpty());
    }
}
