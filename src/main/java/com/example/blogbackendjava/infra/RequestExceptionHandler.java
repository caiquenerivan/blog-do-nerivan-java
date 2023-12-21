package com.example.blogbackendjava.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(){
        ExceptionDTO response = new ExceptionDTO("Dado não encontrado", 404);
        return ResponseEntity.badRequest().body(response);
    }
}
