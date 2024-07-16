package com.onlyalec.oracleOne.LibreriaAPI.service;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.onlyalec.oracleOne.LibreriaAPI.model.DTOLibro;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DTOApi(
        @JsonAlias("results") List<DTOLibro> books
) {
}
