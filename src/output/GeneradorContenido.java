package output;

import models.Reporte;

public class GeneradorContenido {
    public Reporte generarTexto(String datos) {
        String contenido = "===== REPORTE =====\n" + datos;
        return new Reporte(contenido);
    }
}
