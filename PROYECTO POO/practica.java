// Ordena los boletos por precio y los muestra en pantalla

public void mostrarBoletosOrdenadosPorPrecio() {

    // Primera expresión lambda:
    // (b1, b2) -> Double.compare(b1.getValor(), b2.getValor())
    // Compara el valor (precio) de dos boletos para ordenarlos de menor a mayor.
    boletos.sort((b1, b2) -> Double.compare(b1.getValor(), b2.getValor()));

    // Segunda expresión lambda:
    // b -> System.out.println(...)
    // Recorre la lista de boletos y muestra en consola el código y el precio de cada uno.
    boletos.forEach(b -> 
        System.out.println("Boleto: " + b.getCodigo() + " - Precio: $" + b.getValor())
    );
}

