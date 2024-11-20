/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;


import com.example.model.Noticia;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.Element;
import javax.swing.text.Document;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

/**
 *
 * @author AVILA_DEVELOPER
 */
@Service
public class NoticiaService {

    public List<Noticia> obtenerNoticias(String query) {
        List<Noticia> noticias = new ArrayList<>();
        try {
            // Realiza la consulta a la web de ABC
            String url = "https://www.abc.com.py/buscar/?query=" + query;
            org.jsoup.nodes.Document doc = Jsoup.connect(url).get();

            // Parsear las noticias de la respuesta
            for (org.jsoup.nodes.Element element : doc.select(".noticia")) { // Ajusta el selector CSS al HTML de la página
                Noticia noticia = new Noticia();
                noticia.setFecha(LocalDateTime.now()); // O extrae si hay una fecha en el HTML
                noticia.setEnlace(element.select("a").attr("href"));
                noticia.setEnlace_foto(element.select("img").attr("src"));
                noticia.setTitulo(element.select(".titulo").text());
                noticia.setResumen(element.select(".resumen").text());

                noticias.add(noticia);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al conectar con el sitio web", e);
        }
        return noticias;
    }
}