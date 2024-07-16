package com.onlyalec.oracleOne.LibreriaAPI.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DTOAutor(
        String name,
        @JsonAlias("birth_year") Integer birthYear,
        @JsonAlias("death_year") Integer deathYear
) {
}
