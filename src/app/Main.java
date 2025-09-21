package app;

import view.VistaReporte;

public class Main {
    public static void main(String[] args) {
        VistaReporte vista = VistaReporte.getInstance(); //Singleton
        vista.mostrar();
    }
}
