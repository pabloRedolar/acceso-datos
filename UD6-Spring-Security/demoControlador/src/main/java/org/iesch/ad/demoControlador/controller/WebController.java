package org.iesch.ad.demoControlador.controller;

import org.iesch.ad.demoControlador.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("texto", "esto es un texto");
        return "index"; //index.html
    }

    @GetMapping("formulario")
    public String formulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario"; //index.html
    }

    @PostMapping("/procesarFormulario")
    public String procesarFormulario(@ModelAttribute Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario);

        return "resultado";
    }
}
