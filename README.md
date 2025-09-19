# 📄 Proyecto: ReporteCorreo (Ejemplo de Violación al SRP)

Este documento muestra un **ejemplo inicial de una clase `Reporte` que viola el Principio de Responsabilidad Única (SRP)** de SOLID. Está comentado para ilustrar los problemas de diseño y los múltiples motivos de cambio que acumula.

---

## 🚨 Clase que viola el SRP

```java
package models;

import java.io.FileWriter;

public class Reporte {
    public void generarYEnviar() {
        // 🚨 Responsabilidad 1: Obtener datos
        String datos = "Este es un reporte de prueba";

        // 🚨 Responsabilidad 2: Generar contenido
        String contenido = "===== REPORTE =====\n" + datos;

        // 🚨 Responsabilidad 3: Guardar en archivo
        try {
            FileWriter writer = new FileWriter("reporte.txt");
            writer.write(contenido);
            writer.close();
            System.out.println("[OK] Reporte guardado en reporte.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 🚨 Responsabilidad 4: Enviar por correo (simulado)
        System.out.println("\n===== Envío por CORREO (simulado) =====");
        System.out.println("De: sistema@reportes.com");
        System.out.println("Para: usuario@correo.com");
        System.out.println("Asunto: Reporte generado");
        System.out.println("Contenido:\n" + contenido);
        System.out.println(">>> Correo enviado correctamente. <<<");
    }
}
```

---

## 🔎 Análisis de la violación

La clase `Reporte` tiene **múltiples responsabilidades**:

1. **Obtener datos** (texto hardcodeado).
2. **Generar contenido** (formato del reporte).
3. **Guardar en archivo** (persistencia en disco con `FileWriter`).
4. **Enviar reporte** (simulación de correo).

### ➡️ Problema

Cada una de estas responsabilidades es un **motivo de cambio distinto**:

* Si cambian los datos de entrada (de lista fija a BD o API).
* Si cambia el formato de salida (texto a JSON/HTML).
* Si cambia el mecanismo de almacenamiento (archivo → nube).
* Si cambia el medio de entrega (correo → WhatsApp/Notificación).

👉 Esto rompe el SRP porque cualquier cambio obliga a modificar la misma clase, aumentando el acoplamiento y dificultando la mantenibilidad.

---

## ✅ Conclusión

Este ejemplo sirve para **ilustrar cómo NO diseñar una clase**. La solución correcta consiste en separar las responsabilidades en diferentes clases:

* `GeneradorContenido` → generación de formato.
* `EntregaArchivo` → guardar el archivo.
* `EnvioCorreo` (Strategy) → envío del reporte.
* `Reporte` → solo almacenar datos.
* `ReporteController` → coordinar estrategias.

De esta manera, cada clase tiene una sola razón de cambio y se cumple el principio SRP de SOLID.

