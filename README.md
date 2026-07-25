# SISTEMA PetDayCare
Sistema que permite a los usuarios registrar a sus mascotas y reservar servicios de cuidado, como guardería, hospedaje, paseos, entrenamiento y bienestar. El sistema gestiona la disponibilidad, las reservas, los pagos y las notificaciones, mientras que los administradores pueden configurar los servicios y atender incidencias para ofrecer una atención personalizada y de calidad.

## Patrones de Diseño Implementados

| Tipo | Patrón | Problema que resuelve |
|------|---------|-----------------------|
| Creacional | **Builder** | Permite construir reservas complejas con múltiples atributos opcionales (servicios, fechas, cuidador, observaciones, etc.) de forma flexible y ordenada. |
| Estructural | **Decorator** | Permite agregar servicios adicionales a una reserva, como cámaras en vivo, atención veterinaria o reportes en tiempo real, sin modificar la estructura base. |
| Comportamiento | **Observer** | Notifica automáticamente a los usuarios cuando cambia el estado de una reserva (confirmada, en proceso, cancelada, finalizada, etc.). |
| Comportamiento | **Strategy** | Permite cambiar el algoritmo utilizado para calcular precios, asignar cuidadores o aplicar diferentes políticas de cancelación según la situación. |
