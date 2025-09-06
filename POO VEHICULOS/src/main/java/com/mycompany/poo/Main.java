import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Tecnico> tecnicos = new ArrayList<>();
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inicializarDatos();
        int opcion;

        do {
            System.out.println("\ MENÚ PRINCIPAL ");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Técnico");
            System.out.println("3. Registrar Vehículo");
            System.out.println("4. Mostrar Clientes");
            System.out.println("5. Mostrar Técnicos");
            System.out.println("6. Mostrar Vehículos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Codigo: ");
                    String codigo = sc.nextLine();
                    System.out.print("Nombres: ");
                    String nombres = sc.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidos = sc.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();
                    System.out.print("Sexo: ");
                    String sexo = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    System.out.print("Celular: ");
                    String celular = sc.nextLine();
                    System.out.print("Tipo de Cliente: ");
                    String tipo = sc.nextLine();
                    clientes.add(new Cliente(codigo, nombres, apellidos, direccion, sexo, correo, celular, tipo));
                    System.out.println("Cliente registrado.");
                }
                case 2 -> {
                    System.out.print("Codigo: ");
                    String codigo = sc.nextLine();
                    System.out.print("Nombres: ");
                    String nombres = sc.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidos = sc.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();
                    System.out.print("Sexo: ");
                    String sexo = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    System.out.print("Celular: ");
                    String celular = sc.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = sc.nextLine();
                    System.out.print("Tiempo de servicio (años): ");
                    int tiempo = sc.nextInt(); sc.nextLine();
                    tecnicos.add(new Tecnico(codigo, nombres, apellidos, direccion, sexo, correo, celular, especialidad, tiempo));
                    System.out.println("Técnico registrado.");
                }
                case 3 -> {
                    System.out.print("Codigo: ");
                    String codigo = sc.nextLine();
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Año: ");
                    int anio = sc.nextInt(); sc.nextLine();
                    System.out.print("Color: ");
                    String color = sc.nextLine();
                    vehiculos.add(new Vehiculo(codigo, placa, marca, modelo, anio, color));
                    System.out.println("Vehículo registrado.");
                }
                case 4 -> {
                    System.out.println("\n LISTA DE CLIENTES ");
                    clientes.forEach(System.out::println);
                }
                case 5 -> {
                    System.out.println("\n LISTA DE TÉCNICOS ");
                    tecnicos.forEach(System.out::println);
                }
                case 6 -> {
                    System.out.println("\n LISTA DE VEHÍCULOS ");
                    vehiculos.forEach(System.out::println);
                }
                case 0 -> System.out.println("Saliendo del sistema");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void inicializarDatos() {
        clientes.add(new Cliente("C01", "Juan", "Pérez", "Lima", "M", "juan@gmail.com", "987654321", "Particular"));
        clientes.add(new Cliente("C02", "Ana", "Gómez", "Arequipa", "F", "ana@gmail.com", "987654322", "Empresa"));

        tecnicos.add(new Tecnico("T01", "Luis", "Quispe", "Cusco", "M", "luis@correo.com", "987654323", "Mecánica", 5));
        tecnicos.add(new Tecnico("T02", "María", "Flores", "Tacna", "F", "maria@correo.com", "987654324", "Electricidad", 3));

        vehiculos.add(new Vehiculo("V01", "ABC-123", "Toyota", "Corolla", 2018, "Rojo"));
        vehiculos.add(new Vehiculo("V02", "XYZ-987", "Hyundai", "Accent", 2020, "Negro"));
    }
}



