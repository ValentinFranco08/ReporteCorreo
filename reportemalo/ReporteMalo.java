package reportemalo;

import java.io.FileWriter;

public class ReporteMalo {
    public void generarYEnviar() {
        //  Responsabilidad 1: Generar datos del reporte
        String datos = "Este es un reporte malo de prueba";

        // Responsabilidad 2: Dar formato al contenido
        String contenido = "===== REPORTE =====\n" + datos;

        //  Responsabilidad 3: Guardar el archivo en disco
        try {
            FileWriter writer = new FileWriter("reporte.txt");
            writer.write(contenido);
            writer.close();
            System.out.println("[OK] Reporte guardado en reporte.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //  Responsabilidad 4: Enviar el reporte por correo
        System.out.println("\n===== Envío por CORREO (simulado) =====");
        System.out.println("De: sistema@reportes.com");
        System.out.println("Para: usuario@correo.com");
        System.out.println("Asunto: Reporte generado");
        System.out.println("Contenido:\n" + contenido);
        System.out.println(">>> Correo enviado correctamente. <<<");
    }
}
