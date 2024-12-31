package org.example.utils;

public class GenerarPayloads {

    /**
     * Genera el payload para una transacción E1.
     *
     * @param acceptanceToken Token de aceptación.
     * @param acceptPersonalAuth Autenticación personal de aceptación.
     * @param llaveIntegridad Llave de integridad.
     * @param sandBoxStatus Estado del sandbox.
     * @return El payload de la transacción en formato JSON.
     */
    public static String payloadTransaccionE1(String acceptanceToken, String acceptPersonalAuth, String llaveIntegridad, String sandBoxStatus) {
        // Genera un monto aleatorio
        String montoAleatorio = String.valueOf(GenerarData.generarMontoAleatorio());
        // Genera una referencia aleatoria
        String referenciaAleatoria = GenerarData.generarReferencia();
        // Genera un correo electrónico aleatorio
        String correoAleatorio = GenerarData.generarCorreoElectronicoAleatorio();
        // Genera un hash SHA256 aleatorio
        String hashAleatorio = GenerarData.generarHashSHA256(referenciaAleatoria + montoAleatorio + "COP" + llaveIntegridad);

        // Asigna valores a variables globales
        VariablesGlobales.globalReferenciaAleatoria = referenciaAleatoria;
        VariablesGlobales.globalMontoAleatorio = montoAleatorio;

        // Imprime valores generados
        System.out.println("Referencia: " + referenciaAleatoria);
        System.out.println("Monto: " + montoAleatorio);
        System.out.println("Correo: " + correoAleatorio);
        System.out.println("Hash: " + hashAleatorio);

        // Retorna el payload en formato JSON
        return "{\n" +
                "    \"acceptance_token\": \"" + acceptanceToken + "\",\n" +
                "    \"accept_personal_auth\": \"" + acceptPersonalAuth + "\",\n" +
                "    \"amount_in_cents\": " + montoAleatorio + ",\n" +
                "    \"currency\": \"COP\",\n" +
                "    \"signature\": \"" + hashAleatorio + "\",\n" +
                "    \"customer_email\": \"" + correoAleatorio + "\",\n" +
                "    \"reference\": \"" + referenciaAleatoria + "\",\n" +
                "    \"payment_method\": {\n" +
                "        \"type\": \"BANCOLOMBIA_QR\",\n" +
                "        \"payment_description\": \"Pago a Tienda Wompi TC Bancolombia QR\",\n" +
                "        \"sandbox_status\": \"" + sandBoxStatus + "\"\n" +
                "    }\n" +
                "}";
    }
}