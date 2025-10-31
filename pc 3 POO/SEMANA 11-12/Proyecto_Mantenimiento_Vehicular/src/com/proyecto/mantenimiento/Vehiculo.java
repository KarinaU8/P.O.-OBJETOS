package com.proyecto.mantenimiento;

import java.time.LocalDate;

public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int anio;

    public Vehiculo(String placa, String marca, String modelo, int anio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAnio() { return anio; }

    @Override
    public String toString() {
        return String.format("%s - %s %s (%d)", placa, marca, modelo, anio);
    }
}
