package com.proyecto;

// Esta es la clase Persona, la definí como abstracta
// Esto significa que sirve como una plantilla, pero no se pueden crear
// objetos Persona directamente. O creas un Cliente o un Tecnico.
// Asi cumplo con Abstracción y Clases Abstractas.
public abstract class Persona {

    // Todos los atributos son private para protegerlos
    // Esto es el Encapsulamiento
    private String codigo;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String sexo;
    private String correo;
    private String celular;

    // Este es el constructor de Persona
    // Las clases que hereden de Persona, o sea las hijas, van a tener que usarlo
    // para inicializar estos datos comunes.
    public Persona(String codigo, String nombres, String apellidos, String direccion, String sexo, String correo, String celular) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.sexo = sexo;
        this.correo = correo;
        this.celular = celular;
    }

    // --- Getters y Setters ---
    // Hago estos metodos publicos para poder leer o sea get y
    // escribir o sea set los atributos privados desde otras clases.
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    // Este es un metodo abstracto, no tiene codigo, solo la firma.
    // Esto OBLIGA a que las clases hijas como Cliente y Tecnico
    // escriban su propia version de este metodo.
    public abstract String getRol();

    // Modifico el metodo toString que viene de Java.
    // Esto es Polimorfismo por Sobrescritura.
    // Sirve para que cuando imprima un objeto, se vea bonito
    // con los datos que yo quiero.
    @Override
    public String toString() {
        // Devuelvo un texto con todos los datos basicos
        // Fíjate que llamo a getRol(), que será implementado por la clase hija
        return "Codigo: " + codigo + ", Nombre: " + nombres + " " + apellidos + ", Rol: " + getRol() +
                ", Direccion: " + direccion + ", Sexo: " + sexo + ", Correo: " + correo + ", Celular: " + celular;
    }
}
