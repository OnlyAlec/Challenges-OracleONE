package com.onlyalec.oracleOne.ForoHub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record RegistroTopicoDTO(
        @NotBlank(message = "Debe de contener un 'Titulo'")
        String titulo,
        @NotBlank(message = "Debe de contener un 'Mensaje'")
        String mensaje,
        @NotBlank(message = "Debe de contener el ID del 'Autor'")
        String autor,
        @NotBlank(message = "Debe de contener el nombre del 'Curso'")
        String curso
) {
}