package delivery;

import models.Reporte;
import java.io.FileWriter;

public class EntregaArchivo {
    public void guardar(Reporte reporte, String archivo) {
        try {
            FileWriter writer = new FileWriter(archivo);
            writer.write(reporte.getContenido());
            writer.close();
            System.out.println("[OK] Reporte guardado en " + archivo);
        } catch (Exception e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }
}
