package com.proyecto;

import java.util.*;

public class GestorMantenimientos {
    private final String ruta = "datos/mantenimientos.txt";
    private List<Mantenimiento> mantenimientos = new ArrayList<>();

    public GestorMantenimientos() {
        cargarMantenimientos();
    }

    private void cargarMantenimientos() {
        for (String linea : ArchivoUtil.leerArchivo(ruta)) {
            String[] partes = linea.split(",");
            if (partes.length == 5) {
                mantenimientos.add(new Mantenimiento(partes[0], partes[1], partes[2], partes[3], partes[4]));
            }
        }
    }

    public void guardarMantenimientos() {
        List<String> lineas = new ArrayList<>();
        for (Mantenimiento m : mantenimientos) {
            lineas.add(m.toString());
        }
        ArchivoUtil.escribirArchivo(ruta, lineas);
    }

    public void registrarMantenimiento(Scanner sc) {
        System.out.println("\n--- REGISTRAR MANTENIMIENTO ---");
        System.out.print("Ingrese código: ");
        String codigo = sc.nextLine();
        System.out.print("Ingrese código del vehículo: ");
        String codigoVehiculo = sc.nextLine();
        System.out.print("Ingrese código del técnico: ");
        String codigoTecnico = sc.nextLine();
        System.out.print("Ingrese descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Ingrese fecha (dd/mm/yyyy): ");
        String fecha = sc.nextLine();

        mantenimientos.add(new Mantenimiento(codigo, codigoVehiculo, codigoTecnico, descripcion, fecha));
        guardarMantenimientos();
        System.out.println("Mantenimiento registrado correctamente.");
    }

    public void mostrarMantenimientos() {
        System.out.println("\n--- LISTA DE MANTENIMIENTOS ---");
        for (Mantenimiento m : mantenimientos) {
            System.out.println(m);
        }
    }
}
