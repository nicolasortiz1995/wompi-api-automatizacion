Feature: Realizar pruebas de integración con la API de información del comercio

    Como usuario que desea obtener información de un comercio
    Quiero realizar una peticiones a la API de información del comercio
    Para obtener confirmar la estabilidad del servicio y persistencia de datos

  @ruta-triste @integracion @sprint1
    Scenario: Petición a la API de información del comercio con una llave privada errónea
        Given que envío una petición GET a la API de información del comercio al endpoint "merchants/" con la llave privada incorrecta
        When la API responde con un código de estado 401
        Then el campo tipo "type" en la respuesta debe ser "INVALID_ACCESS_TOKEN"
        Then el campo razon "reason" en la respuesta debe ser "Llave no válida"

  @ruta-triste @integracion
    Scenario: Peticion a la API de información del comercio sin headers
        Given que envío una petición GET a la API de información del comercio al endpoint "merchants/" sin headers
        When la API responde con un código de estado 401
        Then el campo tipo "type" en la respuesta debe ser "INVALID_ACCESS_TOKEN"
        Then el campo razon "reason" en la respuesta debe ser "Se esperaba una llave pública o privada pero no se recibió ninguna"