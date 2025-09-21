package model;

public class EnvioWhatsApp implements IEnvioStrategy {
    @Override
    public void enviar(Reporte reporte) {
        System.out.println("\n=== Envío por WhatsApp ===");
        System.out.println("Número: " + reporte.getDestinatario());
        System.out.println("Mensaje: " + reporte.getContenido());
    }
}
