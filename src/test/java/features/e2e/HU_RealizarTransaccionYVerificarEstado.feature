Feature: Realizar transacciones con la API de Wompi y verificar estado

  @rutaFeliz @e2e
  Scenario: Obtener la información del comercio exitosamente
    Given que envío una petición GET a la API de Wompi al endpoint "merchants/"
    When la API responde exitosamente con un código de estado 200 o 201
    Then el campo "public_key" en la respuesta no debe estar vacío
    Then obtengo la llave de integridad "INTEGRITY"

  @rutaFeliz @e2e
  Scenario: Realizar petición con llave pública correcta para obtener tokens de aceptación
    Given que realizo una petición al endpoint "merchants/" con la llave pública correcta
    When la API responde exitosamente con un código de estado 200 o 201
    Then los campos de "acceptance_token" en la respuesta no debe estar vacío

  @rutaFeliz @e2e
  Scenario: Relizar transacción con método de pago: Bancolombia QR
    Given que envio una petición POST a la API de Wompi al endpoint "transactions/" con el metodo de pago "Bancolombia QR" y sandbox_status "APPROVED"
    When la API responde exitosamente con un código de estado 200 o 201
    Then los campos "id" y "created_at" en la respuesta no debe estar vacío

  @rutaFeliz @e2e
  Scenario: Verificar el estado de la transacción realizada con método de pago: Bancolombia QR
    Given que envío una petición GET a la API de Wompi al endpoint "transactions/" con el id de la transacción
    When la API responde exitosamente con un código de estado 200 o 201
    Then el campo "sandbox_status" en el payment_method de la respuesta debe ser "APPROVED"
    Then el campo "type" en el payment_method de la respuesta debe ser "BANCOLOMBIA_QR"
    Then el campo "payment_description" en el payment_method de la respuesta debe ser el enviado en la petición
    Then el campo "amount_in_cents" en la respuesta debe ser el enviado en la petición
    Then el campo "reference" en la respuesta debe ser la enviada en la petición
    Then el campo "currency" en la respuesta debe ser "COP"
    Then el campo "payment_method_type" en la respuesta debe ser "BANCOLOMBIA_QR"


