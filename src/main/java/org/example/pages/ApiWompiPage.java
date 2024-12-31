package org.example.pages;

import io.restassured.response.Response;
import org.example.utils.EnvironmentConfig;

import static io.restassured.RestAssured.given;

public class ApiWompiPage {
    private final String baseUrl = EnvironmentConfig.obtenerVariableEntorno("BASE_URL");
    private final String apiKey = EnvironmentConfig.obtenerVariableEntorno("API_KEY");

    public Response hacerPeticionGetConLlavePrivada(String endpoint) {
        return given()
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl+endpoint)
                .then()
                .extract()
                .response();
    }

    public Response hacerPeticionParaObtenerToken(String llavePublica, String endpoint){
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

    public Response hacerPeticionGetParaObtenerEstadoTransaccion(String endpoint, String idTransaccion){
        System.out.println("Id de la transacción: "+endpoint+idTransaccion);
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint + idTransaccion)
                .then()
                .extract()
                .response();
    }
}