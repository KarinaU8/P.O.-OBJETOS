package com.proyecto;

import java.util.ArrayList; // Importo ArrayList para la lista de vehiculos

// La clase Cliente hereda de Persona por Herencia
// y ademas implementa la interfaz IDetalle
public class Cliente extends Persona implements IDetalle {

    private String tipoCliente;

    // Un Cliente tiene una lista de Vehiculos.
    private ArrayList<Vehiculo> misVehiculos;

    // Constructor de Cliente
    public Cliente(String codigo, String nombres, String apellidos, String direccion, String sexo, String correo, String celular, String tipoCliente) {
        //  Llamo al constructor de la clase padre Persona
        //  para guardar los datos comunes.
        super(codigo, nombres, apellidos, direccion, sexo, correo, celular);

        //  Guardo el dato que solo es de Cliente.
        this.tipoCliente = tipoCliente;

        // Inicializo la lista de vehiculos. Es importante
        //    para que no de error si intento agregar un vehiculo.
        this.misVehiculos = new ArrayList<>();
    }

    // Getters y Setters de Cliente
    public String getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(String tipoCliente) { this.tipoCliente = tipoCliente; }

    //  Metodos para la Asociación
    // Sirven para manejar la lista de vehiculos del cliente
    public void agregarVehiculo(Vehiculo v) {
        this.misVehiculos.add(v);
    }
    public ArrayList<Vehiculo> getMisVehiculos() { return misVehiculos; }


    //  Implementación de Metodos Abstractos

    // Este metodo es obligatorio porque Persona lo definió abstract
    @Override
    public String getRol() {
        return "Cliente";
    }

    // Este metodo es Polimorfismo por Sobrescritura
    @Override
    public String toString() {
        // Llamo al toString() de la clase padre Persona
        // y le agrego la informacion extra de Cliente.
        return super.toString() + ", Tipo: " + tipoCliente;
    }

    // Este metodo es obligatorio porque la interfaz IDetalle lo pide
    @Override
    public String mostrarDetalleCompleto() {
        // Uso StringBuilder para construir un texto largo, es mas eficiente
        StringBuilder detalle = new StringBuilder();
        detalle.append("--- FICHA COMPLETA DEL CLIENTE ---\n");
        detalle.append(this.toString()); // Reutilizo la info del toString()
        detalle.append("\n--- Vehículos Registrados (" + misVehiculos.size() + ") ---");

        if (misVehiculos.isEmpty()) {
            detalle.append("\n  (Sin vehículos registrados)");
        } else {
            // Si tiene vehiculos, los recorro y los imprimo
            for (Vehiculo v : misVehiculos) {
                detalle.append("\n  -> ").append(v.toString());
            }
        }
        detalle.append("\n------------------------------------");
        return detalle.toString();
    }
}
