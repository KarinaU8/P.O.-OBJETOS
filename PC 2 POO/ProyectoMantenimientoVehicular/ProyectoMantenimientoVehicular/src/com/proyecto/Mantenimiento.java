package com.proyecto;

public class Mantenimiento {
    private String codigo;
    private String codigoVehiculo;
    private String codigoTecnico;
    private String descripcion;
    private String fecha;

    public Mantenimiento(String codigo, String codigoVehiculo, String codigoTecnico, String descripcion, String fecha) {
        this.codigo = codigo;
        this.codigoVehiculo = codigoVehiculo;
        this.codigoTecnico = codigoTecnico;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getCodigo() { return codigo; }
    public String getCodigoVehiculo() { return codigoVehiculo; }
    public String getCodigoTecnico() { return codigoTecnico; }
    public String getDescripcion() { return descripcion; }
    public String getFecha() { return fecha; }

    @Override
    public String toString() {
        return codigo + "," + codigoVehiculo + "," + codigoTecnico + "," + descripcion + "," + fecha;
    }
}
