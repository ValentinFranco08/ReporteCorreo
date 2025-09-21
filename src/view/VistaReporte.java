package view;

import service.GeneradorContenido;
import service.EntregaArchivo;
import controller.ReporteController;
import model.Reporte;
import model.EnvioCorreo;
import model.EnvioWhatsApp;

public class VistaReporte {
    private static VistaReporte instance;

    private VistaReporte() {}

    public static VistaReporte getInstance() {
        if (instance == null) {
            instance = new VistaReporte();
        }
        return instance;
    }

    public void mostrar() {
        // Generar un reporte con Builder
        Reporte reporte = GeneradorContenido.getInstance()
                .crearReporte("Reporte Mensual",
                        "Este es el contenido del reporte mensual.",
                        "usuario@correo.com");

        // Guardar archivo
        EntregaArchivo.getInstance().guardar(reporte, "reporte.txt");

        // Enviar por correo
        ReporteController controller = ReporteController.getInstance();
        controller.setEstrategia(new EnvioCorreo());
        controller.enviarReporte(reporte);

        // Enviar por WhatsApp
        controller.setEstrategia(new EnvioWhatsApp());
        controller.enviarReporte(reporte);
    }
}
