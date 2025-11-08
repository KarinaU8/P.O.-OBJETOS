package com.proyecto.mantenimiento;

import java.time.LocalDate;

public class RegistroMantenimiento {
    private Vehiculo vehiculo;
    private String descripcion;
    private LocalDate fecha;

    public RegistroMantenimiento(Vehiculo vehiculo, String descripcion, LocalDate fecha) {
        this.vehiculo = vehiculo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Vehiculo getVehiculo() { return vehiculo; }
    public String getDescripcion() { return descripcion; }
    public LocalDate getFecha() { return fecha; }

    @Override
    public String toString() {
        return String.format("[%s] %s -> %s", fecha, vehiculo, descripcion);
    }
}

