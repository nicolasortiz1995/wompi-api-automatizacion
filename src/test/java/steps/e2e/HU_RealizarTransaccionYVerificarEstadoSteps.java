package steps.e2e;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.pages.ApiWompiPage;
import org.example.utils.ExtraerCamposHelper;
import org.example.utils.GenerarPayloads;
import org.example.utils.GlobalVariables;
import org.testng.Assert;

public class HU_RealizarTransaccionYVerificarEstadoSteps {
    private final ApiWompiPage apiPage = new ApiWompiPage();
    private final ExtraerCamposHelper metodosAuxiliares = new ExtraerCamposHelper();

    private Response response;
    private int statusCode;
    private String llavePublica;
    private String llaveIntegridad;
    private String aceptacionPrefirmada;
    private String prefirmadoPersonal;
    private String idTransaccion;
    private String datoCreacionTransaccion;

    @Given("que envío una petición GET a la API de Wompi al endpoint {string}")
    public void queEnvíoUnaPeticiónGETALaAPIDeWompiAlEndpoint(String endpoint) {
        response = apiPage.hacerPeticionGetConLlavePrivada(endpoint);
        statusCode = response.getStatusCode();
        System.out.println("Respuesta de la API: " + response.asString());
    }

    @When("la API responde exitosamente con un código de estado {int}")
    public void laAPIRespondeExitosamenteConUnCódigoDeEstado(int statusCodeBdd) {
        Assert.assertEquals(statusCode, statusCodeBdd, "Status code should be 200");
        System.out.println("✔ La API respondió exitosamente con el código de estado " + statusCode);
    }

    @Then("el campo {string} en la respuesta no debe estar vacío")
    public void elCampoEnLaRespuestaNoDebeEstarVacío(String llavePublicaBdd) {
        llavePublica = metodosAuxiliares.extraerLlavePublica(response, llavePublicaBdd);
        Assert.assertNotNull(llavePublica, "El campo no debe ser nulo");
        Assert.assertFalse(llavePublica.isEmpty(), "El campo no debe estar vacío");
        System.out.println("Valor de '" + llavePublicaBdd + "': " + llavePublica);
        System.out.println("✔ Se obtuvo correctamente la llave pública");
        GlobalVariables.globalLlavePublica = llavePublica;
    }

    @Then("obtengo la llave de integridad {string}")
    public void obtengoLaLlaveDeIntegridad(String llaveIntegridadBdd) {
        llaveIntegridad = metodosAuxiliares.extraerLlaveIntegridad(response, llaveIntegridadBdd);
        Assert.assertNotNull(llaveIntegridad, "El campo no debe ser nulo");
        Assert.assertFalse(llaveIntegridad.isEmpty(), "El campo no debe estar vacío");
        System.out.println("Valor de '" + llaveIntegridadBdd + "': " + llaveIntegridad);
        System.out.println("✔ Se obtuvo correctamente la llave de integridad");
        GlobalVariables.globalLlaveIntegridad = llaveIntegridad;
    }

    @Given("que realizo una petición al endpoint {string} con la llave pública correcta")
    public void queRealizoUnaPeticiónAlEndpointConLaLlavePúblicaCorrecta(String endpointBdd) {
        response = apiPage.hacerPeticionParaObtenerToken(GlobalVariables.globalLlavePublica, endpointBdd);
        statusCode = response.getStatusCode();
        System.out.println("✔ Se realizó la petición al endpoint " + endpointBdd + " con la llave pública correcta");
        System.out.println("Respuesta de la API: " + response.asString());
    }

    @Then("los campos de {string} en la respuesta no debe estar vacío")
    public void losCamposDeEnLaRespuestaNoDebeEstarVacío(String campoAceptacionToken) {
        aceptacionPrefirmada = metodosAuxiliares.extraerAceptacionPrefirmada(response, campoAceptacionToken);
        Assert.assertNotNull(aceptacionPrefirmada, "El campo no debe ser nulo");
        Assert.assertFalse(aceptacionPrefirmada.isEmpty(), "El campo no debe estar vacío");
        System.out.println("Valor de '" + campoAceptacionToken + "': " + aceptacionPrefirmada);
        System.out.println("✔ Se obtuvo correctamente la aceptación prefirmada");
        GlobalVariables.globalAceptacionPrefirmada = aceptacionPrefirmada;

        prefirmadoPersonal = metodosAuxiliares.extraerPrefirmadoPersonal(response, campoAceptacionToken);
        Assert.assertNotNull(prefirmadoPersonal, "El campo no debe ser nulo");
        Assert.assertFalse(prefirmadoPersonal.isEmpty(), "El campo no debe estar vacío");
        System.out.println("Valor de '" + campoAceptacionToken + "': " + prefirmadoPersonal);
        System.out.println("✔ Se obtuvo correctamente el prefirmado personal");
        GlobalVariables.globalPrefirmadoPersonal = prefirmadoPersonal;
        System.out.println("✔ Se verificaron los dos campos de token");
    }

    @Given("que envio una petición POST a la API de Wompi al endpoint {string} con el metodo de pago {string} y sandbox_status {string}")
    public void queEnvioUnaPeticiónPOSTALaAPIDeWompiAlEndpointConElMetodoDePagoYSandbox_status(String endpoint, String metodoPago, String sandBoxStatusBdd) {
        response = apiPage.hacerPeticionTransaccionesPostConPayload(endpoint, GenerarPayloads.payloadTransaccionE1(GlobalVariables.globalAceptacionPrefirmada, GlobalVariables.globalPrefirmadoPersonal, GlobalVariables.globalLlaveIntegridad, sandBoxStatusBdd));
        statusCode = response.getStatusCode();
        System.out.println("Respuesta de la API: " + response.asString());
        System.out.println("✔ Se realizó la petición al método de pago: " + metodoPago);
    }

    @Then("los campos {string} y {string} en la respuesta no debe estar vacío")
    public void losCamposYEnLaRespuestaNoDebeEstarVacío(String idTransaccionBdd, String datoCreacionTransaccionBdd) {
        idTransaccion = metodosAuxiliares.extraerDatosTransaccion(response, idTransaccionBdd);
        Assert.assertNotNull(idTransaccion, "El campo no debe ser nulo");
        Assert.assertFalse(idTransaccion.isEmpty(), "El campo no debe estar vacío");
        System.out.println("Valor de '" + idTransaccionBdd + "': " + idTransaccion);
        System.out.println("✔ Se obtuvo correctamente el id de la transacción");
        GlobalVariables.globalIdTransaccion = idTransaccion;

        datoCreacionTransaccion = metodosAuxiliares.extraerDatosTransaccion(response, datoCreacionTransaccionBdd);
        Assert.assertNotNull(datoCreacionTransaccion, "El campo no debe ser nulo");
        Assert.assertFalse(datoCreacionTransaccion.isEmpty(), "El campo no debe estar vacío");
        System.out.println("Valor de '" + datoCreacionTransaccionBdd + "': " + datoCreacionTransaccion);
        System.out.println("✔ Se obtuvo correctamente el dato de creación de la transacción");
        GlobalVariables.globalDatoCreacionTransaccion = datoCreacionTransaccion;
    }


}

