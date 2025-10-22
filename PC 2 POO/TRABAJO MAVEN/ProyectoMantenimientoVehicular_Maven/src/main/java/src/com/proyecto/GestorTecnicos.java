package com.proyecto;

import java.util.*;

public class GestorTecnicos {
    private final String ruta = "datos/tecnicos.txt";
    private List<Tecnico> tecnicos = new ArrayList<>();

    public GestorTecnicos() {
        cargarTecnicos();
    }

    private void cargarTecnicos() {
        for (String linea : ArchivoUtil.leerArchivo(ruta)) {
            String[] partes = linea.split(",");
            if (partes.length == 3) {
                tecnicos.add(new Tecnico(partes[0], partes[1], partes[2]));
            }
        }
    }

    public void guardarTecnicos() {
        List<String> lineas = new ArrayList<>();
        for (Tecnico t : tecnicos) {
            lineas.add(t.toString());
        }
        ArchivoUtil.escribirArchivo(ruta, lineas);
    }

    public void menuTecnicos(Scanner sc) {
        System.out.println("\n--- GESTIÓN DE TÉCNICOS ---");
        System.out.print("Ingrese código: ");
        String codigo = sc.nextLine();
        System.out.print("Ingrese nombres: ");
        String nombres = sc.nextLine();
        System.out.print("Ingrese especialidad: ");
        String especialidad = sc.nextLine();

        tecnicos.add(new Tecnico(codigo, nombres, especialidad));
        guardarTecnicos();
        System.out.println("Técnico agregado correctamente.");
    }
}
