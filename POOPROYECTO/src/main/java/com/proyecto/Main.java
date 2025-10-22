package com.proyecto;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    // aqui se aplico el encapsulamiento porque las listas de clientes, tecnicos y vehiculos
    // son privadas y solo se manejan desde esta clase
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Tecnico> tecnicos = new ArrayList<>();
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    // aqui se definieron constantes para los archivos de texto que se usan
    // para guardar y recuperar la informacion de cada entidad
    private static final String CLIENTES_FILE = "clientes.txt";
    private static final String TECNICOS_FILE = "tecnicos.txt";
    private static final String VEHICULOS_FILE = "vehiculos.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // aqui se aplico abstraccion ya que la carga de datos se hace en un metodo aparte
        inicializarDatos();
        int opcion;

        // este es el menu principal que controla todas las opciones del sistema
        do {
            System.out.println("\n MENU PRINCIPAL ");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Tecnico");
            System.out.println("3. Registrar Vehiculo");
            System.out.println("4. Mostrar Clientes");
            System.out.println("5. Mostrar Tecnicos");
            System.out.println("6. Mostrar Vehiculos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            // aqui se aplica polimorfismo cuando mostramos los objetos
            // ya que cada clase tiene su propio toString
            switch (opcion) {
                case 1:
                    // aqui se aplica instanciacion ya que se crea un nuevo cliente
                    System.out.print("Codigo: ");
                    String codigoC = sc.nextLine();
                    System.out.print("Nombres: ");
                    String nombresC = sc.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidosC = sc.nextLine();
                    System.out.print("Direccion: ");
                    String direccionC = sc.nextLine();
                    System.out.print("Sexo: ");
                    String sexoC = sc.nextLine();
                    System.out.print("Correo: ");
                    String correoC = sc.nextLine();
                    System.out.print("Celular: ");
                    String celularC = sc.nextLine();
                    System.out.print("Tipo de Cliente: ");
                    String tipoC = sc.nextLine();

                    Cliente nuevoCliente = new Cliente(codigoC, nombresC, apellidosC, direccionC, sexoC, correoC, celularC, tipoC);
                    clientes.add(nuevoCliente);
                    guardarCliente(nuevoCliente);
                    System.out.println("Cliente registrado.");
                    break;

                case 2:
                    // aqui se aplica herencia porque la clase Tecnico hereda de Persona
                    System.out.print("Codigo: ");
                    String codigoT = sc.nextLine();
                    System.out.print("Nombres: ");
                    String nombresT = sc.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidosT = sc.nextLine();
                    System.out.print("Direccion: ");
                    String direccionT = sc.nextLine();
                    System.out.print("Sexo: ");
                    String sexoT = sc.nextLine();
                    System.out.print("Correo: ");
                    String correoT = sc.nextLine();
                    System.out.print("Celular: ");
                    String celularT = sc.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidadT = sc.nextLine();
                    System.out.print("Tiempo de servicio (años): ");
                    int tiempoT = sc.nextInt(); sc.nextLine();

                    Tecnico nuevoTecnico = new Tecnico(codigoT, nombresT, apellidosT, direccionT, sexoT, correoT, celularT, especialidadT, tiempoT);
                    tecnicos.add(nuevoTecnico);
                    guardarTecnico(nuevoTecnico);
                    System.out.println("Tecnico registrado.");
                    break;

                case 3:
                    // aqui se aplica instanciacion creando un nuevo vehiculo
                    System.out.print("Codigo: ");
                    String codigoV = sc.nextLine();
                    System.out.print("Placa: ");
                    String placaV = sc.nextLine();
                    System.out.print("Marca: ");
                    String marcaV = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modeloV = sc.nextLine();
                    System.out.print("Anio: ");
                    int anioV = sc.nextInt(); sc.nextLine();
                    System.out.print("Color: ");
                    String colorV = sc.nextLine();

                    Vehiculo nuevoVehiculo = new Vehiculo(codigoV, placaV, marcaV, modeloV, anioV, colorV);
                    vehiculos.add(nuevoVehiculo);
                    guardarVehiculo(nuevoVehiculo);
                    System.out.println("Vehiculo registrado.");
                    break;

                case 4:
                    System.out.println("\n LISTA DE CLIENTES ");
                    for (Cliente c : clientes) {
                        System.out.println(c); // aqui se aplica polimorfismo con toString
                    }
                    break;

                case 5:
                    System.out.println("\n LISTA DE TECNICOS ");
                    for (Tecnico t : tecnicos) {
                        System.out.println(t);
                    }
                    break;

                case 6:
                    System.out.println("\n LISTA DE VEHICULOS ");
                    for (Vehiculo v : vehiculos) {
                        System.out.println(v);
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    // aqui se aplico abstraccion porque se separa la logica de cargar datos
    private static void inicializarDatos() {
        cargarClientes();
        cargarTecnicos();
        cargarVehiculos();
    }

    // aqui se aplico persistencia para que los clientes se guarden en un archivo de texto
    private static void guardarCliente(Cliente c) {
        try (FileWriter fw = new FileWriter(CLIENTES_FILE, true)) {
            fw.write(c.getCodigo() + ";" + c.getNombres() + ";" + c.getApellidos() + ";" + c.getDireccion() + ";" +
                     c.getSexo() + ";" + c.getCorreo() + ";" + c.getCelular() + ";" + c.getTipoCliente() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // aqui igual se aplica persistencia pero para los tecnicos
    private static void guardarTecnico(Tecnico t) {
        try (FileWriter fw = new FileWriter(TECNICOS_FILE, true)) {
            fw.write(t.getCodigo() + ";" + t.getNombres() + ";" + t.getApellidos() + ";" + t.getDireccion() + ";" +
                     t.getSexo() + ";" + t.getCorreo() + ";" + t.getCelular() + ";" + t.getEspecialidad() + ";" + t.getTiempoServicio() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // aqui igual se aplica persistencia pero para los vehiculos
    private static void guardarVehiculo(Vehiculo v) {
        try (FileWriter fw = new FileWriter(VEHICULOS_FILE, true)) {
            fw.write(v.getCodigo() + ";" + v.getPlaca() + ";" + v.getMarca() + ";" + v.getModelo() + ";" + v.getAnio() + ";" + v.getColor() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // aqui se aplico abstraccion porque se separa el codigo para cargar clientes
    private static void cargarClientes() {
        File file = new File(CLIENTES_FILE);
        if (!file.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 8) {
                    clientes.add(new Cliente(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // lo mismo para cargar tecnicos
    private static void cargarTecnicos() {
        File file = new File(TECNICOS_FILE);
        if (!file.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 9) {
                    tecnicos.add(new Tecnico(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], Integer.parseInt(data[8])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // lo mismo para cargar vehiculos
    private static void cargarVehiculos() {
        File file = new File(VEHICULOS_FILE);
        if (!file.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 6) {
                    vehiculos.add(new Vehiculo(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), data[5]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
