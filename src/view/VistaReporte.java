package view;

import controller.ReporteController;
import models.*;

public class VistaReporte {
    public void mostrar() {
        String texto = "Este es un reporte de prueba generado en Java con Strategy (solo email).";
        String archivo = "reporte.txt";
        String destinatario = "usuario@correo.com";

        try {
            Reporte reporte = new Reporte(texto, archivo);
            reporte.generar();

            ReporteController controller = new ReporteController();

            // Usamos solo la estrategia de correo
            controller.setEstrategia(new EnvioCorreo());
            controller.enviarReporte(reporte, destinatario);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
