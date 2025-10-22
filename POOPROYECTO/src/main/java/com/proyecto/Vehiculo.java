package com.proyecto;

public class Vehiculo {
    private String codigo;
    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private String color;

    public Vehiculo(String codigo, String placa, String marca, String modelo, int anio, String color) {
        this.codigo = codigo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
    }

    public Vehiculo(String placa, String marca) {
        this.codigo = "V-" + System.currentTimeMillis();
        this.placa = placa;
        this.marca = marca;
        this.modelo = "Desconocido";
        this.anio = 0;
        this.color = "Sin definir";
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo + ", Año: " + anio + ", Color: " + color;
    }
}