package service;

import model.Reporte;
import java.io.FileWriter;

public class EntregaArchivo {
    private static EntregaArchivo instance;

    private EntregaArchivo() {}

    public static EntregaArchivo getInstance() {
        if (instance == null) {
            instance = new EntregaArchivo();
        }
        return instance;
    }

    public void guardar(Reporte reporte, String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write(reporte.getContenido());
            System.out.println("[OK] Reporte guardado en " + archivo);
        } catch (Exception e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }
}
