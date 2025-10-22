package com.proyecto;

// Esta es una clase simple para guardar datos de Vehiculos.
// No hereda de nadie, pero será usada por Cliente en la Asociación.
public class Vehiculo {

    // Sus atributos privados por Encapsulamiento
    private String codigo;
    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private String color;

        // Pide todos los datos para crear el objeto.
    public Vehiculo(String codigo, String placa, String marca, String modelo, int anio, String color) {
        this.codigo = codigo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
    }


    // Esto es Sobrecarga de Constructores que es un tipo de Polimorfismo.
    // Se llama igual Vehiculo pero tiene diferentes parametros.
    // Sirve para crear un vehiculo con menos datos.
    public Vehiculo(String placa, String marca) {
        this.codigo = "V-" + System.currentTimeMillis(); // Genera un codigo automatico
        this.placa = placa;
        this.marca = marca;
        this.modelo = "Desconocido"; // Pone valores por defecto
        this.anio = 0;
        this.color = "Sin definir";
    }

    // Getters y Setters
    // Metodos para acceder a los atributos privados
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

    // Su propio metodo toString para imprimir la info del vehiculo
    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo + ", Año: " + anio + ", Color: " + color;
    }
}
