package org.iesch.ad.Ej2.controllers;

import org.iesch.ad.Ej2.models.dto.JwtAuthResponse;
import org.iesch.ad.Ej2.models.dto.LoginDTO;
import org.iesch.ad.Ej2.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {

    @Autowired
    AuthService authService;

    @GetMapping("/index")
    public String mostrarFormulario(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        return "index";
    }

    @PostMapping("/procesarFormulario")
    public String procesarFormulario(@ModelAttribute LoginDTO loginDTO, Model model) {
        model.addAttribute("loginDTO", loginDTO);

        System.out.println("LoginDTO: " + loginDTO); // Log the loginDTO

        String token = null;
        try {
            token = authService.login(loginDTO);
        } catch (Exception e) {
            System.err.println("Error during authentication: " + e.getMessage());
            model.addAttribute("error", "Error de autenticación. Por favor, inténtalo de nuevo.");
            return "index";
        }

        if (token != null) {
            System.out.println("Token: " + token); // Log the token
            model.addAttribute("token", token);
            return "token";
        } else {
            System.err.println("Authentication failed.");
            model.addAttribute("error", "Credenciales inválidas.");
            return "index";
        }
    }
}
