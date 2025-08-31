package transporte_sur.clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Vehiculo {
    private String codigo;
    private String placa;
    private String numeroSerie;
    private int añoDeFabricacion;
    private String color;
    private int cantidadPuertas;
    private double cilindrada;
    private Cliente dueño;
    private static final String NOMBRE_ARCHIVO = "vehiculos.txt";

    public Vehiculo(String codigo, String placa, String numeroSerie, int añoDeFabricacion, String color, int cantidadPuertas, double cilindrada, Cliente dueño) {
        this.codigo = codigo;
        this.placa = placa;
        this.numeroSerie = numeroSerie;
        this.añoDeFabricacion = añoDeFabricacion;
        this.color = color;
        this.cantidadPuertas = cantidadPuertas;
        this.cilindrada = cilindrada;
        this.dueño = dueño;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getNumeroSerie() { return numeroSerie; }
    public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }

    public int getAñoDeFabricacion() { return añoDeFabricacion; }
    public void setAñoDeFabricacion(int añoDeFabricacion) { this.añoDeFabricacion = añoDeFabricacion; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getCantidadPuertas() { return cantidadPuertas; }
    public void setCantidadPuertas(int cantidadPuertas) { this.cantidadPuertas = cantidadPuertas; }

    public double getCilindrada() { return cilindrada; }
    public void setCilindrada(double cilindrada) { this.cilindrada = cilindrada; }

    public Cliente getDueño() { return dueño; }
    public void setDueño(Cliente dueño) { this.dueño = dueño; }

    public String toCsvString() {
        String codigoDueño = (dueño != null) ? dueño.getCodigo() : "";
        return String.join(";", codigo, placa, numeroSerie, String.valueOf(añoDeFabricacion), color, String.valueOf(cantidadPuertas), String.valueOf(cilindrada), codigoDueño);
    }

    public static Vehiculo fromCsvString(String csvLine, List<Cliente> todosLosClientes) {
        String[] data = csvLine.split(";");
        if (data.length != 8) {
            throw new IllegalArgumentException("Línea CSV con formato incorrecto para Vehículo: " + csvLine);
        }
        try {
            int añoDeFabricacion = Integer.parseInt(data[3]);
            int cantidadPuertas = Integer.parseInt(data[5]);
            double cilindrada = Double.parseDouble(data[6]);
            
            Cliente clienteDueño = null;
            String codigoDueño = data[7];
            if (!codigoDueño.isEmpty()) {
                for (Cliente c : todosLosClientes) {
                    if (c.getCodigo().equals(codigoDueño)) {
                        clienteDueño = c;
                        break;
                    }
                }
            }
            return new Vehiculo(data[0], data[1], data[2], añoDeFabricacion, data[4], cantidadPuertas, cilindrada, clienteDueño);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error al parsear datos numéricos: " + csvLine, e);
        }
    }

    public static void insertarVehiculo(Vehiculo vehiculo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            bw.write(vehiculo.toCsvString());
            bw.newLine();
            System.out.println("Vehículo insertado exitosamente: " + vehiculo.getPlaca());
        } catch (IOException e) {
            System.err.println("Error al insertar el vehículo: " + e.getMessage());
        }
    }

    public static List<Vehiculo> obtenerVehiculos(List<Cliente> todosLosClientes) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    try {
                        vehiculos.add(Vehiculo.fromCsvString(line, todosLosClientes));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error al parsear línea CSV: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo de vehículos no existe. Se creará al insertar el primer vehículo.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de vehículos: " + e.getMessage());
        }
        return vehiculos;
    }

    @Override
    public String toString() {
        return placa + " (" + color + ") - Dueño: " + (dueño != null ? dueño.getNombres() : "Sin dueño");
    }
}
