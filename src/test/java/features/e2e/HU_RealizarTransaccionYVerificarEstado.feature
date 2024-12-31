Feature: Realizar transacciones con la API de Wompi y verificar estado

  @rutaFeliz @e2e
  Scenario: Obtener la información del comercio exitosamente
    Given que envío una petición GET a la API de Wompi al endpoint "merchants/"
    When la API responde exitosamente con un código de estado 200
    Then el campo "public_key" en la respuesta no debe estar vacío
    Then obtengo la llave de integridad "INTEGRITY"

  @rutaFeliz @e2e
  Scenario: Realizar petición con llave pública correcta para obtener tokens de aceptación
    Given que realizo una petición al endpoint "merchants/" con la llave pública correcta
    When la API responde exitosamente con un código de estado 200
    Then los campos de "acceptance_token" en la respuesta no debe estar vacío

  @rutaFeliz @e2e
  Scenario: Relizar transacción con método de pago: Bancolombia QR
    Given que envio una petición POST a la API de Wompi al endpoint "transactions/" con el metodo de pago "Bancolombia QR" y sandbox_status "APPROVED"
    When la API responde exitosamente con un código de estado 200
    Then los campos "id" y "created_at" en la respuesta no debe estar vacío
