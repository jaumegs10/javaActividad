# Gestión de Flota de Transporte - Actividad 2

## Contexto
Este proyecto es una aplicación desarrollada en Java para una empresa de transporte. Su objetivo es gestionar una flota de vehículos, conductores y rutas de transporte, registrando métricas importantes como la carga transportada, el consumo de combustible y la duración de las rutas.

## Objetivos del Proyecto
* Modelar las clases necesarias aplicando asociaciones y herencia.
* Implementar métodos que utilicen y procesen datos numéricos.
* Aprovechar las colecciones de Java para el almacenamiento de datos.
* Aplicar programación funcional para realizar análisis agrupados y filtros.

## Arquitectura y Clases Principales
El sistema se compone de las siguientes entidades:
* **Vehículos**: Uso de una clase abstracta `Vehiculo` de la que heredan `Camion` (con variables de ejes y capacidad de carga) y `Furgoneta` (basada en volumen).
* **Empleado**: Gestión de los conductores asignados a los viajes.
* **Ruta**: Entidad que une a un empleado con un vehículo para un trayecto, calculando su consumo estimado y validando las cargas.
* **Gestión de Rutas**: Implementación de la interfaz `IGestionRutas` para añadir, eliminar y filtrar rutas (por empleado, vehículo, destino o fechas) usando colecciones.
* **Testing**: Clases `TestHerencia` y `TestGestionRutas` para la comprobación y validación funcional del modelo.

## Tecnologías
* Java
* Eclipse IDE