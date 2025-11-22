package gestorAplicacion.Cuenta;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class SerializadorUsuario {

    public static void guardar(Usuario usuario) {
        try {
            XMLEncoder encoder = new XMLEncoder(new FileOutputStream("usuario.xml"));
            encoder.writeObject(usuario);
            encoder.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Usuario cargar() {
        try {
            XMLDecoder decoder = new XMLDecoder(new FileInputStream("usuario.xml"));
            Usuario usuario = (Usuario) decoder.readObject();
            decoder.close();
            return usuario;
        } catch (Exception e) {
            return null;
        }
    }
}
