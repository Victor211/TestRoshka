/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;

/**
 *
 * @author AVILA_DEVELOPER
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Noticia {

    private LocalDateTime fecha;
    private String enlace;
    private String enlace_foto;
    private String titulo;
    private String resumen;
    private String contenido_foto; 
    private String content_type_foto; 

    // Getters y setters
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getEnlace_foto() {
        return enlace_foto;
    }

    public void setEnlace_foto(String enlace_foto) {
        this.enlace_foto = enlace_foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getContenido_foto() {
        return contenido_foto;
    }

    public void setContenido_foto(String contenido_foto) {
        this.contenido_foto = contenido_foto;
    }

    public String getContent_type_foto() {
        return content_type_foto;
    }

    public void setContent_type_foto(String content_type_foto) {
        this.content_type_foto = content_type_foto;
    }

}
