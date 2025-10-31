package com.proyecto.mantenimiento;

import java.time.LocalDate;
import java.util.List;

public class MenuVehicular {
    private OperadorVehiculos operador;
    private LectorDatosVehiculos lector;

    public MenuVehicular(OperadorVehiculos operador, LectorDatosVehiculos lector) {
        this.operador = operador;
        this.lector = lector;
    }

    public void mostrar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- SISTEMA MANTENIMIENTO VEHICULAR ---");
            System.out.println("1. Agregar vehículo");
            System.out.println("2. Eliminar vehículo por placa");
            System.out.println("3. Registrar mantenimiento");
            System.out.println("4. Listar vehículos");
            System.out.println("5. Listar registros de mantenimiento");
            System.out.println("0. Salir");
            int opt = lector.leerEntero("Elija una opción");
            switch (opt) {
                case 1: opcionAgregar(); break;
                case 2: opcionEliminar(); break;
                case 3: opcionRegistrarMantenimiento(); break;
                case 4: opcionListarVehiculos(); break;
                case 5: opcionListarRegistros(); break;
                case 0: salir = true; System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida.");
            }
        }
    }

    private void opcionAgregar() {
        String placa = lector.leerLinea("Placa");
        String marca = lector.leerLinea("Marca");
        String modelo = lector.leerLinea("Modelo");
        int anio = lector.leerEntero("Año");
        Vehiculo v = new Vehiculo(placa, marca, modelo, anio);
        operador.agregarVehiculo(v);
        System.out.println("Vehículo agregado: " + v);
    }

    private void opcionEliminar() {
        String placa = lector.leerLinea("Placa a eliminar");
        boolean ok = operador.eliminarVehiculoPorPlaca(placa);
        System.out.println(ok ? "Vehículo eliminado." : "No se encontró vehículo con esa placa.");
    }

    private void opcionRegistrarMantenimiento() {
        String placa = lector.leerLinea("Placa del vehículo");
        Vehiculo v = operador.buscarPorPlaca(placa);
        if (v == null) {
            System.out.println("Vehículo no encontrado, registre primero el vehículo.");
            return;
        }
        String desc = lector.leerLinea("Descripción del mantenimiento");
        int year = lector.leerEntero("Año del mantenimiento (ej: 2025)");
        int month = lector.leerEntero("Mes (1-12)");
        int day = lector.leerEntero("Día (1-31)");
        LocalDate fecha;
        try {
            fecha = LocalDate.of(year, month, day);
        } catch (Exception e) {
            System.out.println("Fecha inválida. Uso fecha actual.");
            fecha = LocalDate.now();
        }
        RegistroMantenimiento r = new RegistroMantenimiento(v, desc, fecha);
        operador.registrarMantenimiento(r);
        System.out.println("Registro agregado: " + r);
    }

    private void opcionListarVehiculos() {
        List<Vehiculo> lista = operador.listarVehiculos();
        if (lista.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        System.out.println("--- Vehículos ---");
        lista.forEach(System.out::println);
    }

    private void opcionListarRegistros() {
        List<RegistroMantenimiento> lista = operador.listarRegistros();
        if (lista.isEmpty()) {
            System.out.println("No hay registros de mantenimiento.");
            return;
        }
        System.out.println("--- Registros de Mantenimiento ---");
        lista.forEach(System.out::println);
    }
}
