package com.onlyalec.oracleOne.LibreriaAPI.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DTOLibro(
        String title,
        List<DTOAutor> authors,
        List<String> languages,
        @JsonAlias("download_count") Integer downloadCount
) {
}


