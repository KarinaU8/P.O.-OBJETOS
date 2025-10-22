package com.proyecto;

import java.util.*;

public class GestorVehiculos {
    private final String ruta = "datos/vehiculos.txt";
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public GestorVehiculos() {
        cargarVehiculos();
    }

    private void cargarVehiculos() {
        for (String linea : ArchivoUtil.leerArchivo(ruta)) {
            String[] partes = linea.split(",");
            if (partes.length == 5) {
                vehiculos.add(new Vehiculo(partes[0], partes[1], partes[2], partes[3], partes[4]));
            }
        }
    }

    public void guardarVehiculos() {
        List<String> lineas = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            lineas.add(v.toString());
        }
        ArchivoUtil.escribirArchivo(ruta, lineas);
    }

    public void menuVehiculos(Scanner sc) {
        System.out.println("\n--- GESTIÓN DE VEHÍCULOS ---");
        System.out.print("Ingrese código: ");
        String codigo = sc.nextLine();
        System.out.print("Ingrese código de cliente: ");
        String codigoCliente = sc.nextLine();
        System.out.print("Ingrese marca: ");
        String marca = sc.nextLine();
        System.out.print("Ingrese modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Ingrese placa: ");
        String placa = sc.nextLine();

        vehiculos.add(new Vehiculo(codigo, codigoCliente, marca, modelo, placa));
        guardarVehiculos();
        System.out.println("Vehículo agregado correctamente.");
    }
}
