Feature: Realizar pruebas de integración con la API de autenticación y tokens
  
    Como usuario que usa el servicio de obtención de token y autenticación
    Quiero realizar pruebas de integración con la API de autenticación y tokens
    Para verificar la funcionalidad de la API y la persistencia de datos

  @ruta-triste @integracion @sprint2
    Scenario: Petición a la API de autenticación con una llave publica errónea
        Given que envío una petición GET a la API de autenticación al endpoint "merchants/" con la llave publica incorrecta
        When la API de autenticación responde con un código de estado 404
        Then el campo tipo "type" en la respuesta de la autenticación debe ser "NOT_FOUND_ERROR"
        Then el campo razon "reason" en la respuesta de la autenticación debe ser "La entidad solicitada no existe"

  @ruta-triste @integracion @sprint2
    Scenario: Petición a la API de autenticación sin la llave publica
        Given que envío una petición GET a la API de autenticación al endpoint "merchants/" sin la llave publica
        When la API de autenticación responde con un código de estado 401
        Then el campo tipo "type" en la respuesta de la autenticación debe ser "INVALID_ACCESS_TOKEN"
        Then el campo razon "reason" en la respuesta de la autenticación debe ser "Se esperaba una llave pública o privada pero no se recibió ninguna"

    @ruta-triste @integracion @sprint2
      Scenario: Petición a la API con autenticación con una llave publica con formato erróneo
            Given que envío una petición GET a la API de autenticación al endpoint "merchants/" con la llave publica con formato erróneo
            When la API de autenticación responde con un código de estado 422
            Then el campo tipo "type" en la respuesta de la autenticación debe ser "INPUT_VALIDATION_ERROR"
            Then el campo mensaje "public_key" en la respuesta de la autenticación debe ser "Formato inválido"
