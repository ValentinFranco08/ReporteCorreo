package models;

public class EnvioCorreo implements IMetodoEnvioStrategy {
    @Override
    public void enviar(Reporte reporte, String destinatario) {
        System.out.println("\n===== Envío por CORREO (simulado) =====");
        System.out.println("De: sistema@reportes.com");
        System.out.println("Para: " + destinatario);
        System.out.println("Asunto: Reporte generado");
        System.out.println("Contenido:\n" + reporte.getContenido());
        System.out.println(">>> Correo enviado correctamente. <<<");
    }
}
