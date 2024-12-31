## Wompi API Automatización

### **Introducción**

El objetivo de este proyecto es automatizar las pruebas para garantizar que las transacciones de pago en la plataforma Wompi se realicen de manera satisfactoria. Wompi es una plataforma de pagos que permite a los comercios afiliados realizar transacciones con diversos medios de pago.

Mediante el uso de documentación detallada y datos de prueba proporcionados, se diseñaron escenarios de prueba exitosos y alternos, los cuales fueron implementados utilizando scripts de pruebas funcionales automatizadas para integrar pruebas API.

Este proyecto incluye:

1.  Escenarios de prueba diseñados en formato BDD (Behavior-Driven Development).
2.  Scripts automatizados para pruebas de integración de API, utilizando un método de pago distinto a tarjetas de crédito.
3.  Implementación de una arquitectura basada en un patrón de diseño que soporta la automatización y facilita su mantenimiento.

**Documentación de Wompi:**

-   [Inicio Rápido](https://docs.wompi.co/docs/colombia/inicio-rapido/)
-   [Ambientes y Llaves](https://docs.wompi.co/docs/colombia/ambientes-y-llaves/)

**Datos de prueba:**

-   **URL Host:** `https://api.co.uat.wompi.dev/v1`
-   **Endpoint Token de autenticación:** `https://api.co.uat.wompi.dev/v1/merchants/`
-   **Llaves:**
    -   `pub_stagtest_g2u0HQd3ZMh05hsSgTS2lUV8t3s4mOt7`
    -   `prv_stagtest_5i0ZGIGiFcDQifYsXxvsny7Y37tKqFWg`
    -   `stagtest_events_2PDUmhMywUkvb1LvxYnayFbmofT7w39N`
    -   `stagtest_integrity_nAIBuqayW70XpUqJS4qf4STYiISd89Fp`

----------

### **Tecnologías utilizadas**

-   **Lenguaje:** Java
-   **Framework de pruebas:** TestNG
-   **Gestión de escenarios:** Cucumber (BDD)
-   **Cliente HTTP:** io.rest-assured
-   **Gestión de variables de entorno:** Archivos `.env`
-   **Reporte de resultados:** Allure report

----------

### **Estructura del Proyecto**

La estructura del proyecto está organizada para facilitar el desarrollo, mantenimiento y ejecución de pruebas automatizadas. A continuación, se detalla cada carpeta y archivo relevante:

```plaintext
wompi-api-automatizacion/
├── .allure/                       # Archivos generados para reportes de Allure.
├── .idea/                         # Configuración del proyecto en el IDE (IntelliJ IDEA).
├── src/                           # Código fuente del proyecto.
│   ├── main/                      # Código principal.
│   │   ├── java/org/example/      # Directorio con clases Java de la API Wompi.
│   │   │   ├── pages/             # Clases relacionadas con la lógica específica de la API Wompi.
│   │   │   │   └── ApiWompiPage.java
│   │   │   ├── utils/             # Clases utilitarias para soporte en las pruebas.
│   │   │   │   ├── ConfiguracionAmbiente.java
│   │   │   │   ├── ExtraerCamposHelper.java
│   │   │   │   ├── GenerarData.java
│   │   │   │   ├── GenerarPayloads.java
│   │   │   │   └── VariablesGlobales.java
│   │   └── resources/             # Archivos de configuración y propiedades del proyecto.
│   │       ├── .env               # Variables de entorno (llaves, URLs, etc.).
│   │       ├── allure.properties   # Configuración para reportes de Allure.
│   │       └── cucumber.properties # Configuración para la ejecución de escenarios BDD.
├── test/                          # Directorio para las pruebas.
│   ├── java/                      # Clases de pruebas Java.
│   │   ├── features/              # Archivos .feature con los escenarios BDD.
│   │   │   ├── e2e/               # Escenarios de pruebas End-to-End.
│   │   │   │   └── HU_RealizarTransaccionBancolombiaQRYVerificarEstado.feature
│   │   │   ├── integracion/       # Escenarios de pruebas de integración.
│   │   │   │   ├── sprint1/       # Sprint 1.
│   │   │   │   │   └── HU_APIObtenerInformacionComercio.feature
│   │   │   │   ├── sprint2/       # Sprint 2.
│   │   │   │   │   └── HU_APIObtenerInformacionDeAutenticacionYTokens.feature
│   │   │   │   └── sprint3/       # Sprint 3.
│   │   │   │       └── HU_APIObtenerEstadoDeUnaTransaccion.feature
│   ├── runners/                   # Clases Java que ejecutan las pruebas BDD.
│   │   ├── e2e/                   # Runners para pruebas End-to-End.
│   │   │   └── HU_RealizarTransaccionBancolombiaQRYVerificarEstadoSteps.java
│   │   ├── integracion/           # Runners para pruebas de integración.
│   │   │   ├── sprint1/           # Sprint 1.
│   │   │   │   └── HU_APIObtenerInformacionComercioSteps.java
│   │   │   ├── sprint2/           # Sprint 2.
│   │   │   │   └── HU_APIObtenerInformacionDeAutenticacionYTokensSteps.java
│   │   │   └── sprint3/           # Sprint 3.
│   │   │       └── HU_APIObtenerEstadoDeUnaTransaccionSteps.java
```

----------

### **Ejecución de Pruebas**

En el archivo `pom.xml` se han configurado perfiles para ejecutar pruebas de manera específica desde la consola. Estos perfiles permiten ejecutar suites o subconjuntos de pruebas, según sea necesario.

Los perfiles disponibles son:

-   **`all-tests`**: Ejecuta todas las pruebas del proyecto.
-   **`rutas-tristes`**: Ejecuta únicamente los escenarios que cubren casos alternos o de manejo de errores.
-   **`sprint1`**: Ejecuta las pruebas relacionadas con el Sprint 1.
-   **`sprint2`**: Ejecuta las pruebas relacionadas con el Sprint 2.
-   **`sprint3`**: Ejecuta las pruebas relacionadas con el Sprint 3.

**Comandos de ejecución:**
- Ejecutar todas las pruebas
  mvn clean test -P all-tests

- Ejecutar pruebas de rutas tristes
  mvn clean test -P rutas-tristes

- Ejecutar pruebas de un sprint específico
  mvn clean test -P sprint1
  mvn clean test -P sprint2
  mvn clean test -P sprint3

- Ejecutar todas las pruebas y generar reporte Allure
  mvn clean test -P all-tests; mvn allure:report; allure serve target/allure-results

----------

### Estrategias de Pruebas

Las estrategias de pruebas están diseñadas para validar la funcionalidad de las APIs de Wompi en diferentes escenarios, abarcando rutas felices y tristes para garantizar la estabilidad y fiabilidad del servicio. Estas pruebas se dividen en pruebas end-to-end (E2E) y de integración, distribuidas por funcionalidades específicas:

#### Pruebas End-to-End (E2E)

1.  **HU_RealizarTransaccionBancolombiaQRYVerificarEstado.feature**
    -   **Objetivo:** Validar el flujo completo de transacciones con Bancolombia QR, desde la obtención de información del comercio hasta la verificación del estado de la transacción.
    -   **Escenarios:**
        -   Obtener información del comercio exitosamente.
        -   Realizar petición con llave pública correcta para obtener tokens de aceptación.
        -   Realizar transacción con el método de pago Bancolombia QR.
        -   Verificar el estado de la transacción realizada con Bancolombia QR.

#### Pruebas de Integración

1.  **HU_APIObtenerInformacionComercio.feature**

    -   **Objetivo:** Validar la estabilidad del servicio y persistencia de datos al obtener información del comercio.
    -   **Escenarios:**
        -   Petición a la API con una llave privada incorrecta.
        -   Petición a la API sin incluir headers.
2.  **HU_APIObtenerInformacionDeAutenticacionYTokens.feature**

    -   **Objetivo:** Verificar la funcionalidad de la API de autenticación y tokens.
    -   **Escenarios:**
        -   Petición con una llave pública incorrecta.
        -   Petición sin incluir la llave pública.
        -   Petición con una llave pública en formato erróneo.
3.  **HU_APIObtenerEstadoDeUnaTransaccion.feature**

    -   **Objetivo:** Validar la funcionalidad de la API encargada de mostrar el estado de una transacción.
    -   **Escenarios:**
        -   Petición con un ID de transacción incorrecto.
        -   Petición con un ID de transacción vacío.

Cada archivo `.feature` incluye escenarios etiquetados para facilitar su organización y ejecución en suites de pruebas automatizadas. Las etiquetas utilizadas permiten diferenciar las rutas felices (`@ruta-feliz`) de las rutas tristes (`@ruta-triste`) y agrupar las pruebas por tipo (`@e2e`, `@integracion`) y sprint (`@sprint1`, `@sprint2`, `@sprint3`).

----------

## Hecho por

Este proyecto fue desarrollado por [Nicolas Ortiz](https://www.linkedin.com/in/ortiznicolas/).

### Datos de contacto:
- **LinkedIn**: [https://www.linkedin.com/in/ortiznicolas/](https://www.linkedin.com/in/ortiznicolas/)
- **Correo**: vinico0911@hotmail.com
- **Celular**: +573215105973
