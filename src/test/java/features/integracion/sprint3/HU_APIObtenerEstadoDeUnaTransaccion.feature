Feature: Realizar pruebas de integración con la API encargada de mostrar el estado de una transacción

      Como usuario que usa el servicio de obtención de estado de una transacción
      Quiero realizar pruebas de integración con la API encargada de mostrar el estado de una transacción
      Para verificar la funcionalidad de la API y la persistencia de datos

  @ruta-triste @integracion @sprint3
    Scenario: Petición a la API de estado de una transacción con un id de transacción incorrecto
        Given que envío una petición GET a la API de estado de una transacción al endpoint "transactions/" con el id de transacción incorrecto
        When la API de estado de una transacción responde con un código de estado 404
        Then el campo tipo "type" en la respuesta de la transacción debe ser "NOT_FOUND_ERROR"
        Then el campo razon "reason" en la respuesta de la transacción debe ser "La entidad solicitada no existe"

  @ruta-triste @integracion @sprint3
    Scenario: Peticion a la API de estado de una transacción con un id vacío
        Given que envío una petición GET a la API de estado de una transacción al endpoint "transactions/" con el id de transacción vacío
        When la API de estado de una transacción responde con un código de estado 401
        Then el campo tipo "type" en la respuesta de la transacción debe ser "INVALID_ACCESS_TOKEN"
        Then el campo razon "reason" en la respuesta de la transacción debe ser "Se esperaba una llave pública o privada pero no se recibió ninguna"