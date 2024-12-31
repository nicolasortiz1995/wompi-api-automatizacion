package org.example.pages;

import io.restassured.response.Response;
import org.example.utils.ConfiguracionAmbiente;

import static io.restassured.RestAssured.given;

public class ApiWompiPage {
    private final String baseUrl = ConfiguracionAmbiente.obtenerVariableEntorno("BASE_URL");
    private final String apiKey = ConfiguracionAmbiente.obtenerVariableEntorno("API_KEY");

    /**
     * Realiza una petición GET con la llave privada.
     *
     * @param endpoint El endpoint al cual se realizará la petición.
     * @return La respuesta de la petición.
     */
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

    /**
     * Realiza una petición GET para obtener un token utilizando una llave pública.
     *
     * @param llavePublica La llave pública a utilizar en la petición.
     * @param endpoint El endpoint al cual se realizará la petición.
     * @return La respuesta de la petición.
     */
    public Response hacerPeticionParaObtenerToken(String llavePublica, String endpoint) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint + llavePublica)
                .then()
                .extract()
                .response();
    }

    /**
     * Realiza una petición POST para transacciones con un payload.
     *
     * @param endpoint El endpoint al cual se realizará la petición.
     * @param payload El payload a enviar en la petición.
     * @return La respuesta de la petición.
     */
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

    /**
     * Realiza una petición GET para obtener el estado de una transacción.
     *
     * @param endpoint El endpoint al cual se realizará la petición.
     * @param idTransaccion El ID de la transacción a consultar.
     * @return La respuesta de la petición.
     */
    public Response hacerPeticionGetParaObtenerEstadoTransaccion(String endpoint, String idTransaccion) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint + idTransaccion)
                .then()
                .extract()
                .response();
    }

    /**
     * Realiza una petición GET a la API de información de comercio con una llave errónea.
     *
     * @param endpoint El endpoint al cual se realizará la petición.
     * @return La respuesta de la petición.
     */
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

    /**
     * Realiza una petición GET a la API de información comercial sin headers.
     *
     * @param endpoint El endpoint al cual se realizará la petición.
     * @return La respuesta de la petición.
     */
    public Response hacerPeticionGetAPIInformacionComercialSinHeaders(String endpoint) {
        return given()
                .when()
                .get(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }

    /**
     * Realiza una petición GET a la API para obtener un token con una llave errónea.
     *
     * @param endpoint El endpoint al cual se realizará la petición.
     * @return La respuesta de la petición.
     */
    public Response hacerPeticionGetAPITokenConLlaveErronea(String endpoint) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint + "pub_stagtest_g2u0HQd3ZMh05hsSgTS2lUV8t3sError")
                .then()
                .extract()
                .response();
    }

    /**
     * Realiza una petición GET a la API para obtener un token sin llave pública.
     *
     * @param endpoint El endpoint al cual se realizará la petición.
     * @return La respuesta de la petición.
     */
    public Response hacerPeticionGetAPITokenSinLlavePublica(String endpoint) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }

    /**
     * Realiza una petición GET a la API para obtener un token con una llave con formato incorrecto.
     *
     * @param endpoint El endpoint al cual se realizará la petición.
     * @return La respuesta de la petición.
     */
    public Response hacerPeticionGetAPITokenConLlaveConFormatoIncorrecto(String endpoint) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint + "000000000000000000000000000")
                .then()
                .extract()
                .response();
    }

    /**
     * Realiza una petición GET a la API para obtener el estado de una transacción con un ID incorrecto.
     *
     * @param endpoint El endpoint al cual se realizará la petición.
     * @return La respuesta de la petición.
     */
    public Response hacerPeticionGetAPIEstadoTransaccionConIdIncorrecto(String endpoint) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint + "15113-1735659146-AAAAA")
                .then()
                .extract()
                .response();
    }

    /**
     * Realiza una petición GET a la API para obtener el estado de una transacción con un ID vacío.
     *
     * @param endpoint El endpoint al cual se realizará la petición.
     * @return La respuesta de la petición.
     */
    public Response hacerPeticionGetAPIEstadoTransaccionConIdVacio(String endpoint) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }
}