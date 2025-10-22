package com.proyecto;

// Esta es la Interfaz
// Declara metodos que OTRAS clases deben implementar
// Cualquier clase que ponga implements IDetalle
// estará obligada a escribir el metodo mostrarDetalleCompleto.
// Esto me sirve para el Polimorfismo en el menu.
public interface IDetalle {
    String mostrarDetalleCompleto();
}
