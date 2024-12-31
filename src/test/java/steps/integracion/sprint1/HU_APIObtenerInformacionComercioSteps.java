package steps.integracion.sprint1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.pages.ApiWompiPage;
import org.example.utils.ExtraerCamposHelper;
import org.testng.Assert;


public class HU_APIObtenerInformacionComercioSteps {
    private final ApiWompiPage apiPage = new ApiWompiPage();
    private final ExtraerCamposHelper metodosAuxiliares = new ExtraerCamposHelper();

    private Response response;
    private int statusCode;

    @Given("que envío una petición GET a la API de información del comercio al endpoint {string} con la llave privada incorrecta")
    public void queEnvíoUnaPeticiónGETALaAPIDeInformaciónDelComercioAlEndpointConLaLlavePrivadaIncorrecta(String endpoint) {
        response = apiPage.hacerPeticionGetAPIInformacionComercioLlaveErronea(endpoint);
        statusCode = response.getStatusCode();
        System.out.println("Respuesta de la API: " + response.asString());
    }

    @When("la API responde con un código de estado {int}")
    public void laAPIRespondeConUnCódigoDeEstado(int statusCodeBdd) {
        Assert.assertEquals(statusCode, statusCodeBdd, "Status code should be 401");
        System.out.println("✔ La API respondió con el código de estado " + statusCode);
    }

    @Then("el campo tipo {string} en la respuesta debe ser {string}")
    public void elCampoTipoEnLaRespuestaDebeSer(String campoJson, String contenidoEsperado) {
        String datoExtraido = metodosAuxiliares.extraerDatosRespuestaError(response,campoJson);
        Assert.assertEquals(datoExtraido, contenidoEsperado, "El campo " + campoJson + " debe ser " + contenidoEsperado);
        System.out.println("Valor de '" + campoJson + "': " + datoExtraido);
        System.out.println("✔ Se obtuvo correctamente el campo " + campoJson);
    }

    @Then("el campo razon {string} en la respuesta debe ser {string}")
    public void elCampoRazonEnLaRespuestaDebeSer(String campoJson, String contenidoEsperado) {
        String datoExtraido = metodosAuxiliares.extraerDatosRespuestaError(response,campoJson);
        Assert.assertEquals(datoExtraido, contenidoEsperado, "El campo " + campoJson + " debe ser " + contenidoEsperado);
        System.out.println("Valor de '" + campoJson + "': " + datoExtraido);
        System.out.println("✔ Se obtuvo correctamente el campo " + campoJson);
    }


    @Given("que envío una petición GET a la API de información del comercio al endpoint {string} sin headers")
    public void queEnvíoUnaPeticiónGETALaAPIDeInformaciónDelComercioAlEndpointSinHeaders(String endpoint) {
        response = apiPage.hacerPeticionGetAPIInformacionComercialSinHeaders(endpoint);
        statusCode = response.getStatusCode();
        System.out.println("Respuesta de la API: " + response.asString());
    }
}
