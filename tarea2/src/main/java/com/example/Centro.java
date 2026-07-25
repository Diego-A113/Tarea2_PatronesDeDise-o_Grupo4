package com.example;

import java.time.LocalTime;
import java.util.List;

public class Centro {

    private int id;
    private String nombre;
    private String direccion;
    private int capacidad;
    private Administrador administrador;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private List<Restriccion> restricciones;
    private List<PoliticaCancelacion> politicasCancelacion;
    private List<IServicio> servicios;
    private List<Cuidador> cuidadores;
    private List<Promocion> promocionesVigentes;
    private List<Paquete> paquetes;

    public void agregarServicio(IServicio servicio) {
        if (servicios.contains(servicio)) {
            return;
        }
        this.servicios.add(servicio);
    }

    public void eliminarServicio(IServicio servicio) {
        if (!servicios.contains(servicio)) {
            return;
        }
        this.servicios.remove(servicio);
    }

    public void agregarRestriccion(Restriccion restriccion) {
        if (restricciones.contains(restriccion)) {
            return;
        }
        this.restricciones.add(restriccion);
    }

    public void eliminarRestriccion(Restriccion restriccion) {
        if (!restricciones.contains(restriccion)) {
            return;
        }
        this.restricciones.remove(restriccion);
    }

    public void agregarPoliticaCancelacion(PoliticaCancelacion politica) {
        if (politicasCancelacion.contains(politica)) {
            return;
        }
        this.politicasCancelacion.add(politica);
    }

    public void eliminarPoliticaCancelacion(PoliticaCancelacion politica) {
        if (!politicasCancelacion.contains(politica)) {
            return;
        }
        this.politicasCancelacion.remove(politica);
    }

    public void agregarCuidador(Cuidador cuidador) {
        if (cuidadores.contains(cuidador)) {
            return;
        }
        this.cuidadores.add(cuidador);
    }

    public void eliminarCuidador(Cuidador cuidador) {
        if (!cuidadores.contains(cuidador)) {
            return;
        }
        this.cuidadores.remove(cuidador);
    }

    public void agregarPromocion(Promocion promocion) {
        if (promocionesVigentes.contains(promocion)) {
            return;
        }
        this.promocionesVigentes.add(promocion);
    }

    public void eliminarPromocion(Promocion promocion) {
        if (!promocionesVigentes.contains(promocion)) {
            return;
        }
        this.promocionesVigentes.remove(promocion);
    }

    public void agregarPaquete(Paquete paquete) {
        if (paquetes.contains(paquete)) {
            return;
        }
        this.paquetes.add(paquete);
    }

    public void eliminarPaquete(Paquete paquete) {
        if (!paquetes.contains(paquete)) {
            return;
        }
        this.paquetes.remove(paquete);
    }

    public void verificarDisponibilidad() {
        System.out.println("Verificando disponibilidad...");
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<IServicio> getServicios() {
        return servicios;
    }

    public void setHorario(LocalTime horaApertura, LocalTime horaCierre) {
        if (horaApertura.isBefore(horaCierre)) {
            this.horaApertura = horaApertura;
            this.horaCierre = horaCierre;
        }
    }

    @Override
    public String toString() {
        return "[ID: " + id + " Nombre del Centro: " + nombre + " Direccion: " + direccion + "]";
    }
}
