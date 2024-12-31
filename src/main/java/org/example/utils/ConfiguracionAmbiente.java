package org.example.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfiguracionAmbiente {
    private static final Dotenv dotenv = Dotenv.load();

    /**
     * Obtiene el valor de una variable de entorno.
     *
     * @param key La clave de la variable de entorno.
     * @return El valor de la variable de entorno.
     */
    public static String obtenerVariableEntorno(String key) {
        return dotenv.get(key);
    }
}