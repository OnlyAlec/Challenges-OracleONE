package com.onlyalec.oracleOne.LibreriaAPI.model;

public enum Idioma {
    ES("es"),
    EN("en");

    final String idiomaLower;

    Idioma(String idiomaLower) {
        this.idiomaLower = idiomaLower;
    }

    public static Idioma fromString(String text) {
        for (Idioma i : Idioma.values()) {
            if (i.idiomaLower.equalsIgnoreCase(text)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Idioma no reconocido: " + text);
    }
}
