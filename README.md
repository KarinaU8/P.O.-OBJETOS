Clases del Proyecto

- Persona
  Clase base que representa a una persona con atributos como código, nombres, apellidos, dirección, sexo, correo y celular.  
  Es la clase padre de Cliente y Tecnico.

- Cliente 
  Hereda de Persona y añade el atributo tipoCliente (ejemplo: Particular o Empresa).  
  Representa a los clientes registrados en el sistema.

- Tecnico 
  Hereda de Persona y añade los atributos especialidad y tiempoServicio.  
  Representa al personal encargado de brindar servicios.

- Vehiculo 
  Representa a un vehículo registrado con atributos como código, placa, marca, modelo, año y color.  
  Incluye sobrecarga de constructores, permitiendo crear objetos de diferentes formas.

- Main
  Clase principal que contiene el menú interactivo.  
  Permite registrar y mostrar clientes, técnicos y vehículos en consola.  

 Funcionalidades
- Registrar y mostrar clientes.  
- Registrar y mostrar técnicos.  
- Registrar y mostrar vehículos.  
- Menú interactivo en consola.  
- Datos precargados (2 clientes, 2 técnicos y 2 vehículos). 


