package transporte_sur.clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private static final String NOMBRE_ARCHIVO = "usuarios.txt";

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String toCsvString() {
        return String.join(";", nombreUsuario, contrasena);
    }

    public static Usuario fromCsvString(String csvLine) {
        String[] data = csvLine.split(";");
        if (data.length != 2) {
            throw new IllegalArgumentException("Línea CSV con formato incorrecto para Usuario: " + csvLine);
        }
        return new Usuario(data[0], data[1]);
    }

    public static void insertarUsuario(Usuario usuario) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            bw.write(usuario.toCsvString());
            bw.newLine();
            System.out.println("Usuario insertado exitosamente: " + usuario.getNombreUsuario());
        } catch (IOException e) {
            System.err.println("Error al insertar el usuario: " + e.getMessage());
        }
    }

    public static Usuario buscarUsuario(String nombreUsuario) {
        List<Usuario> usuarios = obtenerUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        System.out.println("Usuario con nombre '" + nombreUsuario + "' no encontrado.");
        return null;
    }

    public static List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    try {
                        usuarios.add(Usuario.fromCsvString(line));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error al parsear línea CSV: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo de usuarios no existe. Se creará al insertar el primer usuario.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    public static Usuario autenticar(String nombreUsuario, String contrasena) {
        Usuario usuario = buscarUsuario(nombreUsuario);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            System.out.println("Autenticación exitosa para el usuario: " + nombreUsuario);
            return usuario;
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Usuario [" + "Nombre de Usuario='" + nombreUsuario + '\'' + ", Contraseña='" + contrasena + '\'' + ']';
    }
}
