package com.proyecto.mantenimiento;

import java.util.Scanner;

public class LectorDatosVehiculos {
    private Scanner sc = new Scanner(System.in);

    public String leerLinea(String prompt) {
        System.out.print(prompt + ": ");
        return sc.nextLine().trim();
    }

    public int leerEntero(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                String line = sc.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intenta nuevamente.");
            }
        }
    }

    public void cerrar() {
        // no cerrar System.in scanner globally
    }
}
