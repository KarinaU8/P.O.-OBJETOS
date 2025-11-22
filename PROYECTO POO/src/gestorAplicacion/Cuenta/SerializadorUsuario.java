package gestorAplicacion.Cuenta;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// Esta clase la uso solo para guardar y cargar un Usuario en un archivo XML
public class SerializadorUsuario {

    // Este método guarda un objeto Usuario en un archivo XML.
    // Lo llamo cuando quiero que el usuario quede "guardado" de forma permanente.
    public static void guardar(Usuario usuario) {
        try {
            // XMLEncoder convierte el objeto en formato XML y lo escribe en un archivo.
            XMLEncoder encoder = new XMLEncoder(new FileOutputStream("usuario.xml"));
            
            // Aquí escribo el objeto completo.
            encoder.writeObject(usuario);
            
            // Cierro para que se termine de escribir bien el archivo.
            encoder.close();
        } catch (Exception e) {
            // Si algo sale mal simplemente imprimo el error.
            e.printStackTrace();
        }
    }

    // Este método lee el archivo XML y reconstruye un Usuario.
    // Lo uso cuando quiero recuperar el usuario guardado anteriormente.
    public static Usuario cargar() {
        try {
            // XMLDecoder hace lo contrario: toma el archivo XML y lo transforma en un objeto.
            XMLDecoder decoder = new XMLDecoder(new FileInputStream("usuario.xml"));
            
            // Leo el objeto y lo guardo en una variable.
            Usuario usuario = (Usuario) decoder.readObject();
            
            decoder.close();
            return usuario;
        } catch (Exception e) {
            // Si el archivo no existe o está vacío, simplemente regreso null.
            return null;
        }
    }
}
