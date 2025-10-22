package com.proyecto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorClientes gestorClientes = new GestorClientes();
        GestorTecnicos gestorTecnicos = new GestorTecnicos();
        GestorVehiculos gestorVehiculos = new GestorVehiculos();
        GestorMantenimientos gestorMantenimientos = new GestorMantenimientos();

        int opcion;
        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Técnicos");
            System.out.println("3. Gestionar Vehículos");
            System.out.println("4. Registrar Mantenimiento");
            System.out.println("5. Mostrar Mantenimientos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> gestorClientes.menuClientes(sc);
                case 2 -> gestorTecnicos.menuTecnicos(sc);
                case 3 -> gestorVehiculos.menuVehiculos(sc);
                case 4 -> gestorMantenimientos.registrarMantenimiento(sc);
                case 5 -> gestorMantenimientos.mostrarMantenimientos();
                case 6 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }
}
