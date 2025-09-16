package models;

public class EnvioCorreo implements IMetodoEnvioStrategy {
    @Override
    public void enviar(Reporte reporte, String destinatario) {
        System.out.println("\n===== Envío por CORREO (simulado) =====");
        System.out.println("De: sistema@cotizador.com");
        System.out.println("Para: " + destinatario);
        System.out.println("Asunto: Reporte generado");
        System.out.println("Adjunto: " + reporte.getArchivo());
        System.out.println(">>> Correo enviado correctamente. <<<");
    }
}
