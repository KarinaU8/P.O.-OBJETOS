package com.proyecto;

public class Tecnico {
    private String codigo;
    private String nombres;
    private String especialidad;

    public Tecnico(String codigo, String nombres, String especialidad) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.especialidad = especialidad;
    }

    public String getCodigo() { return codigo; }
    public String getNombres() { return nombres; }
    public String getEspecialidad() { return especialidad; }

    @Override
    public String toString() {
        return codigo + "," + nombres + "," + especialidad;
    }
}
