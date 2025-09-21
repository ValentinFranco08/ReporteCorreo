package model;

public class EnvioCorreo implements IEnvioStrategy {
    @Override
    public void enviar(Reporte reporte) {
        System.out.println("\n=== Envío por CORREO ===");
        System.out.println("Para: " + reporte.getDestinatario());
        System.out.println("Asunto: " + reporte.getTitulo());
        System.out.println("Contenido:\n" + reporte.getContenido());
    }
}
