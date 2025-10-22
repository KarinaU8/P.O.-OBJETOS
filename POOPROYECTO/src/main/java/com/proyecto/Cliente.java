package com.proyecto;

public class Cliente extends Persona {
    private String tipoCliente;

    public Cliente(String codigo, String nombres, String apellidos, String direccion, String sexo, String correo, String celular, String tipoCliente) {
        super(codigo, nombres, apellidos, direccion, sexo, correo, celular);
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(String tipoCliente) { this.tipoCliente = tipoCliente; }

    @Override
    public String toString() {
        return super.toString() + ", Tipo de Cliente: " + tipoCliente;
    }
}
