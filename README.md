# 📄 Proyecto: ReporteCorreo

Este proyecto en Java implementa un sistema de generación y envío de reportes aplicando principios de **POO** y patrones de diseño como **MVC, Strategy, Singleton y Builder**.

---

## 🎯 Objetivos

* Cumplir con el **Principio de Responsabilidad Única (SRP)**: cada clase tiene una sola responsabilidad.
* Organizar el sistema en una arquitectura **MVC** clara.
* Aplicar patrones de diseño creacionales y de comportamiento: **Singleton**, **Builder** y **Strategy**.
* Usar nombres consistentes (clases en PascalCase, variables en camelCase, paquetes en minúscula).

---

## 📂 Estructura del Proyecto

```
src/
 ├─ app/
 │   └─ Main.java                  # Punto de entrada
 │
 ├─ controller/
 │   └─ ReporteController.java     # Coordina la lógica (Singleton + Strategy)
 │
 ├─ model/
 │   ├─ Reporte.java               # Entidad Reporte (Builder)
 │   ├─ IEnvioStrategy.java        # Interfaz Strategy
 │   ├─ EnvioCorreo.java           # Estrategia concreta: envío por correo
 │   └─ EnvioWhatsApp.java         # Estrategia concreta: envío por WhatsApp
 │
 ├─ service/
 │   ├─ GeneradorContenido.java    # Construcción de Reportes (Singleton)
 │   └─ EntregaArchivo.java        # Guardado en archivo (Singleton)
 │
 └─ view/
     └─ VistaReporte.java          # Simula interacción con usuario (Singleton)
```

---

## 🧩 Patrones de Diseño Aplicados

### 1. **MVC**

* **Model**: `Reporte` (con Builder), estrategias de envío (`EnvioCorreo`, `EnvioWhatsApp`).
* **View**: `VistaReporte` (simula interacción con el usuario).
* **Controller**: `ReporteController` (coordina el envío, usa Strategy).

### 2. **Strategy**

* Interfaz `IEnvioStrategy` define el contrato de envío.
* Clases concretas (`EnvioCorreo`, `EnvioWhatsApp`) implementan distintos comportamientos.

### 3. **Singleton (Lazy Initialization)**

* `VistaReporte`, `ReporteController`, `GeneradorContenido` y `EntregaArchivo` son instancias únicas.
* Antes de crear, verifican si ya existe en memoria (`if (instance == null)`).

### 4. **Builder**

* Clase `Reporte` usa un **Builder interno** para construir objetos con parámetros opcionales (título, contenido, destinatario, fecha).
* Evita constructores telescópicos y mejora la legibilidad.

---

## 🔎 Responsabilidad Única (SRP)

* **Reporte** → Representa los datos del reporte.
* **IEnvioStrategy** → Contrato de envío.
* **EnvioCorreo / EnvioWhatsApp** → Implementan un envío específico.
* **GeneradorContenido** → Construye reportes con Builder.
* **EntregaArchivo** → Guarda el reporte en archivo.
* **ReporteController** → Coordina y ejecuta la estrategia de envío.
* **VistaReporte** → Simula la vista de usuario.
* **Main** → Punto de entrada.

Cada clase tiene **una sola razón de cambio**, cumpliendo con SRP.

---

## ▶️ Ejemplo de Ejecución

```bash
javac -d out $(find src -name "*.java")
java -cp out app.Main
```

### Salida esperada:

```
[OK] Reporte guardado en reporte.txt

=== Envío por CORREO ===
Para: usuario@correo.com
Asunto: Reporte Mensual
Contenido:
Este es el contenido del reporte mensual.

=== Envío por WhatsApp ===
Número: usuario@correo.com
Mensaje: Este es el contenido del reporte mensual.
```

---

## 📐 UML Simplificado

```
VistaReporte <<Singleton>>
      |
      v
ReporteController <<Singleton>> -- IEnvioStrategy <<interface>>
      |                                ^
      |                                |
      v                                v
GeneradorContenido <<Singleton>>   EnvioCorreo / EnvioWhatsApp
      |
      v
EntregaArchivo <<Singleton>>
      |
      v
   Reporte <<Builder>>
```

---

## ✅ Conclusión

El proyecto **ReporteCorreo** cumple con:

* Arquitectura **MVC**.
* Patrones de diseño: **Strategy, Singleton, Builder**.
* Principios de **POO y SRP**.
* Código organizado, extensible y mantenible.
