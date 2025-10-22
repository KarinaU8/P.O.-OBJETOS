package com.proyecto;

public class Cliente {
    private String codigo;
    private String nombres;
    private String apellidos;
    private String razonSocial;
    private String direccion;
    private String telefono;
    private String correo;

    public Cliente(String codigo, String nombres, String apellidos, String razonSocial, String direccion, String telefono, String correo) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getCodigo() { return codigo; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getRazonSocial() { return razonSocial; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }

    @Override
    public String toString() {
        return codigo + "," + nombres + "," + apellidos + "," + razonSocial + "," + direccion + "," + telefono + "," + correo;
    }
}
