package com.proyecto.mantenimiento;

import java.util.ArrayList;
import java.util.List;

public class OperadorVehiculos {
    private List<Vehiculo> vehiculos;
    private List<RegistroMantenimiento> registros;

    public OperadorVehiculos() {
        vehiculos = new ArrayList<>();
        registros = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo v) {
        vehiculos.add(v);
    }

    public boolean eliminarVehiculoPorPlaca(String placa) {
        return vehiculos.removeIf(v -> v.getPlaca().equalsIgnoreCase(placa));
    }

    public Vehiculo buscarPorPlaca(String placa) {
        return vehiculos.stream().filter(v -> v.getPlaca().equalsIgnoreCase(placa)).findFirst().orElse(null);
    }

    public List<Vehiculo> listarVehiculos() {
        return new ArrayList<>(vehiculos);
    }

    public void registrarMantenimiento(RegistroMantenimiento r) {
        registros.add(r);
    }

    public List<RegistroMantenimiento> listarRegistros() {
        return new ArrayList<>(registros);
    }
}
