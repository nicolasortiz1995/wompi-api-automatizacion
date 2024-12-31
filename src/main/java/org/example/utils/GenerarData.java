package org.example.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class GenerarData {

    /**
     * Genera un monto aleatorio entre 100000 y 1090000.
     * @return Un monto aleatorio.
     */
    public static int generarMontoAleatorio() {
        Random random = new Random();
        return 100000 + random.nextInt(990001);
    }

    /**
     * Genera una referencia aleatoria con una longitud entre 10 y 20 caracteres.
     * @return Una referencia aleatoria.
     */
    public static String generarReferencia() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
        Random random = new Random();
        StringBuilder referencia = new StringBuilder();
        int longitud = 10 + random.nextInt(11);

        for (int i = 0; i < longitud; i++) {
            referencia.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return referencia.toString();
    }

    /**
     * Genera un correo electrónico aleatorio utilizando la librería Faker.
     * @return Un correo electrónico aleatorio.
     */
    public static String generarCorreoElectronicoAleatorio() {
        com.github.javafaker.Faker faker = new com.github.javafaker.Faker();
        return faker.internet().emailAddress();
    }

    /**
     * Genera un hash SHA-256 de una cadena de texto.
     * @param data La cadena de texto a hashear.
     * @return El hash SHA-256 de la cadena de texto.
     */
    public static String generarHashSHA256(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}