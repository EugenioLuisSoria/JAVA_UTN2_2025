package cine.persistencia;

import cine.modelo.Cine;
import java.io.*;

public class PersistenciaDatos {

    private static final String ARCHIVO = "cine.ser";

    public static void guardar(Cine cine) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(cine);
        } catch (IOException e) {
            System.out.println("ERROR GUARDANDO DATOS: " + e.getMessage());
        }
    }

    public static Cine cargar() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            return new Cine();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (Cine) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR CARGANDO DATOS: " + e.getMessage());
            return new Cine();
        }
    }
}
