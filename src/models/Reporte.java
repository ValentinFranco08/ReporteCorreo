package models;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Reporte {
    private String contenido;
    private String archivo;

    public Reporte(String contenido, String archivo) {
        this.contenido = contenido;
        this.archivo = archivo;
    }

    public void generar() throws IOException {
        String data = "===== REPORTE =====\n" +
                      "Fecha: " + LocalDateTime.now() + "\n\n" +
                      contenido + "\n";

        FileWriter writer = new FileWriter(archivo);
        writer.write(data);
        writer.close();
        System.out.println("[OK] Reporte guardado en " + archivo);
    }

    public String getArchivo() {
        return archivo;
    }
}
