package steps.integracion.sprint2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.pages.ApiWompiPage;
import org.example.utils.ExtraerCamposHelper;
import org.testng.Assert;

public class HU_APIObtenerInformacionDeAutenticacionYTokensSteps {
    private final ApiWompiPage apiPage = new ApiWompiPage();
    private final ExtraerCamposHelper metodosAuxiliares = new ExtraerCamposHelper();

    private Response response;
    private int statusCode;

    @Given("que envío una petición GET a la API de autenticación al endpoint {string} con la llave publica incorrecta")
    public void queEnvíoUnaPeticiónGETALaAPIDeAutenticaciónAlEndpointConLaLlavePublicaIncorrecta(String endpoint) {
        response = apiPage.hacerPeticionGetAPITokenConLlaveErronea(endpoint);
        statusCode = response.getStatusCode();
        System.out.println("Respuesta de la API: " + response.asString());
    }

    @When("la API de autenticación responde con un código de estado {int}")
    public void laAPIDeAutenticaciónRespondeConUnCódigoDeEstado(int statusCodeBdd) {
        Assert.assertEquals(statusCode, statusCodeBdd, "Status code should be 401");
        System.out.println("✔ La API respondió con el código de estado " + statusCode);
    }


    @Then("el campo tipo {string} en la respuesta de la autenticación debe ser {string}")
    public void elCampoTipoEnLaRespuestaDeLaAutenticaciónDebeSer(String campoJson, String contenidoEsperado) {
        String datoExtraido = metodosAuxiliares.extraerDatosRespuestaError(response,campoJson);
        Assert.assertEquals(datoExtraido, contenidoEsperado, "El campo " + campoJson + " debe ser " + contenidoEsperado);
        System.out.println("Valor de '" + campoJson + "': " + datoExtraido);
        System.out.println("✔ Se obtuvo correctamente el campo " + campoJson);
    }

    @Then("el campo razon {string} en la respuesta de la autenticación debe ser {string}")
    public void elCampoRazonEnLaRespuestaDeLaAutenticaciónDebeSer(String campoJson, String contenidoEsperado) {
        String datoExtraido = metodosAuxiliares.extraerDatosRespuestaError(response,campoJson);
        Assert.assertEquals(datoExtraido, contenidoEsperado, "El campo " + campoJson + " debe ser " + contenidoEsperado);
        System.out.println("Valor de '" + campoJson + "': " + datoExtraido);
        System.out.println("✔ Se obtuvo correctamente el campo " + campoJson);
    }

    @Given("que envío una petición GET a la API de autenticación al endpoint {string} sin la llave publica")
    public void queEnvíoUnaPeticiónGETALaAPIDeAutenticaciónAlEndpointSinLaLlavePublica(String endpoint) {
        response = apiPage.hacerPeticionGetAPITokenSinLlavePublica(endpoint);
        statusCode = response.getStatusCode();
        System.out.println("Respuesta de la API: " + response.asString());
    }

    @Given("que envío una petición GET a la API de autenticación al endpoint {string} con la llave publica con formato erróneo")
    public void queEnvíoUnaPeticiónGETALaAPIDeAutenticaciónAlEndpointConLaLlavePublicaConFormatoErróneo(String endpoint) {
        response = apiPage.hacerPeticionGetAPITokenConLlaveConFormatoIncorrecto(endpoint);
        statusCode = response.getStatusCode();
        System.out.println("Respuesta de la API: " + response.asString());
    }


    @Then("el campo mensaje {string} en la respuesta de la autenticación debe ser {string}")
    public void elCampoMensajeEnLaRespuestaDeLaAutenticaciónDebeSer(String campoJson, String contenidoEsperado) {
        String datoExtraido = metodosAuxiliares.extraerDatosMessagePublicKey(response,campoJson);
        Assert.assertEquals(datoExtraido, contenidoEsperado, "El campo " + campoJson + " debe ser " + contenidoEsperado);
        System.out.println("Valor de '" + campoJson + "': " + datoExtraido);
        System.out.println("✔ Se obtuvo correctamente el campo " + campoJson);
    }
}
