package com.proyecto;

// La clase Tecnico tambien hereda de Persona
// y tambien implementa la interfaz IDetalle.
public class Tecnico extends Persona implements IDetalle {

    // Atributos propios de Tecnico
    private String especialidad;
    private int tiempoServicio;

    // Constructor de Tecnico
    public Tecnico(String codigo, String nombres, String apellidos, String direccion, String sexo, String correo, String celular, String especialidad, int tiempoServicio) {
        //  Llama al constructor de la clase padre Persona
        super(codigo, nombres, apellidos, direccion, sexo, correo, celular);

        //  Guarda sus datos especificos
        this.especialidad = especialidad;
        this.tiempoServicio = tiempoServicio;
    }

    //  Getters y Setters de Tecnico
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public int getTiempoServicio() { return tiempoServicio; }
    public void setTiempoServicio(int tiempoServicio) { this.tiempoServicio = tiempoServicio; }


    // Implementación de Metodos Abstractos
    // Obligatorio por la clase abstracta Persona
    @Override
    public String getRol() {
        return "Técnico";
    }

    // Polimorfismo por Sobrescritura
    @Override
    public String toString() {
        // Llama al toString() del padre y le añade lo de Tecnico
        return super.toString() + ", Especialidad: " + especialidad + ", Tiempo: " + tiempoServicio + " años";
    }

    // Obligatorio por la interfaz IDetalle
    @Override
    public String mostrarDetalleCompleto() {
        StringBuilder detalle = new StringBuilder();
        detalle.append("--- FICHA COMPLETA DEL TÉCNICO ---\n");
        detalle.append(this.toString()); // Reutiliza la info base
        detalle.append("\n  Nivel de Experiencia: ");

        // Agrego una logica simple para calcular el nivel
        if (tiempoServicio > 5) {
            detalle.append("Senior");
        } else if (tiempoServicio > 2) {
            detalle.append("Semi-Senior");
        } else {
            detalle.append("Junior");
        }
        detalle.append("\n------------------------------------");
        return detalle.toString();
    }
}
