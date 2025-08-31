package transporte_sur.clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tecnico {
    private String codigo;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String sexo;
    private String correo;
    private String celular;
    private String especialidad;
    private int tiempoServicio;
    private ArrayList<PlanMantenimiento> planes = new ArrayList<>();
    private static final String NOMBRE_ARCHIVO = "tecnicos.txt";
    
    public Tecnico(String codigo, String nombres, String apellidos, String direccion, String sexo, String correo, String celular, String especialidad, int tiempoServicio) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.sexo = sexo;
        this.correo = correo;
        this.celular = celular;
        this.especialidad = especialidad;
        this.tiempoServicio = tiempoServicio;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public int getTiempoServicio() { return tiempoServicio; }
    public void setTiempoServicio(int tiempoServicio) { this.tiempoServicio = tiempoServicio; }
    public ArrayList<PlanMantenimiento> getPlanes() { return planes; }
    public void addPlan(PlanMantenimiento p) {
        if (p != null && !planes.contains(p)) {
            planes.add(p);
            p.setTecnico(this);
        }
    }

    public String toCsvString() {
        return String.join(";", codigo, nombres, apellidos, direccion, sexo, correo, celular, especialidad, String.valueOf(tiempoServicio));
    }

    public static Tecnico fromCsvString(String csvLine) {
        String[] data = csvLine.split(";");
        if (data.length != 9) {
            throw new IllegalArgumentException("Línea CSV con formato incorrecto para Técnico: " + csvLine);
        }
        try {
            int tiempoServicio = Integer.parseInt(data[8]);
            return new Tecnico(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], tiempoServicio);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error al parsear 'tiempoServicio' a número: " + csvLine, e);
        }
    }

    public static void insertarTecnico(Tecnico tecnico) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            bw.write(tecnico.toCsvString());
            bw.newLine();
            System.out.println("Técnico insertado exitosamente: " + tecnico.getCodigo());
        } catch (IOException e) {
            System.err.println("Error al insertar el técnico: " + e.getMessage());
        }
    }

    public static List<Tecnico> obtenerTecnicos() {
        List<Tecnico> tecnicos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    try {
                        tecnicos.add(Tecnico.fromCsvString(line));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error al parsear línea CSV: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo de técnicos no existe. Se creará al insertar el primer técnico.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de técnicos: " + e.getMessage());
        }
        return tecnicos;
    }

    @Override
    public String toString() {
        return "Técnico [" + "Código='" + codigo + '\'' + ", Nombres='" + nombres + '\'' + ", Apellidos='" + apellidos + '\'' + ", Dirección='" + direccion + '\'' + ", Sexo='" + sexo + '\'' + ", Correo='" + correo + '\'' + ", Celular='" + celular + '\'' + ", Especialidad='" + especialidad + '\'' + ", Tiempo de Servicio=" + tiempoServicio + " años" + ']';
    }
}
