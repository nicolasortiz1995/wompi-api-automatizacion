package org.example.utils;

import io.restassured.response.Response;

public class ExtraerCamposHelper {

    /**
     * Extrae la llave pública de la respuesta.
     * @param response La respuesta de la API.
     * @param atributo El nombre del atributo a extraer.
     * @return El valor de la llave pública.
     */
    public String extraerLlavePublica(Response response, String atributo) {
        return response.jsonPath().getString("data[0]." + atributo);
    }

    /**
     * Extrae la llave de integridad de la respuesta.
     * @param response La respuesta de la API.
     * @param atributo El nombre del atributo a extraer.
     * @return El valor de la llave de integridad.
     */
    public String extraerLlaveIntegridad(Response response, String atributo) {
        return response.jsonPath().getString("data[0].secrets." + atributo);
    }

    /**
     * Extrae la aceptación prefirmada de la respuesta.
     * @param response La respuesta de la API.
     * @param atributo El nombre del atributo a extraer.
     * @return El valor de la aceptación prefirmada.
     */
    public String extraerAceptacionPrefirmada(Response response, String atributo) {
        return response.jsonPath().getString("data.presigned_acceptance." + atributo);
    }

    /**
     * Extrae el prefirmado personal de la respuesta.
     * @param response La respuesta de la API.
     * @param atributo El nombre del atributo a extraer.
     * @return El valor del prefirmado personal.
     */
    public String extraerPrefirmadoPersonal(Response response, String atributo) {
        return response.jsonPath().getString("data.presigned_personal_data_auth." + atributo);
    }

    /**
     * Extrae datos de la transacción de la respuesta.
     * @param response La respuesta de la API.
     * @param atributo El nombre del atributo a extraer.
     * @return El valor de los datos de la transacción.
     */
    public String extraerDatosTransaccion(Response response, String atributo) {
        return response.jsonPath().getString("data." + atributo);
    }

    /**
     * Extrae datos del método de pago de la respuesta.
     * @param response La respuesta de la API.
     * @param atributo El nombre del atributo a extraer.
     * @return El valor de los datos del método de pago.
     */
    public String extraerDatosPaymentMethod(Response response, String atributo) {
        return response.jsonPath().getString("data.payment_method." + atributo);
    }

    /**
     * Extrae datos de error de la respuesta.
     * @param response La respuesta de la API.
     * @param atributo El nombre del atributo a extraer.
     * @return El valor de los datos de error.
     */
    public String extraerDatosRespuestaError(Response response, String atributo) {
        return response.jsonPath().getString("error." + atributo);
    }

    /**
     * Extrae mensajes de error relacionados con la llave pública de la respuesta.
     * @param response La respuesta de la API.
     * @param atributo El nombre del atributo a extraer.
     * @return El valor del mensaje de error relacionado con la llave pública.
     */
    public String extraerDatosMessagePublicKey(Response response, String atributo) {
        return response.jsonPath().getString("error.messages." + atributo +"[0]");
    }
}