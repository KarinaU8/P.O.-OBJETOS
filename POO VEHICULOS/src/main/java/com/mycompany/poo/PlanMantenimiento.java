package transporte_sur.clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlanMantenimiento {
    private String codigoMantenimiento;
    private String tipoMantenimiento;
    private int kilometraje;
    private String falla;
    private String fecha;
    private double costo;
    private Tecnico tecnico;
    private Vehiculo vehiculo;
    private static final String NOMBRE_ARCHIVO = "planes_mantenimiento.txt";

    public PlanMantenimiento(String codigoMantenimiento, String tipoMantenimiento, int kilometraje, String falla, String fecha, double costo, Tecnico tecnico, Vehiculo vehiculo) {
        this.codigoMantenimiento = codigoMantenimiento;
        this.tipoMantenimiento = tipoMantenimiento;
        this.kilometraje = kilometraje;
        this.falla = falla;
        this.fecha = fecha;
        this.costo = costo;
        this.tecnico = tecnico;
        this.vehiculo = vehiculo;
    }

    public String getCodigoMantenimiento() { return codigoMantenimiento; }
    public void setCodigoMantenimiento(String codigoMantenimiento) { this.codigoMantenimiento = codigoMantenimiento; }
    public String getTipoMantenimiento() { return tipoMantenimiento; }
    public void setTipoMantenimiento(String tipoMantenimiento) { this.tipoMantenimiento = tipoMantenimiento; }
    public int getKilometraje() { return kilometraje; }
    public void setKilometraje(int kilometraje) { this.kilometraje = kilometraje; }
    public String getFalla() { return falla; }
    public void setFalla(String falla) { this.falla = falla; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
    public Tecnico getTecnico() { return tecnico; }
    public void setTecnico(Tecnico tecnico) { this.tecnico = tecnico; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    public String toCsvString() {
        String codigoTecnico = (tecnico != null) ? tecnico.getCodigo() : "";
        String codigoVehiculo = (vehiculo != null) ? vehiculo.getCodigo() : "";
        return String.join(";", codigoMantenimiento, codigoTecnico, tipoMantenimiento, codigoVehiculo, String.valueOf(kilometraje), falla, fecha, String.valueOf(costo));
    }

    public static PlanMantenimiento fromCsvString(String csvLine, List<Tecnico> todosLosTecnicos, List<Vehiculo> todosLosVehiculos) {
        String[] data = csvLine.split(";");
        if (data.length != 8) {
            throw new IllegalArgumentException("Línea CSV con formato incorrecto para PlanMantenimiento: " + csvLine);
        }
        try {
            int kilometraje = Integer.parseInt(data[4]);
            double costo = Double.parseDouble(data[7]);
            
            Tecnico tecnicoAsignado = null;
            String codigoTecnico = data[1];
            if (!codigoTecnico.isEmpty()) {
                for (Tecnico t : todosLosTecnicos) {
                    if (t.getCodigo().equals(codigoTecnico)) {
                        tecnicoAsignado = t;
                        break;
                    }
                }
            }
            
            Vehiculo vehiculoAsignado = null;
            String codigoVehiculo = data[3];
            if (!codigoVehiculo.isEmpty()) {
                for (Vehiculo v : todosLosVehiculos) {
                    if (v.getCodigo().equals(codigoVehiculo)) {
                        vehiculoAsignado = v;
                        break;
                    }
                }
            }
            
            return new PlanMantenimiento(data[0], data[2], kilometraje, data[5], data[6], costo, tecnicoAsignado, vehiculoAsignado);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error al parsear datos numéricos: " + csvLine, e);
        }
    }

    public static void insertarPlanMantenimiento(PlanMantenimiento plan) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            bw.write(plan.toCsvString());
            bw.newLine();
            System.out.println("Plan de Mantenimiento insertado exitosamente: " + plan.getCodigoMantenimiento());
        } catch (IOException e) {
            System.err.println("Error al insertar el plan de mantenimiento: " + e.getMessage());
        }
    }

    public static List<PlanMantenimiento> obtenerPlanesMantenimiento(List<Tecnico> todosLosTecnicos, List<Vehiculo> todosLosVehiculos) {
        List<PlanMantenimiento> planes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    try {
                        planes.add(PlanMantenimiento.fromCsvString(line, todosLosTecnicos, todosLosVehiculos));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error al parsear línea CSV: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo de planes de mantenimiento no existe. Se creará al insertar el primer plan.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de planes de mantenimiento: " + e.getMessage());
        }
        return planes;
    }

    @Override
    public String toString() {
        return "Plan de Mantenimiento [" + "Código='" + codigoMantenimiento + '\'' + ", Técnico='" + (tecnico != null ? tecnico.getNombres() : "N/A") + '\'' + ", Tipo='" + tipoMantenimiento + '\'' + ", Vehículo='" + (vehiculo != null ? vehiculo.getPlaca() : "N/A") + '\'' + ", Kilometraje=" + kilometraje + " km" + ", Falla='" + falla + '\'' + ", Fecha='" + fecha + '\'' + ", Costo=" + String.format("%.2f", costo) + " PEN" + ']';
    }
}


