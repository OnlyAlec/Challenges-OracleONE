package com.onlyalec.oracleOne.ForoHub.infra.errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class errorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity notFound404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity badRequest400(MethodArgumentNotValidException e) {
        var errores = e.getFieldErrors().stream().map(errorValidatorDTO::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    private record errorValidatorDTO(String campo, String error) {
        public errorValidatorDTO(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
