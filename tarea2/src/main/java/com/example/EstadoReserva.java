package com.example;

import java.time.LocalDate;

import com.example.ReservaBuilder.Reserva;

public enum EstadoReserva {
    EN_ESPERA {
        @Override
        public void confirmar(Reserva r) {
            for (LocalDate fecha : r.getFechasAsistencia()) {
                for (IServicio servicio : r.getServicios()) {
                    if (!servicio.verificarDisponibilidad(fecha)) {
                        System.out.println("El servicio " + servicio.getNombre() + 
                                                        " no está disponible el " + fecha);
                    }
                }
            }

            for (LocalDate fecha : r.getFechasAsistencia()) {
                for (IServicio servicio : r.getServicios()) {
                    servicio.cambiarEstadoPorFecha(fecha, EstadoReserva.OCUPADO);
                }
            }
            r.notificarObservadores("Reserva confirmada con éxito.");
            r.setEstado(OCUPADO);
        }

        @Override
        public void cancelar(Reserva r) {
            for (LocalDate fecha : r.getFechasAsistencia()) {
                for (IServicio servicio : r.getServicios()) {
                    servicio.cambiarEstadoPorFecha(fecha, EstadoReserva.CANCELADO);
                }
            }
            r.notificarObservadores("Reserva cancelada con éxito. Cupos liberados.");
            r.setEstado(CANCELADO);
        }
    },
    
    OCUPADO {
        @Override
        public void confirmar(Reserva r) {
            r.notificarObservadores("La reserva ya está confirmada.");
        }

        @Override
        public void cancelar(Reserva r) {
            for (LocalDate fecha : r.getFechasAsistencia()) {
                for (IServicio servicio : r.getServicios()) {
                    servicio.cambiarEstadoPorFecha(fecha, EstadoReserva.CANCELADO);
                }
            }
            r.notificarObservadores("Reserva cancelada con éxito. Cupos liberados.");
            r.setEstado(CANCELADO);
        }
    },
    
    CANCELADO {
        @Override
        public void confirmar(Reserva r) {
            r.notificarObservadores("No puedes confirmar una reserva cancelada.");
        }

        @Override
        public void cancelar(Reserva r) {
            r.notificarObservadores("La reserva ya está cancelada.");
        }
    };

    public abstract void confirmar(Reserva r);
    public abstract void cancelar(Reserva r);
}
