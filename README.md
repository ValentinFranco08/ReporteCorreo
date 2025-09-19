# 📄 Proyecto: Generador y Envío de Reportes (con Strategy)

Este proyecto en **Java** muestra cómo generar un reporte a partir de un texto, guardarlo en un archivo y enviarlo mediante una estrategia de envío. Actualmente incluye solo la estrategia de **correo electrónico (simulada en consola)**, pero gracias al patrón **Strategy** es muy fácil extenderlo.

---

## 📂 Estructura del proyecto

```
src/
 ├─ Main.java                      # Punto de entrada de la aplicación
 ├─ controller/
 │    └─ ReporteController.java    # Coordina el modelo y la estrategia de envío
 ├─ models/
 │    ├─ Reporte.java              # Representa el reporte y lo guarda en archivo
 │    ├─ IMetodoEnvioStrategy.java # Interfaz para las estrategias de envío
 │    └─ EnvioCorreo.java          # Estrategia concreta: envío por correo (simulado)
 └─ view/
      └─ VistaReporte.java         # Vista que orquesta la generación y envío
```

---

## 🧩 Componentes

* **Main.java** → arranca el programa.
* **controller/ReporteController.java** → recibe la estrategia de envío y coordina el proceso.
* **models/Reporte.java** → modelo del reporte, genera el archivo.
* **models/IMetodoEnvioStrategy.java** → interfaz que define cómo debe ser una estrategia de envío.
* **models/EnvioCorreo.java** → implementación concreta para enviar por correo.
* **view/VistaReporte.java** → vista que crea el reporte, define la estrategia y la ejecuta.

---

## 📐 Diagrama UML (ASCII)

```
+------------------+
|     Reporte      |
+------------------+
| - contenido      |
| - archivo        |
+------------------+
| +generar()       |
| +getArchivo()    |
+------------------+

+---------------------------+
| IMetodoEnvioStrategy      |<<interface>>
+---------------------------+
| +enviar(Reporte,String)   |
+---------------------------+
            ^
            |
+------------------+
|   EnvioCorreo    |
+------------------+
| +enviar(...)     |
+------------------+

+---------------------------+
| ReporteController         |
+---------------------------+
| - estrategia              |
+---------------------------+
| +setEstrategia(...)       |
| +enviarReporte(...)       |
+---------------------------+

+---------------------------+
| VistaReporte              |
+---------------------------+
| +mostrar()                |
+---------------------------+

+---------+
|  Main   |
+---------+
| +main() |
+---------+
```

---

## ▶️ Ejecución

1. Compilar los archivos:

   ```bash
   javac src/**/*.java src/*.java
   ```

2. Ejecutar el programa:

   ```bash
   java -cp src Main
   ```

---

## 📌 Ejemplo de salida

```
[OK] Reporte guardado en reporte.txt

===== Envío por CORREO (simulado) =====
De: sistema@cotizador.com
Para: usuario@correo.com
Asunto: Reporte generado
Adjunto: reporte.txt
>>> Correo enviado correctamente. <<<
```

---

## 🚀 Extensión futura

Para agregar nuevos métodos de envío (WhatsApp, Notificación, etc.), basta con crear otra clase que implemente `IMetodoEnvioStrategy`.
De este modo, el sistema cumple el **Principio Abierto/Cerrado (OCP)**: abierto a la extensión, cerrado a la modificación.
