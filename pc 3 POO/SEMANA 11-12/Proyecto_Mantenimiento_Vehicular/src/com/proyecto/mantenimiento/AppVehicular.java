package com.proyecto.mantenimiento;

public class AppVehicular {
    public static void main(String[] args) {
        OperadorVehiculos operador = new OperadorVehiculos();
        LectorDatosVehiculos lector = new LectorDatosVehiculos();
        MenuVehicular menu = new MenuVehicular(operador, lector);

        // Datos iniciales de ejemplo
        operador.agregarVehiculo(new Vehiculo("ABC-123", "Toyota", "Corolla", 2015));
        operador.agregarVehiculo(new Vehiculo("XYZ-999", "Honda", "Civic", 2018));

        menu.mostrar();
    }
}
