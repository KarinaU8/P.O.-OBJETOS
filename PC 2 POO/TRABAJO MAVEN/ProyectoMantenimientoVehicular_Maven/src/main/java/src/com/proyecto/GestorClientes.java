package com.proyecto;

import java.util.*;
import java.io.*;

public class GestorClientes {
    private final String ruta = "datos/clientes.txt";
    private List<Cliente> clientes = new ArrayList<>();

    public GestorClientes() {
        cargarClientes();
    }

    private void cargarClientes() {
        for (String linea : ArchivoUtil.leerArchivo(ruta)) {
            String[] partes = linea.split(",");
            if (partes.length == 7) {
                clientes.add(new Cliente(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5], partes[6]));
            }
        }
    }

    public void guardarClientes() {
        List<String> lineas = new ArrayList<>();
        for (Cliente c : clientes) {
            lineas.add(c.toString());
        }
        ArchivoUtil.escribirArchivo(ruta, lineas);
    }

    public void menuClientes(Scanner sc) {
        System.out.println("\n--- GESTIÓN DE CLIENTES ---");
        System.out.print("Ingrese código: ");
        String codigo = sc.nextLine();
        System.out.print("Ingrese nombres: ");
        String nombres = sc.nextLine();
        System.out.print("Ingrese apellidos: ");
        String apellidos = sc.nextLine();
        System.out.print("Ingrese razón social: ");
        String razon = sc.nextLine();
        System.out.print("Ingrese dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Ingrese teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Ingrese correo: ");
        String correo = sc.nextLine();

        clientes.add(new Cliente(codigo, nombres, apellidos, razon, direccion, telefono, correo));
        guardarClientes();
        System.out.println("Cliente agregado correctamente.");
    }
}
