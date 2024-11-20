/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controllers;

import com.example.exception.ApiException;
import com.example.model.Noticia;
import com.example.service.NoticiaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AVILA_DEVELOPER
 */
@RestController
@RequestMapping("/consulta")
public class NoticiaController {
    private final NoticiaService noticiaService;

    public NoticiaController(NoticiaService noticiaService) {
        this.noticiaService = noticiaService;
    }

    @GetMapping
    public ResponseEntity<?> consultaNoticias(@RequestParam(required = false) String q) {
        if (q == null || q.isEmpty()) {
            throw new ApiException("g268", "Parámetros inválidos");
        }

        List<Noticia> noticias = noticiaService.obtenerNoticias(q);
        if (noticias.isEmpty()) {
            throw new ApiException("g267", "No se encuentran noticias para el texto: " + q);
        }

        return ResponseEntity.ok(noticias);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> manejarErrores(ApiException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getCodigo(), ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejarErroresGenerales(Exception ex) {
        return new ResponseEntity<>(
                new ErrorResponse("g100", "Error interno del servidor"),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    static class ErrorResponse {
        private final String codigo;
        private final String error;

        public ErrorResponse(String codigo, String error) {
            this.codigo = codigo;
            this.error = error;
        }

        // Getters

        public String getCodigo() {
            return codigo;
        }

        public String getError() {
            return error;
        }
        
    }
}
