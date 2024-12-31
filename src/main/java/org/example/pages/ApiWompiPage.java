package org.example.pages;

import io.restassured.response.Response;
import org.example.utils.ConfiguracionAmbiente;

import static io.restassured.RestAssured.given;

public class ApiWompiPage {
    private final String baseUrl = ConfiguracionAmbiente.obtenerVariableEntorno("BASE_URL");
    private final String apiKey = ConfiguracionAmbiente.obtenerVariableEntorno("API_KEY");

    public Response hacerPeticionGetConLlavePrivada(String endpoint) {
        return given()
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }

    public Response hacerPeticionParaObtenerToken(String llavePublica, String endpoint) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint + llavePublica)
                .then()
                .extract()
                .response();
    }

    public Response hacerPeticionTransaccionesPostConPayload(String endpoint, String payload) {
        return given()
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }

    public Response hacerPeticionGetParaObtenerEstadoTransaccion(String endpoint, String idTransaccion) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint + idTransaccion)
                .then()
                .extract()
                .response();
    }

    public Response hacerPeticionGetAPIInformacionComercioLlaveErronea(String endpoint) {
        return given()
                .header("Authorization", "Bearer prv_stagtest_5i0ZGIGiFcDQifYsXxvsny7Y37Error")
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }

    public Response hacerPeticionGetAPIInformacionComercialSinHeaders(String endpoint) {
        return given()
                .when()
                .get(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }

    public Response hacerPeticionGetAPITokenConLlaveErronea(String endpoint) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint + "pub_stagtest_g2u0HQd3ZMh05hsSgTS2lUV8t3sError")
                .then()
                .extract()
                .response();
    }

    public Response hacerPeticionGetAPITokenSinLlavePublica(String endpoint) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint )
                .then()
                .extract()
                .response();
    }

    public Response hacerPeticionGetAPITokenConLlaveConFormatoIncorrecto(String endpoint) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint + "000000000000000000000000000")
                .then()
                .extract()
                .response();
    }

    public Response hacerPeticionGetAPIEstadoTransaccionConIdIncorrecto(String endpoint){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint + "15113-1735659146-AAAAA")
                .then()
                .extract()
                .response();
    }

    public Response hacerPeticionGetAPIEstadoTransaccionConIdVacio(String endpoint){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }
}