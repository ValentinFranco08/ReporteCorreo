package controller;

import models.Reporte;
import models.IMetodoEnvioStrategy;

public class ReporteController {
    private IMetodoEnvioStrategy estrategia;

    public void setEstrategia(IMetodoEnvioStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public void enviarReporte(Reporte reporte, String destinatario) {
        if (estrategia == null) {
            System.out.println("[ERROR] No se definió una estrategia de envío.");
            return;
        }
        estrategia.enviar(reporte, destinatario);
    }
}
