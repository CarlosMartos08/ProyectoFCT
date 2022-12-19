package com.example.proyectofct.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlantillaControlador {

    @GetMapping("/resources/templates/anuncio.html")
    public String mostrarPlantilla(Model model) {
        model.addAttribute("mensaje", "Hola mundo!");
        return "anuncio.html";
    }


    @GetMapping("/resources/templates/propiedad.html")
    public String mostrarPlantillaPropiedad(Model model) {
        model.addAttribute("mensaje", "Hola mundo!");
        return "propiedad.html";
    }

}
