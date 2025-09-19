import output.GeneradorContenido;
import delivery.EntregaArchivo;
import models.Reporte;
import models.EnvioCorreo;
import controller.ReporteController;

public class Main {
    public static void main(String[] args) {
        // Datos simulados
        String datos = "Este es un reporte con datos importantes para el sistema.";

        // 1. Generar contenido
        GeneradorContenido generador = new GeneradorContenido();
        Reporte reporte = generador.generarTexto(datos);

        // 2. Guardar en archivo
        EntregaArchivo entrega = new EntregaArchivo();
        entrega.guardar(reporte, "reporte.txt");

        // 3. Enviar por correo
        ReporteController controller = new ReporteController();
        controller.setEstrategia(new EnvioCorreo());
        controller.enviarReporte(reporte, "usuario@correo.com");
    }
}
