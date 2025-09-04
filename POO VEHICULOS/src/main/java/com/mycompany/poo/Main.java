package transporte_sur;

import final_grupo_02.clases.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE TRANSPORTE SUR ===");
        
        Cliente cliente1 = new Cliente("C001", "Juan", "Perez", "Av. Siempre Viva 123", "M", "juan@email.com", "999888777");
        Cliente cliente2 = new Cliente("C002", "Maria", "Lopez", "Calle Los Olivos 456", "F", "maria@email.com", "988777666");
        
        Cliente.insertarCliente(cliente1);
        Cliente.insertarCliente(cliente2);
        
        Vehiculo vehiculo1 = new Vehiculo("V001", "ABC-123", "1HGBH41JXMN109186", 2020, "Rojo", 4, 2.0, cliente1);
        Vehiculo vehiculo2 = new Vehiculo("V002", "DEF-456", "5XYZH4AG0JH355774", 2018, "Azul", 4, 1.6, cliente1);
        
        Vehiculo.insertarVehiculo(vehiculo1);
        Vehiculo.insertarVehiculo(vehiculo2);
        
        Tecnico tecnico1 = new Tecnico("T001", "Carlos", "Gomez", "Av. Tecnica 321", "M", "carlos@taller.com", "966555444", "Mecánico General", 5);
        Tecnico.insertarTecnico(tecnico1);
        
        PlanMantenimiento plan1 = new PlanMantenimiento("M001", "Cambio de aceite", 15000, "Fuga de aceite", "2025-08-25", 120.50, tecnico1, vehiculo1);
        PlanMantenimiento.insertarPlanMantenimiento(plan1);
        
        System.out.println("\n--- Datos insertados correctamente ---");
        System.out.println("Clientes: " + Cliente.obtenerClientes().size());
        System.out.println("Vehículos: " + Vehiculo.obtenerVehiculos(Cliente.obtenerClientes()).size());
        System.out.println("Técnicos: " + Tecnico.obtenerTecnicos().size());
        System.out.println("Planes de mantenimiento: " + PlanMantenimiento.obtenerPlanesMantenimiento(Tecnico.obtenerTecnicos(), Vehiculo.obtenerVehiculos(Cliente.obtenerClientes())).size());
        
        scanner.close();
    }
}


