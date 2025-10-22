package com.proyecto;

// Importo las clases que necesito
import java.util.HashMap; // Importo HashMap para usar Map o sea Diccionarios
import java.util.Scanner; // Importo Scanner para leer del teclado
import java.io.*; // Importo java.io.* para manejar archivos de Input/Output
import java.util.ArrayList;

public class Main {

    // --- Colecciones
    // Uso HashMap para guardar todos los objetos.
    // Guardo cada objeto usando su codigo String como llave.
    // Esto hace que buscar usando el codigo sea inmediato.
    // Son private por Encapsulamiento y static porque pertenecen a Main.
    private static HashMap<String, Cliente> clientes = new HashMap<>();
    private static HashMap<String, Tecnico> tecnicos = new HashMap<>();
    private static HashMap<String, Vehiculo> vehiculos = new HashMap<>();

    // Constantes para los nombres de los archivos.
    // final significa que su valor no puede cambiar.
    private static final String CLIENTES_FILE = "clientes.txt";
    private static final String TECNICOS_FILE = "tecnicos.txt";
    private static final String VEHICLOS_FILE = "vehiculos.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Llamo a este metodo para cargar los datos de los .txt
        // al arrancar el programa.
        inicializarDatos();
        int opcion;

        // Uso un bucle do-while para que el menu se repita
        // hasta que el usuario elija la opcion 0 para salir.
        do {
            System.out.println("\n--- MENÚ PRINCIPAL TALLER POO ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Tecnico");
            System.out.println("3. Registrar Vehiculo (Asociar a Cliente)");
            System.out.println("4. Mostrar Clientes");
            System.out.println("5. Mostrar Tecnicos");
            System.out.println("6. Mostrar Vehiculos");
            System.out.println("7. Mostrar Detalle Completo (Cliente o Tecnico)");
            System.out.println("8. Eliminar Cliente/Tecnico/Vehiculo");
            System.out.println("9. Editar Cliente/Tecnico/Vehiculo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpio el buffer del scanner o sea el Enter que queda

            // switch para manejar la opcion elegida
            switch (opcion) {
                case 1:
                    //  REGISTRAR CLIENTE
                    System.out.print("Codigo (ej. C007): ");
                    String codigoC = sc.nextLine();
                    // Verifico si el codigo ya existe en el Map
                    if (clientes.containsKey(codigoC)) {
                        System.out.println("Error: El codigo ya existe.");
                        break; // Sale de este case y vuelve al menu
                    }
                    // Pido el resto de datos
                    System.out.print("Nombres: "); String nombresC = sc.nextLine();
                    System.out.print("Apellidos: "); String apellidosC = sc.nextLine();
                    System.out.print("Direccion: "); String direccionC = sc.nextLine();
                    System.out.print("Sexo (M/F): "); String sexoC = sc.nextLine();
                    System.out.print("Correo: "); String correoC = sc.nextLine();
                    System.out.print("Celular: "); String celularC = sc.nextLine();
                    System.out.print("Tipo de Cliente (Premium, Regular, VIP): "); String tipoC = sc.nextLine();

                    // Creo el nuevo objeto Cliente
                    Cliente nuevoCliente = new Cliente(codigoC, nombresC, apellidosC, direccionC, sexoC, correoC, celularC, tipoC);

                    // Lo guardo en la Coleccion que es el Mapa
                    clientes.put(nuevoCliente.getCodigo(), nuevoCliente);
                    // Lo guardo en el archivo .txt para Persistencia
                    guardarCliente(nuevoCliente);
                    System.out.println("Cliente registrado exitosamente.");
                    break;

                case 2:
                    // REGISTRAR TECNICO
                    System.out.print("Codigo (ej. T007): ");
                    String codigoT = sc.nextLine();
                    if (tecnicos.containsKey(codigoT)) {
                        System.out.println("Error: El codigo ya existe.");
                        break;
                    }
                    System.out.print("Nombres: "); String nombresT = sc.nextLine();
                    System.out.print("Apellidos: "); String apellidosT = sc.nextLine();
                    System.out.print("Direccion: "); String direccionT = sc.nextLine();
                    System.out.print("Sexo (M/F): "); String sexoT = sc.nextLine();
                    System.out.print("Correo: "); String correoT = sc.nextLine();
                    System.out.print("Celular: "); String celularT = sc.nextLine();
                    System.out.print("Especialidad: "); String especialidadT = sc.nextLine();
                    System.out.print("Tiempo de servicio (años): "); int tiempoT = sc.nextInt(); sc.nextLine();

                    //Creo el objeto Tecnico
                    Tecnico nuevoTecnico = new Tecnico(codigoT, nombresT, apellidosT, direccionT, sexoT, correoT, celularT, especialidadT, tiempoT);
                    tecnicos.put(nuevoTecnico.getCodigo(), nuevoTecnico);
                    guardarTecnico(nuevoTecnico);
                    System.out.println("Tecnico registrado exitosamente.");
                    break;

                case 3:
                    // REGISTRAR VEHICULO
                    System.out.print("Ingrese Codigo del Cliente dueño del vehiculo: ");
                    String codCliente = sc.nextLine();

                    // Busco al cliente en el Map.
                    Cliente dueno = clientes.get(codCliente);

                    // Si get no encuentra nada, devuelve null
                    if (dueno == null) {
                        System.out.println("Error: No se encontró un cliente con ese codigo.");
                        break;
                    }

                    // Si lo encuentra, sigo
                    System.out.println("Registrando vehiculo para el Cliente: " + dueno.getNombres());
                    System.out.print("Codigo Vehiculo (ej. V007): ");
                    String codigoV = sc.nextLine();
                    if (vehiculos.containsKey(codigoV)) {
                        System.out.println("Error: El codigo de vehiculo ya existe.");
                        break;
                    }
                    System.out.print("Placa: "); String placaV = sc.nextLine();
                    System.out.print("Marca: "); String marcaV = sc.nextLine();
                    System.out.print("Modelo: "); String modeloV = sc.nextLine();
                    System.out.print("Anio: "); int anioV = sc.nextInt(); sc.nextLine();
                    System.out.print("Color: "); String colorV = sc.nextLine();

                    Vehiculo nuevoVehiculo = new Vehiculo(codigoV, placaV, marcaV, modeloV, anioV, colorV);

                    // Guardo el vehiculo en el mapa general de vehiculos
                    vehiculos.put(nuevoVehiculo.getCodigo(), nuevoVehiculo);
                    // Agrego el vehiculo a la lista personal del cliente
                    dueno.agregarVehiculo(nuevoVehiculo);

                    guardarVehiculo(nuevoVehiculo);
                    System.out.println("Vehiculo registrado y asociado a " + dueno.getNombres());
                    break;

                case 4:
                    System.out.println("\n--- LISTA DE CLIENTES ---");
                    // Recorro todos los valores o sea los objetos Cliente del mapa
                    for (Cliente c : clientes.values()) {
                        // Llama al toString() de Cliente que es Polimorfismo
                        System.out.println(c);
                    }
                    break;

                case 5:
                    System.out.println("\n--- LISTA DE TECNICOS ---");
                    for (Tecnico t : tecnicos.values()) {
                        System.out.println(t); // Llama al toString() de Tecnico
                    }
                    break;

                case 6:
                    System.out.println("\n--- LISTA DE VEHICULOS ---");
                    for (Vehiculo v : vehiculos.values()) {
                        System.out.println(v); // Llama al toString() de Vehiculo
                    }
                    break;

                case 7:
                    //POLIMORFISMO CON INTERFACES
                    System.out.print("Ingrese el Codigo del Cliente (Cxxx) o Tecnico (Txxx): ");
                    String codBusqueda = sc.nextLine();

                    // Creo una variable del tipo de la Interfaz
                    IDetalle objetoDetallable = null;

                    // Reviso si el codigo es de un cliente
                    if (codBusqueda.startsWith("C") && clientes.containsKey(codBusqueda)) {
                        // Si es cliente, lo asigno a la variable IDetalle
                        objetoDetallable = clientes.get(codBusqueda);
                    }
                    // Reviso si es de un tecnico
                    else if (codBusqueda.startsWith("T") && tecnicos.containsKey(codBusqueda)) {
                        // Si es tecnico, tambien lo asigno a la misma variable
                        objetoDetallable = tecnicos.get(codBusqueda);
                    }

                    // Si objetoDetallable no es null o sea, si encontramos algo
                    if (objetoDetallable != null) {
                        // Aqui ocurre el Polimorfismo.
                        // No me importa si es Cliente o Tecnico, solo sé que
                        // cumple el contrato IDetalle, asi que tiene este metodo.
                        System.out.println(objetoDetallable.mostrarDetalleCompleto());
                    } else {
                        System.out.println("Codigo no encontrado.");
                    }
                    break;

                case 8:
                    System.out.print("Eliminar tipo (C Cliente / T Tecnico / V Vehiculo): ");
                    String tipoE = sc.nextLine().toUpperCase();
                    System.out.print("Ingrese codigo a eliminar: ");
                    String codE = sc.nextLine();
                    if (tipoE.equals("C") && clientes.containsKey(codE)) {
                        clientes.remove(codE);
                        // Reescribo archivo de clientes completo
                        persistirClientes();
                        System.out.println("Cliente eliminado.");
                    } else if (tipoE.equals("T") && tecnicos.containsKey(codE)) {
                        tecnicos.remove(codE);
                        persistirTecnicos();
                        System.out.println("Tecnico eliminado.");
                    } else if (tipoE.equals("V") && vehiculos.containsKey(codE)) {
                        vehiculos.remove(codE);
                        persistirVehiculos();
                        System.out.println("Vehiculo eliminado.");
                    } else {
                        System.out.println("Codigo no encontrado para eliminar.");
                    }
                    break;

                case 9:
                    System.out.print("Editar tipo (C Cliente / T Tecnico / V Vehiculo): ");
                    String tipoEd = sc.nextLine().toUpperCase();
                    System.out.print("Ingrese codigo a editar: ");
                    String codEd = sc.nextLine();
                    if (tipoEd.equals("C") && clientes.containsKey(codEd)) {
                        Cliente c = clientes.get(codEd);
                        System.out.print("Nuevos Nombres (enter para mantener): ");
                        String nn = sc.nextLine();
                        if (!nn.isEmpty()) c.setNombres(nn);
                        System.out.print("Nuevos Apellidos (enter para mantener): ");
                        String na = sc.nextLine();
                        if (!na.isEmpty()) c.setApellidos(na);
                        System.out.print("Nueva Direccion (enter para mantener): ");
                        String nd = sc.nextLine();
                        if (!nd.isEmpty()) c.setDireccion(nd);
                        System.out.print("Nuevo Correo (enter para mantener): ");
                        String nc = sc.nextLine();
                        if (!nc.isEmpty()) c.setCorreo(nc);
                        persistirClientes();
                        System.out.println("Cliente actualizado.");
                    } else if (tipoEd.equals("T") && tecnicos.containsKey(codEd)) {
                        Tecnico t = tecnicos.get(codEd);
                        System.out.print("Nueva Especialidad (enter para mantener): ");
                        String ne = sc.nextLine();
                        if (!ne.isEmpty()) t.setEspecialidad(ne);
                        System.out.print("Nuevo Tiempo de servicio (enter para mantener): ");
                        String nt = sc.nextLine();
                        if (!nt.isEmpty()) {
                            try { t.setTiempoServicio(Integer.parseInt(nt)); } catch(Exception ex){}
                        }
                        persistirTecnicos();
                        System.out.println("Tecnico actualizado.");
                    } else if (tipoEd.equals("V") && vehiculos.containsKey(codEd)) {
                        Vehiculo v = vehiculos.get(codEd);
                        System.out.print("Nuevo Modelo (enter para mantener): ");
                        String nm = sc.nextLine();
                        if (!nm.isEmpty()) v.setModelo(nm);
                        System.out.print("Nuevo Color (enter para mantener): ");
                        String nc2 = sc.nextLine();
                        if (!nc2.isEmpty()) v.setColor(nc2);
                        persistirVehiculos();
                        System.out.println("Vehiculo actualizado.");
                    } else {
                        System.out.println("Código no encontrado para editar.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        // Cierro el scanner al final para liberar recursos
        sc.close();
    }

    // Metodos de Carga y Guardado
    // Los pongo private porque solo se deben usar dentro de Main

    // Metodo para llamar a todos los cargadores de archivos
    private static void inicializarDatos() {
        cargarClientes();
        cargarTecnicos();
        cargarVehiculos();

        //  La asociacion que vehiculo es de que cliente
        // se crea en la Opcion 3. No se guarda/carga en esta
        // version simple de .txt.
    }

    //  Metodos de Guardado

    private static void guardarCliente(Cliente c) {
        // Uso try with resources, el try con parentesis
        // Esto hace que los archivos se cierren solos automaticamente
        try (FileWriter fw = new FileWriter(CLIENTES_FILE, true); // true es para append o sea añadir al final
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            // Escribo una linea en el archivo, separando con ;
            out.println(c.getCodigo() + ";" + c.getNombres() + ";" + c.getApellidos() + ";" + c.getDireccion() + ";" +
                        c.getSexo() + ";" + c.getCorreo() + ";" + c.getCelular() + ";" + c.getTipoCliente());
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static void guardarTecnico(Tecnico t) {
        // Hago lo mismo para guardar tecnicos
        try (FileWriter fw = new FileWriter(TECNICOS_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(t.getCodigo() + ";" + t.getNombres() + ";" + t.getApellidos() + ";" + t.getDireccion() + ";" +
                        t.getSexo() + ";" + t.getCorreo() + ";" + t.getCelular() + ";" + t.getEspecialidad() + ";" + t.getTiempoServicio());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void guardarVehiculo(Vehiculo v) {
        // Y lo mismo para guardar vehiculos
        try (FileWriter fw = new FileWriter(VEHICLOS_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(v.getCodigo() + ";" + v.getPlaca() + ";" + v.getMarca() + ";" + v.getModelo() + ";" + v.getAnio() + ";" + v.getColor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodos de Persistencia que reescriben todo el archivo desde las colecciones actuales
    private static void persistirClientes() {
        try (PrintWriter out = new PrintWriter(new FileWriter(CLIENTES_FILE, false))) {
            for (Cliente c : clientes.values()) {
                out.println(c.getCodigo() + ";" + c.getNombres() + ";" + c.getApellidos() + ";" + c.getDireccion() + ";" +
                            c.getSexo() + ";" + c.getCorreo() + ";" + c.getCelular() + ";" + c.getTipoCliente());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static void persistirTecnicos() {
        try (PrintWriter out = new PrintWriter(new FileWriter(TECNICOS_FILE, false))) {
            for (Tecnico t : tecnicos.values()) {
                out.println(t.getCodigo() + ";" + t.getNombres() + ";" + t.getApellidos() + ";" + t.getDireccion() + ";" +
                            t.getSexo() + ";" + t.getCorreo() + ";" + t.getCelular() + ";" + t.getEspecialidad() + ";" + t.getTiempoServicio());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static void persistirVehiculos() {
        try (PrintWriter out = new PrintWriter(new FileWriter(VEHICLOS_FILE, false))) {
            for (Vehiculo v : vehiculos.values()) {
                out.println(v.getCodigo() + ";" + v.getPlaca() + ";" + v.getMarca() + ";" + v.getModelo() + ";" + v.getAnio() + ";" + v.getColor());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    // Metodos de Carga

    private static void cargarClientes() {
        File file = new File(CLIENTES_FILE);
        // Si el archivo no existe, simplemente no carga nada
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            // Leo el archivo linea por linea hasta el final cuando line es null
            while ((line = br.readLine()) != null) {
                // Separo la linea en un array de strings usando el punto y coma
                String[] data = line.split(";");
                // Si la linea tiene 8 campos, es valida
                if (data.length == 8) {
                    // Creo el objeto
                    Cliente c = new Cliente(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
                    // Lo guardo en el Map usando su codigo como llave
                    clientes.put(c.getCodigo(), c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cargarTecnicos() {
        File file = new File(TECNICOS_FILE);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 9) {
                    // Pongo un try catch por si el numero o sea el tiempo esta mal
                    try {
                        // Convierto el tiempo de servicio data[8] a numero
                        int tiempo = Integer.parseInt(data[8]);
                        Tecnico t = new Tecnico(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], tiempo);
                        tecnicos.put(t.getCodigo(), t);
                    } catch (NumberFormatException nfe) {
                        // Si falla, aviso en consola y sigo con la prox linea
                        System.err.println("Error al leer Tecnico, tiempo invalido: " + data[8]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cargarVehiculos() {
        File file = new File(VEHICLOS_FILE);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 6) {
                    // Tambien reviso que el año data[4] sea un numero
                    try {
                        int anio = Integer.parseInt(data[4]);
                        Vehiculo v = new Vehiculo(data[0], data[1], data[2], data[3], anio, data[5]);
                        vehiculos.put(v.getCodigo(), v);
                    } catch (NumberFormatException nfe) {
                        System.err.println("Error al leer Vehiculo, año invalido: " + data[4]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
