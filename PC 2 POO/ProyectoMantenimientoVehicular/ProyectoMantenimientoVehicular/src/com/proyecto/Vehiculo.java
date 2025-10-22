package com.proyecto;

public class Vehiculo {
    private String codigo;
    private String codigoCliente;
    private String marca;
    private String modelo;
    private String placa;

    public Vehiculo(String codigo, String codigoCliente, String marca, String modelo, String placa) {
        this.codigo = codigo;
        this.codigoCliente = codigoCliente;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
    }

    public String getCodigo() { return codigo; }
    public String getCodigoCliente() { return codigoCliente; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getPlaca() { return placa; }

    @Override
    public String toString() {
        return codigo + "," + codigoCliente + "," + marca + "," + modelo + "," + placa;
    }
}
