package service;

import model.Reporte;

public class GeneradorContenido {
    private static GeneradorContenido instance;

    private GeneradorContenido() {}

    public static GeneradorContenido getInstance() {
        if (instance == null) {
            instance = new GeneradorContenido();
        }
        return instance;
    }

    public Reporte crearReporte(String titulo, String contenido, String destinatario) {
        return new Reporte.Builder()
                .titulo(titulo)
                .contenido(contenido)
                .destinatario(destinatario)
                .build();
    }
}
