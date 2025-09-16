package models;

public interface IMetodoEnvioStrategy {
    void enviar(Reporte reporte, String destinatario);
}
