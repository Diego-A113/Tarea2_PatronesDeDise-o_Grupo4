package com.example.Patron_Builder_Mascota;

import java.util.ArrayList;
import java.util.List;

public class Mascota {
    private int id;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private TamanoMascota tamano;

    private List<String> necesidadesEspeciales;
    private List<String> preferenciasTrato;

    public Mascota() {
        necesidadesEspeciales = new ArrayList<>();
        preferenciasTrato = new ArrayList<>();
    }

    public void agregarNecesidadEspecial(String necesidad){
        necesidadesEspeciales.add(necesidad);
    }

    public void agregarPreferenciaTrato(String preferencia){
        preferenciasTrato.add(preferencia);
    }
}
