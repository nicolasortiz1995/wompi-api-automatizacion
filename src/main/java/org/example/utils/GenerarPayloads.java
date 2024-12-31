package org.example.utils;

public class GenerarPayloads {
    public static String payloadTransaccionE1(String acceptanceToken, String acceptPersonalAuth, String llaveIntegridad, String sandBoxStatus) {
        String montoAleatorio = String.valueOf(GenerarData.generarMontoAleatorio());
        String referenciaAleatoria = GenerarData.generarReferencia();
        String correoAleatorio = GenerarData.generarCorreoElectronicoAleatorio();
        String hashAleatorio = GenerarData.generarHashSHA256(referenciaAleatoria + montoAleatorio + "COP" + llaveIntegridad);

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
