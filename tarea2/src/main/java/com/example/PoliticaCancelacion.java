package com.example;

public class PoliticaCancelacion {

    private int id;
    private int tiempoLimiteHoras;
    private double porcentajeReembolso;
    private String descripcion;

    public double calcularReembolso() {
        return porcentajeReembolso;
    }

    public boolean esCancelable(int horasRestantes) {
        return horasRestantes >= this.tiempoLimiteHoras;
    }
}
