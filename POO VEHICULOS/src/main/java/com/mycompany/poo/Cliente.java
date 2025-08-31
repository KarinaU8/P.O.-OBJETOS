package transporte_sur.clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static final String NOMBRE_ARCHIVO = "clientes.txt";

    public Cliente(String codigo, String nombres, String apellidos, String direccion, String sexo, String correo, String celular) {
        super(codigo, nombres, apellidos);
        this.direccion = direccion;
        this.sexo = sexo;
        this.correo = correo;
        this.celular = celular;
    }

    public ArrayList<Vehiculo> getVehiculos() { return vehiculos; }

    public void addVehiculo(Vehiculo v) {
        if (v != null && !vehiculos.contains(v)) {
            vehiculos.add(v);
            v.setDueño(this);
        }
    }

    public String toCsvString() {
        return String.join(";", codigo, nombres, apellidos, direccion, sexo, correo, celular);
    }

    public static Cliente fromCsvString(String csvLine) {
        String[] data = csvLine.split(";");
        if (data.length != 7) {
            throw new IllegalArgumentException("Línea CSV con formato incorrecto para Cliente: " + csvLine);
        }
        return new Cliente(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
    }

    public static void insertarCliente(Cliente cliente) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            bw.write(cliente.toCsvString());
            bw.newLine();
            System.out.println("Cliente insertado exitosamente: " + cliente.getCodigo());
        } catch (IOException e) {
            System.err.println("Error al insertar el cliente: " + e.getMessage());
        }
    }

    public static void modificarCliente(Cliente clienteModificado) {
        List<Cliente> clientes = obtenerClientes();
        boolean encontrado = false;
        
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCodigo().equals(clienteModificado.getCodigo())) {
                clientes.set(i, clienteModificado);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {
                for (Cliente cliente : clientes) {
                    bw.write(cliente.toCsvString());
                    bw.newLine();
                }
                System.out.println("Cliente modificado exitosamente: " + clienteModificado.getCodigo());
            } catch (IOException e) {
                System.err.println("Error al modificar el cliente: " + e.getMessage());
            }
        } else {
            System.out.println("Cliente con código " + clienteModificado.getCodigo() + " no encontrado para modificar.");
        }
    }

    public static void eliminarCliente(String codigo) {
        List<Cliente> clientes = obtenerClientes();
        List<Cliente> clientesActualizados = new ArrayList<>();
        boolean eliminado = false;

        for (Cliente cliente : clientes) {
            if (!cliente.getCodigo().equals(codigo)) {
                clientesActualizados.add(cliente);
            } else {
                eliminado = true;
            }
        }

        if (eliminado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {
                for (Cliente cliente : clientesActualizados) {
                    bw.write(cliente.toCsvString());
                    bw.newLine();
                }
                System.out.println("Cliente con código " + codigo + " eliminado exitosamente.");
            } catch (IOException e) {
                System.err.println("Error al eliminar el cliente: " + e.getMessage());
            }
        } else {
            System.out.println("Cliente con código " + codigo + " no encontrado para eliminar.");
        }
    }

    public static Cliente buscarCliente(String codigo) {
        List<Cliente> clientes = obtenerClientes();
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo().equals(codigo)) {
                return cliente;
            }
        }
        System.out.println("Cliente con código " + codigo + " no encontrado.");
        return null;
    }

    public static List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    try {
                        clientes.add(Cliente.fromCsvString(line));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error al parsear línea CSV: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo de clientes no existe. Se creará al insertar el primer cliente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de clientes: " + e.getMessage());
        }
        return clientes;
    }

    public static Cliente buscarClienteConVehiculos(String codigo, List<Vehiculo> todosLosVehiculos) {
        Cliente cliente = buscarCliente(codigo);
        if (cliente != null) {
            for (Vehiculo vehiculo : todosLosVehiculos) {
                if (vehiculo.getDueño() != null && vehiculo.getDueño().getCodigo().equals(codigo)) {
                    cliente.addVehiculo(vehiculo);
                }
            }
        }
        return cliente;
    }

    @Override
    public String toString() {
        return super.toString() + " | Vehículos: " + vehiculos.size();
    }
}
