package steps.integracion.sprint3;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.pages.ApiWompiPage;
import org.example.utils.ExtraerCamposHelper;
import org.testng.Assert;

public class HU_APIObtenerEstadoDeUnaTransaccionSteps {
    private final ApiWompiPage apiPage = new ApiWompiPage();
    private final ExtraerCamposHelper metodosAuxiliares = new ExtraerCamposHelper();

    private Response response;
    private int statusCode;

    @Given("que envío una petición GET a la API de estado de una transacción al endpoint {string} con el id de transacción incorrecto")
    public void queEnvíoUnaPeticiónGETALaAPIDeEstadoDeUnaTransacciónAlEndpointConElIdDeTransacciónIncorrecto(String endpoint) {
        response = apiPage.hacerPeticionGetAPIEstadoTransaccionConIdIncorrecto(endpoint);
        statusCode = response.getStatusCode();
        System.out.println("Respuesta de la API: " + response.asString());
    }

    @When("la API de estado de una transacción responde con un código de estado {int}")
    public void laAPIDeEstadoDeUnaTransacciónRespondeConUnCódigoDeEstado(int statusCodeBdd) {
        Assert.assertEquals(statusCode, statusCodeBdd, "Status code should be "+statusCodeBdd);
        System.out.println("✔ La API respondió con el código de estado " + statusCode);
    }

    @Then("el campo tipo {string} en la respuesta de la transacción debe ser {string}")
    public void elCampoTipoEnLaRespuestaDeLaTransacciónDebeSer(String campoJson, String contenidoEsperado) {
        String datoExtraido = metodosAuxiliares.extraerDatosRespuestaError(response,campoJson);
        Assert.assertEquals(datoExtraido, contenidoEsperado, "El campo " + campoJson + " debe ser " + contenidoEsperado);
        System.out.println("Valor de '" + campoJson + "': " + datoExtraido);
        System.out.println("✔ Se obtuvo correctamente el campo " + campoJson);
    }

    @Then("el campo razon {string} en la respuesta de la transacción debe ser {string}")
    public void elCampoRazonEnLaRespuestaDeLaTransacciónDebeSer(String campoJson, String contenidoEsperado) {
        String datoExtraido = metodosAuxiliares.extraerDatosRespuestaError(response,campoJson);
        Assert.assertEquals(datoExtraido, contenidoEsperado, "El campo " + campoJson + " debe ser " + contenidoEsperado);
        System.out.println("Valor de '" + campoJson + "': " + datoExtraido);
        System.out.println("✔ Se obtuvo correctamente el campo " + campoJson);
    }

    @Given("que envío una petición GET a la API de estado de una transacción al endpoint {string} con el id de transacción vacío")
    public void queEnvíoUnaPeticiónGETALaAPIDeEstadoDeUnaTransacciónAlEndpointConElIdDeTransacciónVacío(String endpoint) {
        response = apiPage.hacerPeticionGetAPIEstadoTransaccionConIdVacio(endpoint);
        statusCode = response.getStatusCode();
        System.out.println("Respuesta de la API: " + response.asString());
    }
}
