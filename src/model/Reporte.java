package model;

import java.time.LocalDateTime;

public class Reporte {
    private final String titulo;
    private final String contenido;
    private final String destinatario;
    private final LocalDateTime fecha;

    private Reporte(Builder builder) {
        this.titulo = builder.titulo;
        this.contenido = builder.contenido;
        this.destinatario = builder.destinatario;
        this.fecha = builder.fecha;
    }

    public String getTitulo() { return titulo; }
    public String getContenido() { return contenido; }
    public String getDestinatario() { return destinatario; }
    public LocalDateTime getFecha() { return fecha; }

    public static class Builder {
        private String titulo;
        private String contenido;
        private String destinatario;
        private LocalDateTime fecha = LocalDateTime.now();

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder contenido(String contenido) {
            this.contenido = contenido;
            return this;
        }

        public Builder destinatario(String destinatario) {
            this.destinatario = destinatario;
            return this;
        }

        public Builder fecha(LocalDateTime fecha) {
            this.fecha = fecha;
            return this;
        }

        public Reporte build() {
            return new Reporte(this);
        }
    }
}
