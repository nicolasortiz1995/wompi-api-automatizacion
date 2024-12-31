package org.example.utils;

import io.restassured.response.Response;

public class ExtraerCamposHelper {
    public String extraerLlavePublica(Response response, String atributo) {
        return response.jsonPath().getString("data[0]." + atributo);
    }

    public String extraerLlaveIntegridad(Response response, String atributo) {
        return response.jsonPath().getString("data[0].secrets." + atributo);
    }

    public String extraerAceptacionPrefirmada(Response response, String atributo) {
        return response.jsonPath().getString("data.presigned_acceptance." + atributo);
    }

    public String extraerPrefirmadoPersonal(Response response, String atributo) {
        return response.jsonPath().getString("data.presigned_personal_data_auth." + atributo);
    }

    public String extraerDatosTransaccion(Response response, String atributo) {
        return response.jsonPath().getString("data." + atributo);
    }

    public String extraerDatosPaymentMethod(Response response, String atributo) {
        return response.jsonPath().getString("data.payment_method." + atributo);
    }

    public String extraerDatosRespuestaError(Response response, String atributo) {
        return response.jsonPath().getString("error." + atributo);
    }

    public String extraerDatosMessagePublicKey(Response response, String atributo) {
        return response.jsonPath().getString("error.messages." + atributo +"[0]");
    }
}
