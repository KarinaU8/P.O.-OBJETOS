package com.proyecto;

public class Tecnico extends Persona {
    private String especialidad;
    private int tiempoServicio;

    public Tecnico(String codigo, String nombres, String apellidos, String direccion, String sexo, String correo, String celular, String especialidad, int tiempoServicio) {
        super(codigo, nombres, apellidos, direccion, sexo, correo, celular);
        this.especialidad = especialidad;
        this.tiempoServicio = tiempoServicio;
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public int getTiempoServicio() { return tiempoServicio; }
    public void setTiempoServicio(int tiempoServicio) { this.tiempoServicio = tiempoServicio; }

    @Override
    public String toString() {
        return super.toString() + ", Especialidad: " + especialidad + ", Tiempo de Servicio: " + tiempoServicio + " años";
    }
}
