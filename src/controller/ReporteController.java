package controller;

import model.Reporte;
import model.IEnvioStrategy;

public class ReporteController {
    private static ReporteController instance;
    private IEnvioStrategy estrategia;

    private ReporteController() {}

    public static ReporteController getInstance() {
        if (instance == null) {
            instance = new ReporteController();
        }
        return instance;
    }

    public void setEstrategia(IEnvioStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public void enviarReporte(Reporte reporte) {
        if (estrategia != null) {
            estrategia.enviar(reporte);
        } else {
            System.out.println("[ERROR] No se definió estrategia de envío.");
        }
    }
}
